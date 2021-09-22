package level1;

public class NewIdSuggest {
	
	public String solution(String new_id) {
		String answer = "";
		
		// 1�ܰ�
		answer = new_id.toLowerCase();
		// 2�ܰ�
		answer = answer.replaceAll("[^0-9a-z_.-]+", "");
		// 3�ܰ�
		answer = answer.replaceAll("[.]{2,}", ".");
		// 4�ܰ�
		answer = answer.replaceAll("^[.]", "");
		answer = answer.replaceAll("[.]$", "");
		// 5�ܰ�
		if (answer.isEmpty()) {
			for (int i = 0; i < new_id.length(); i++) {
				answer += "a";
			}
		}
		// 6�ܰ�
		if (answer.length() > 15) {
			answer = answer.substring(0, 15).replaceAll("[.]$", "");
		}
		// 7�ܰ�
		if (answer.length() <= 2) {
			while (answer.length() != 3) {
				answer += answer.substring(answer.length() - 1);
			}
		}
		System.out.println(answer);
		return answer;
	}
}
