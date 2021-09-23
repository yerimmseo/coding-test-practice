package level1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class NotFinishPlayer {
	public String solution(String[] participant, String[] completion) {
		Map<String, Integer> check = new HashMap<>();
		
		// HashMap.getOrDefault : ã�� Ű�� �����Ѵٸ� ã�� Ű�� ���� ��ȯ�ϰ� ���ٸ� �⺻ ���� ��ȯ�ϴ� �޼���
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
