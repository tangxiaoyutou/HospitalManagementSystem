package util;

public class StringUtil {
	public static boolean isEmpty(String str) {
		if("".equals(str) || str == null)
			return true;
		return false;
	}
	public static String changeNull(String str) {
		if(str == null)
			return "";
		return str.trim();
	}
}
