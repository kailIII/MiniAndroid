package com.minikod.bean;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 
 * @author CaYLaK
 *
 */

@SuppressWarnings("serial")
public class SessionBean implements Serializable {

	private static HashMap<String, Object> session = new HashMap<String, Object>();

	public static void setObject(String name, Object object) {
		if (name != null && name.trim().length() > 0) {
			if (object != null) {
				if (session.containsKey(name)) {
					session.remove(name);
					session.put(name, object);
				} else {
					session.put(name, object);
				}
			}
			// else {
			// throw new Exception("Cannot be set null value");
			// }
		}
		// else {
		// throw new Exception("Cannot be set null value name");
		// }
	}

	public static Object getObject(String name) {
		if (name != null && name.trim().length() > 0) {
			if (session.containsKey(name)) {
				return session.get(name);
			} else {
				return null;
			}
		} else {
			return null;
			// throw new Exception("Cannot be found null value name");
		}
	}

	public static void reset() {
		session = new HashMap<String, Object>();
	}

	public static HashMap<String, Object> getSession() {
		return session;
	}
}
