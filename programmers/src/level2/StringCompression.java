package level2;

/* ����� ��#5
 * ���ڿ��� ���� �պ��� ������ ���̸�ŭ �߶�� �մϴ�.
 * ���� �־��� ���ڿ��� x / ababcdcd / ababcdcd �� �ڸ��� ���� �Ұ��� �մϴ�.
 * �� ��� ��� ���ڿ��� �߶� ������� �����Ƿ� ���� ª�� ���̴� 17�� �˴ϴ�.
 * */
public class StringCompression {
	public int solution(String s) {
		int answer = s.length();
		
		for (int i = 1; i <= s.length() / 2; i++) {
			StringBuilder sb = new StringBuilder();
			int cnt = 1;
			
			for (int j = 0; j + i <= s.length(); j += i) {
				String word = s.substring(j, j + i); // i ������ �߶� �˻��ϴ� �ܾ�
				boolean check = false;
				
				if ((j + i + i) <= s.length()) {
					String next = s.substring(j + i, j + i + i); // ������ �Ǵ� �ܾ��� ��
					if (word.equals(next)) {
						check = true;
						cnt++;
					} 
				}
				
				if (!check && cnt > 1) {
					sb.append(cnt);
					sb.append(word);
					cnt = 1;
				} else if (!check && cnt == 1) {
					sb.append(word);
				}
			}
			
			// ���ڸ� �ɰ��� ������ �������� ���� ��� - ���� �ܾ���� �߰��ؼ� ���� �˻��ϱ�
			if (s.length() % i != 0) {
				int remain = s.length() % i;
				for (int k = s.length() - remain - 1; k <= s.length() - 1; k++) {
					sb.append(s.charAt(k));
				}
			}
			
			if (answer > sb.length()) {
				answer = sb.length();
			}
		}
		return answer;
	}
}
