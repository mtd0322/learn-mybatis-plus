package org.alan.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class CookieHelper {

	public static String getCookieValue(String key, HttpServletRequest httpRequest) {
		Cookie c = getCookie(key, httpRequest);
		return c == null ? null : c.getValue();
	}

	private static Cookie getCookie(String key, HttpServletRequest httpRequest) {
		if (key != null && httpRequest != null) {
			Cookie[] cookies = httpRequest.getCookies();
			if (Objects.nonNull(cookies)) {
				for (Cookie c : cookies) {
					if (key.equals(c.getName())) {
						return c;
					}
				}
			}
		}
		return null;
	}

	public static void setCookie(String key, String value, int maxage, HttpServletRequest httpRequest,
			HttpServletResponse httpResponse) {
		if (Objects.nonNull(httpRequest)) {
			if (httpRequest != null) {
				Cookie c = getCookie(key, httpRequest);
				if (c != null) {
					c.setValue(value);
				}
			}

			if (httpResponse != null) {
				Cookie cookie = new Cookie(key, value);
				cookie.setPath("/");
				cookie.setMaxAge(maxage);
				httpResponse.addCookie(cookie);
			}
		}
	}

}
