package level1;

import java.util.HashMap;
import java.util.Map;

public class Exam {
	public int[] solution(int[] answers) {
		int[] student1 = {1, 2, 3, 4, 5};
		int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		Map<Integer, Integer> score = new HashMap<>();
		
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == student1[i % student1.length]) {
				score.put(1, score.getOrDefault(1, 0) + 1);
			}
			if (answers[i] == student2[i % student2.length]) {
				score.put(2, score.getOrDefault(2, 0) + 1);
			}
			if (answers[i] == student3[i % student3.length]) {
				score.put(3, score.getOrDefault(3, 0) + 1);
			}
		}

		int max = 0;
		for (int key : score.keySet()) {
			if (max < score.get(key)) {
				max = score.get(key);
			}
		}
		
		int count = 0;
		for (int key : score.keySet()) {
			if (max == score.get(key)) {
				count++;
			}
		}
		
		int[] answer = new int[count];
		int i = 0;
		for (int key : score.keySet()) {
			if (max == score.get(key)) {
				answer[i] = key;
				i++;
			}
		}

		return answer;
	}
}
