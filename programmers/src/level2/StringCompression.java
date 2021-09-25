package level2;

/* 입출력 예#5
 * 문자열은 제일 앞부터 정해진 길이만큼 잘라야 합니다.
 * 따라서 주어진 문자열을 x / ababcdcd / ababcdcd 로 자르는 것은 불가능 합니다.
 * 이 경우 어떻게 문자열을 잘라도 압축되지 않으므로 가장 짧은 길이는 17이 됩니다.
 * */
public class StringCompression {
	public int solution(String s) {
		int answer = s.length();
		
		for (int i = 1; i <= s.length() / 2; i++) {
			StringBuilder sb = new StringBuilder();
			int cnt = 1;
			
			for (int j = 0; j + i <= s.length(); j += i) {
				String word = s.substring(j, j + i); // i 단위로 잘라 검사하는 단어
				boolean check = false;
				
				if ((j + i + i) <= s.length()) {
					String next = s.substring(j + i, j + i + i); // 기준이 되는 단어의 뒤
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
			
			// 문자를 쪼개는 단위의 나머지가 생긴 경우 - 뒤의 단어까지 추가해서 길이 검색하기
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
