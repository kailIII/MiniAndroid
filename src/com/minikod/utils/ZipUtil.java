package com.minikod.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 
 * @author CaYLaK
 *
 */
public class ZipUtil {

	public static boolean zip(byte[] data, String fileName, String path)
			throws Exception {
		String TAG = "ZipUtil : ";

		File pathFile = new File(path);
		pathFile.mkdirs();
		String zipName = path + "\\" + fileName + ".zip";
		File file = new File(zipName);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream os = null;
		ZipOutputStream out = null;
		try {
			os = new FileOutputStream(file);
			out = new ZipOutputStream(os);
			String tmp = new String(fileName.getBytes("UTF-8"));
			tmp = unicodeEscape(tmp);
			ZipEntry entry = new ZipEntry(tmp + ".xml");
			out.putNextEntry(entry);
			out.write(data);
			out.flush();
			out.closeEntry();
			out.flush();
			out.finish();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(TAG + " Error " + e.toString());
			throw e;
		} finally {
			out.close();
			os.close();
		}

		return true;
	}

	private static String unicodeEscape(String s) {
		StringBuilder sb = new StringBuilder();
		boolean first = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (checkTurkish(c)) {
				sb.append(c);
			} else {
				if (checkAscii(c)) {
					sb.append(c);
				} else {
					if (!first) {
						sb.append("");
					}
				}
				first = !first;
			}
		}
		return sb.toString();
	}

	public static boolean checkAscii(char c) {
		int hv = Integer.parseInt(Integer.toString(c));
		if (hv < 32 || hv > 126) {
			return false;
		}
		return true;
	}

	public static boolean checkTurkish(char c) {
		if (!(c == '\u011E' || c == '\u011F' || c == '\u015E' || c == '\u015F'
				|| c == '\u0130' || c == '\u0131' || c == '\u00DC'
				|| c == '\u00FC' || c == '\u00C7' || c == '\u00E7'
				|| c == '\u00D6' || c == '\u00F6')) {
			return false;
		}
		return true;
	}
}
