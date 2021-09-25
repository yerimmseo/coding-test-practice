package level2;

import java.util.HashMap;
import java.util.Map;

public class OpenChatting {
	public String[] solution(String[] record) {
		String[] answer;
		Map<String, String> userInfo = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < record.length; i++) {
			String[] split = record[i].split(" ");
			if (split.length > 2) {
				userInfo.put(split[1], split[2]);
			}
		}
		
		for (int i = 0; i < record.length; i++) {
			String[] split = record[i].split(" ");
			if (split[0].charAt(0) == 'E') {
				sb.append(userInfo.get(split[1]) + "���� ���Խ��ϴ�./");
			} 
			if (split[0].charAt(0) == 'L') {
				sb.append(userInfo.get(split[1]) + "���� �������ϴ�./");
			}
		}
		
		answer = sb.toString().split("/");
		return answer;
	}
}
