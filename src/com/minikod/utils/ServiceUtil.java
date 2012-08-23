package com.minikod.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 
 * @author CaYLaK
 *
 */
public class ServiceUtil {

	public static boolean checkInternetWM(Context context) {
		Object systemService = context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		ConnectivityManager connect = (ConnectivityManager) systemService;
		if (connect.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED
				|| connect.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {
			return true;
		}
		return false;
	}

	public static boolean checkInternetW(Context context) {
		Object systemService = context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		ConnectivityManager connect = (ConnectivityManager) systemService;
		if (connect.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
			return true;
		}
		return false;
	}

	public static boolean checkInternetM(Context context) {
		Object systemService = context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		ConnectivityManager connect = (ConnectivityManager) systemService;
		if (connect.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED) {
			return true;
		}
		return false;
	}
}
