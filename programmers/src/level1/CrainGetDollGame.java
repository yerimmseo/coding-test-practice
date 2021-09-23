package level1;

import java.util.ArrayList;

public class CrainGetDollGame {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		ArrayList<Integer> stack = new ArrayList<>();
		
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][moves[i] - 1] != 0) {
					if (!stack.isEmpty() && stack.get(stack.size() - 1) == board[j][moves[i] - 1]) {
						stack.remove(stack.size() - 1);
						answer += 2;
					} else {
						stack.add(board[j][moves[i] - 1]);
					}
					board[j][moves[i] - 1] = 0;
					break;
				}
			}
		}
		return answer;
	}
}
