package com.minikod.utils;

import android.util.Log;
/**
 * 
 * @author CaYLaK
 *
 */
public class LogUtils {

	public static void addError(String TAG, String msg) {
		Log.e(TAG, msg);
	}

	public static void addInfo(String TAG, String msg) {
		Log.i(TAG, msg);
	}

	public static void addWarning(String TAG, String msg) {
		Log.w(TAG, msg);
	}

	public static void addError(String TAG, Exception e) {
		Log.e(TAG, "", e);
	}
}
