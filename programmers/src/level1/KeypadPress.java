package level1;

import java.util.HashMap;
import java.util.Map;

public class KeypadPress {
	public String solution(int[] numbers, String hand) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		
		Map<Integer, Position> key = new HashMap<>();
		key.put(1, new Position(0, 0));
		key.put(2, new Position(0, 1));
		key.put(3, new Position(0, 2));
		key.put(4, new Position(1, 0));
		key.put(5, new Position(1, 1));
		key.put(6, new Position(1, 2));
		key.put(7, new Position(2, 0));
		key.put(8, new Position(2, 1));
		key.put(9, new Position(2, 2));
		key.put(0, new Position(3, 1));
		
		Position Lpos = new Position(3, 0);
		Position Rpos = new Position(3, 2);
		
		for (int i = 0; i < numbers.length; i++) {
			int x = key.get(numbers[i]).getX();
			int y = key.get(numbers[i]).getY();
			
			if (y == 0) {
				sb.append("L");
				Lpos.setX(x);
				Lpos.setY(y);
			} else if (y == 2) {
				sb.append("R");
				Rpos.setX(x);
				Rpos.setY(y);
			} else {
				int RDis = Math.abs(Rpos.getX() - x) + Math.abs(Rpos.getY() - y);
				int LDis = Math.abs(Lpos.getX() - x) + Math.abs(Lpos.getY() - y);
				
				if (RDis > LDis) {
					sb.append("L");
					Lpos.setX(x);
					Lpos.setY(y);
				} else if (RDis < LDis) {
					sb.append("R");
					Rpos.setX(x);
					Rpos.setY(y);
				} else {
					if (hand.equals("right")) {
						sb.append("R");
						Rpos.setX(x);
						Rpos.setY(y);
					} else {
						sb.append("L");
						Lpos.setX(x);
						Lpos.setY(y);
					}
				}
			}
		}
		answer = sb.toString();
		return answer;
	}
	
	public static class Position {
		int x, y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
		
		public void setX(int x) {
			this.x = x;
		}
		
		public void setY(int y) {
			this.y = y;
		}
	}
}
