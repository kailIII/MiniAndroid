package com.minikod.utils;

import android.content.res.Resources;

/**
 * 
 * @author CaYLaK
 *
 */
public class ResourceUtil {

	protected static Resources res;
	protected static String TAG = ResourceUtil.class.getSimpleName();

	public static String getText(int bundle) {
		String result = null;
		try {
			result = res.getString(bundle);
		} catch (Exception e) {
			LogUtils.addError(TAG, e);
			result = "";
		}
		return result;
	}

	public static void setRes(Resources res) {
		ResourceUtil.res = res;
	}
	
	
}
