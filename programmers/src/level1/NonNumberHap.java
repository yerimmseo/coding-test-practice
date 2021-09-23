package level1;

public class NonNumberHap {
	public int solution(int[] numbers) {
		int sum = 45;
		for (int i : numbers) {
			sum -= i;
		}
		return sum;
	}
}
