package level1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class NotFinishPlayer {
	public String solution(String[] participant, String[] completion) {
		Map<String, Integer> check = new HashMap<>();
		
		// HashMap.getOrDefault : 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메서드
		for (String name : participant) {
			check.put(name, check.getOrDefault(name, 0) + 1);
		}

		for (String name : completion) {
			if (check.get(name) > 0) {
				check.replace(name, check.get(name) - 1);
			}
		}
		
		for (Entry<String, Integer> entry : check.entrySet()) {
			if (entry.getValue() > 0) {
				return entry.getKey();
			}
		}
		return null;
	}
}
