package com.cuckoo.cms.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	public static boolean checkPattern(String str, String pattern) {

		boolean flag = false;
		try {
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(str);
			flag = m.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}