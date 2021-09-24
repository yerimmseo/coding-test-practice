package level1;

import java.util.HashMap;
import java.util.Map;

// N = 스테이지 개수
// 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
public class FailureRate {
	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		int[] rank = new int[N];
		int user = stages.length;
		Map<Integer, Integer> stage = new HashMap<>();
		Map<Integer, Double> fail = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			rank[i] = i + 1;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < stages.length; j++) {
				if (i == stages[j]) {
					stage.put(i, stage.getOrDefault(i, 0) + 1);
				} else {
					stage.put(i, stage.getOrDefault(i, 0));
				}
			}
		}

		int i = 1;
		for (int key : stage.keySet()) {
			fail.put(i, stage.get(key) / (double)user);
			i++;
			user = user - stage.get(key);
		}
		
		for (int j = 0; j < rank.length; j++) {
			for (int k = 0; k < rank.length - 1; k++) {
				if (fail.get(rank[k]) < fail.get(rank[k + 1])) {
					int tmp = rank[k + 1];
					rank[k + 1] = rank[k];
					rank[k] = tmp;
				}
			}
		}
		return answer;
	}
}
