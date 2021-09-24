package level1;

public class KthNumber {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for (int i = 0; i < commands.length; i++) {
			int start = commands[i][0];
			int end = commands[i][1];
			int offset = commands[i][2]; 
			
			int[] arr = new int[end - start + 1];
			int index = 0;
			
			for (int j = 0; j < array.length; j++) {
				if (!(j >= start - 1 && j < end)) {
					System.out.println(j);
					continue;
				}
				arr[index] = array[j];
				index++;
			}
			
			for (int k = 0; k < arr.length; k++) {
				for (int l = 0; l < arr.length - 1; l++) {
					if (arr[l] > arr[l + 1]) {
						int tmp = arr[l + 1];
						arr[l + 1] = arr[l];
						arr[l] = tmp;
					}
				}
			}
			answer[i] = arr[offset - 1];
		}
		
		// Arrays.copyOfRange(int[] original, int from, int to): 배열을 복사하는 메서드(복사할 배열, 시작, 끝) 
//		for (int i = 0; i < commands.length; i++) {
//			int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
//			Arrays.sort(temp);
//			answer[i] = temp[commands[i][2] - 1];
//		}
		
		return answer;
	}
} 
