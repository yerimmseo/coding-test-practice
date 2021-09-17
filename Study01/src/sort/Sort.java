package sort;

import java.util.Arrays;

public class Sort {
	
	private static int[] array = new int[10];
	private static int count;
	
	//-- 데이터 입력
	public static void inputArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 99 + 1);
		}
	}
	
	//-- 데이터 출력
	public static void outputArray(int[] arr) {
		System.out.println(Arrays.toString(array));
	}
	
	/* SELECTION SORT
	 * (선택 정렬)
	 * - 정렬하려는 기준 요소의 값과 나머지 요소의 값을 비교하여 정렬하는 방식 
	 * */
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) { // 기준
			for (int j = i + 1; j < arr.length; j++) { // 비교
				if (arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
					count++;
				}
			}
		}
	}
	
	/* BUBBLE SORT
	 * (버블 정렬)
	 * - 인접한 두 개의 요소를 서로 비교하면서 정렬하는 방식
	 * */
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) { // 방울 횟수
			char swapCheck = 'n'; // 데이터 교환 확인 - y : 실행, n : 미실행
			for (int j = 1; j < arr.length - i; j++) { // 비교 원소
				if (arr[j - 1] > arr[j]) {
					int tmp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = tmp;
					swapCheck = 'y';
				}
			}
			// System.out.println("진행 횟수: " + i);
			if (swapCheck == 'n') break;
		}
	}
	
	/* QUICKSORT PARTITION */
	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[left]; // 기준 값
		int low = left;		   // 왼쪽 시작 위치(작은 값인지 확인)
		int high = ++right;    // 오른쪽 시작 위치(큰 값인지 확인)
		do {
			do {
				++low;
			} while (arr[low] < pivot);
			do {
				--high;
			} while (arr[high] > pivot);
			if (low < high) {
				int tmp = arr[low];
				arr[low] = arr[high];
				arr[high] = tmp;
			}
		} while (low < high);
		int tmp = arr[left];
		arr[left] = arr[high];
		arr[high] = tmp;
		
		return high;
	}
	
	/* QUICK SORT
	 * (퀵 정렬)
	 * - 기준 값의 왼쪽 부분 집합과 오른쪽 부분 집합으로 분할하여 정렬하는 방식
	 * - 왼쪽 부분 집합에는 기준 값보다 작은 원소들을 이동시키고, 오른쪽 부분 집합에는 기준 값보다 큰 원소들을 이동
	 * 	> 기준값(pivot): 전체 데이터 중심이 되는 값 
	 *	  분할(divide) : 정렬한 자료들을 기준값을 중심으로 두 개로 나눠 부분집합을 만듦
	 * 	  정복(conquer): 부분 집합 안에서 기준값의 정렬 위치를 정함 
	 * */
	public static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int center = partition(arr, left, right);
			quickSort(arr, left, center - 1);
			quickSort(arr, center + 1, right);
		}
	}
	
	public static void main(String[] args) {
		/* 선택 정렬 */
		System.out.println("--[선택 정렬 전]--");
		inputArray(array);
		outputArray(array);
		
		System.out.println("--[선택 정렬 후]--");
		selectionSort(array);
		outputArray(array);
		
		/* 버블 정렬 */
		System.out.println("--[버블 정렬 전]--");
		inputArray(array);
		outputArray(array);
		
		System.out.println("--[버블 정렬 후]--");
		bubbleSort(array);
		outputArray(array);
		
		/* 퀵 정렬 */
		System.out.println("--[퀵 정렬 전]--");
		inputArray(array);
		outputArray(array);
		
		System.out.println("--[퀵 정렬 후]--");
		quickSort(array, 0, array.length - 1); // 배열 위치, 시작 index, 마지막 index
		outputArray(array);
	}
}
