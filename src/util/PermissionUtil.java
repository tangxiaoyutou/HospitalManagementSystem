package util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PermissionUtil {
	//判断str1的权限是否大于str2
	public static boolean isHavePermission(String str1, String str2) {
		Map<String, Integer> map = new HashMap<>();
		map.put("院长", 6);
		map.put("主任", 5);
		map.put("副主任", 4);
		map.put("医生", 3);
		map.put("护士", 2);
		int value1 = 0, value2 = 0;
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			if(entry.getKey().equals(str1))
				value1 = entry.getValue();
			if(entry.getKey().equals(str2))
				value2 = entry.getValue();
		}
		//System.out.println(value1 + " " + value2);
		if(value1 - value2 > 0 && value1 != 0)
			return true;
		return false;
	}
}
