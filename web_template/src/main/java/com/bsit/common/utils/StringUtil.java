package com.bsit.common.utils;

public class StringUtil {
	
	public static boolean isEmptyStr(String str) {
		if (null == str || "".equals(str.trim())) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Object s) {
		if (null == s) {
			return true;
		} else if ("".equals(s.toString()) || "".equals(s.toString().trim())
				|| "null".equalsIgnoreCase(s.toString())) {
			return true;
		} else {
			return false;
		}
	}

	public static String toHtml(String src) {
		String htmlStr = "";
		for (int i = 0; i != src.length(); i++) {
			int str = src.codePointAt(i);
			htmlStr = htmlStr + "&#" + str + ";";
		}
		return htmlStr;
	}

	public static void main(String[] args) {
		System.out.println(genRandomStr(10));
	}

	public static Long createSqp(String dev_code) {
		String str = "";
		for (int i = dev_code.length() - 1; i >= 0; i--) {
			if (dev_code.charAt(i) >= '0' && dev_code.charAt(i) <= '9') {
				str += dev_code.charAt(i);
			} else {
				break;
			}
		}
		System.out.println(str);
		String str1 = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			str1 += str.charAt(i);
		}
		return Long.valueOf(str1);
	}
	
	public static String genRandomStr(int n)
    {
        String s = "0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
        {
            int j = (int)(Math.random() * 10);
            sb.append(s.charAt(j));
        }
        return sb.toString();
    }
}
