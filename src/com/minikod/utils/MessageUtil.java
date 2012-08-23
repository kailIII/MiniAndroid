package com.minikod.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 
 * @author CaYLaK
 *
 */
public class MessageUtil {

	public static void makeToast(Context context, String msg, boolean islong) {
		Toast.makeText(context, msg,
				islong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT).show();
	}
}
