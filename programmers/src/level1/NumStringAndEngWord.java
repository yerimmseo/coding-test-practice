package level1;

public class NumStringAndEngWord {
	public static int solution(String s) {
		int answer = 0;
		String[] digits = {"0","1","2","3","4","5","6","7","8","9"}; 
		String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		
		for (int i = 0; i < 10; i++) {
			s = s.replaceAll(alphabets[i], digits[i]);
		}
		answer = Integer.parseInt(s);
		return answer;
	}
}
