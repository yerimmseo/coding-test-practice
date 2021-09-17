package level1;

public class LottoMinMaxRank {
		
	public static int  setRank(int count) {
		switch (count) {
		case 6:
			return 1;
		case 5:
			return 2;
		case 4:
			return 3;
		case 3:
			return 4;
		case 2:
			return 5;
		default:
			return 6;
		}
	}
	
	public int[] solution(int[] lottos, int[] win_nums) {
		int min = 0;
		int max = 0;
		int[] answer = {0, 0};
		
		for (int i = 0; i < win_nums.length; i++) {
			for (int j = 0; j < lottos.length; j++) {
				if (win_nums[i] == lottos[j]) {
					min++;
				}
			}
		}
		
		for (int i = 0; i < lottos.length; i++) {
			if (lottos[i] == 0) {
				lottos[i] = win_nums[i];
			}
			for (int j = 0; j < win_nums.length; j++) {
				if (lottos[i] == win_nums[j]) {
					max++;
				}
			}
		}
		
		answer[0] = setRank(max);
		answer[1] = setRank(min);
		
		return answer;
	}
}
