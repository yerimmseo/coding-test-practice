package level1;

public class MakePrime {
	public int solution(int[] nums) {
		int answer = 0;
		
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int sum = nums[i] + nums[j] + nums[k];
					if (isPrime(sum)) {
						answer++;
					}
				}
			}
		}
		return answer;
	}
	
	public static boolean isPrime(int a) {
		if (a < 2) return false;

		for (int div = 2; div <= Math.sqrt(a); div++) {
			if (a % div == 0) return false;
		}
		return true;
	}
}
