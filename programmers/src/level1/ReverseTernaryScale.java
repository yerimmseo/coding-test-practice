package level1;

public class ReverseTernaryScale {
	public int solution(int n) {
		int answer = 0;
		StringBuilder scale = new StringBuilder();
		
		for (; n > 0; n /= 3) {
			scale.insert(0, n % 3);
			/*
			 * StringBuilder�� insert(), append() ����
			 * - append(): ���ڿ� ������ ���� ������ ���·� �߰�
			 * - insert(int offset, int i): ���Ե� ��ġ, ���Ե� ����, offset��ġ�� 0�� �� �պκ��� �ǹ�
			 * */
		}
		System.out.println(scale);
		
		for (int i = 0, j = 1; i < scale.length(); i++) {
			// Character.getNumericValue(char): ���� ������ char�� int������ ��ȯ
			answer += Character.getNumericValue(scale.charAt(i)) * j;
			j *= 3;
		}
		return answer;
	}
}
