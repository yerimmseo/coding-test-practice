package level1;

public class ReverseTernaryScale {
	public int solution(int n) {
		int answer = 0;
		StringBuilder scale = new StringBuilder();
		
		for (; n > 0; n /= 3) {
			scale.insert(0, n % 3);
			/*
			 * StringBuilder의 insert(), append() 차이
			 * - append(): 문자열 데이터 끝에 문자의 형태로 추가
			 * - insert(int offset, int i): 삽입될 위치, 삽입될 문자, offset위치의 0은 맨 앞부분을 의미
			 * */
		}
		System.out.println(scale);
		
		for (int i = 0, j = 1; i < scale.length(); i++) {
			// Character.getNumericValue(char): 숫자 형태의 char를 int형으로 변환
			answer += Character.getNumericValue(scale.charAt(i)) * j;
			j *= 3;
		}
		return answer;
	}
}
