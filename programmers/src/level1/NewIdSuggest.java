package level1;

public class NewIdSuggest {
	
	public String solution(String new_id) {
		String answer = "";
		
		// 1단계
		answer = new_id.toLowerCase();
		// 2단계
		answer = answer.replaceAll("[^0-9a-z_.-]+", "");
		// 3단계
		answer = answer.replaceAll("[.]{2,}", ".");
		// 4단계
		answer = answer.replaceAll("^[.]", "");
		answer = answer.replaceAll("[.]$", "");
		// 5단계
		if (answer.isEmpty()) {
			for (int i = 0; i < new_id.length(); i++) {
				answer += "a";
			}
		}
		// 6단계
		if (answer.length() > 15) {
			answer = answer.substring(0, 15).replaceAll("[.]$", "");
		}
		// 7단계
		if (answer.length() <= 2) {
			while (answer.length() != 3) {
				answer += answer.substring(answer.length() - 1);
			}
		}
		System.out.println(answer);
		return answer;
	}
}
