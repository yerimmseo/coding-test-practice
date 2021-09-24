package level1;

import java.util.HashSet;

public class Pocketmon {
	public static int solution(int[] nums) {
		HashSet<Integer> hs = new HashSet<>();
		
		for (int i = 0; i < nums.length; i++) {
			hs.add(nums[i]);
		}
		
		if (hs.size() > nums.length / 2) {
			return nums.length / 2;
		}
		
		return hs.size();
	}
}
