package level1;

public class NewIdSuggest {
	public String solution(String new_id) {
		String answer = "";

		answer = new_id.toLowerCase();
		answer = answer.replaceAll("[^0-9a-z_.-]+", "");
		answer = answer.replaceAll("[.]{2,}", ".");
		answer = answer.replaceAll("^[.]", "");
		answer = answer.replaceAll("[.]$", "");

		if (answer.isEmpty()) {
			for (int i = 0; i < new_id.length(); i++) {
				answer += "a";
			}
		}

		if (answer.length() > 15) {
			answer = answer.substring(0, 15).replaceAll("[.]$", "");
		}

		if (answer.length() <= 2) {
			while (answer.length() != 3) {
				answer += answer.substring(answer.length() - 1);
			}
		}
		return answer;
	}
}
