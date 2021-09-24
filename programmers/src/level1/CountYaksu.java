package level1;

public class CountYaksu {
	public int solution(int left, int right) {
		int answer = 0;
		
		for (int start = left; start <= right; start++) {
			int count = 0;
			for (int j = 1; j <= start; j++) {
				if (start % j == 0) {
					count++;
				}
			}
			if (count % 2 == 0) {
				answer += start;
			} else {
				answer -= start;
			}
		}
		return answer;
	}
}
