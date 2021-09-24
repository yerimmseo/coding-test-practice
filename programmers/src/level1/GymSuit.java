package level1;

public class GymSuit {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n;
		int[] student = new int[n];
		
		for (int i = 0; i < n; i++) {
			student[i] = 1;
		}
		
		for (int l : lost) {
			student[l - 1]--;
		}

		for (int r : reserve) {
			student[r - 1]++;
		}
		
		for (int i = 0; i < student.length; i++) {
			if (student[i] == 0) {
				if (0 <= i - 1 && student[i - 1] == 2) {
					student[i - 1]--;
					student[i]++;
				} else if (i + 1 < n && student[i + 1] == 2) {
					student[i + 1]--;
					student[i]++;
				} else {
					answer--;
				}
			}
		}
		return answer;
	}
}
