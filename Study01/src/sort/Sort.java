package sort;

import java.util.Arrays;

public class Sort {
	
	private static int[] array = new int[10];
	private static int count;
	
	//-- ������ �Է�
	public static void inputArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 99 + 1);
		}
	}
	
	//-- ������ ���
	public static void outputArray(int[] arr) {
		System.out.println(Arrays.toString(array));
	}
	
	/* SELECTION SORT
	 * (���� ����)
	 * - �����Ϸ��� ���� ����� ���� ������ ����� ���� ���Ͽ� �����ϴ� ��� 
	 * */
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) { // ����
			for (int j = i + 1; j < arr.length; j++) { // ��
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
	 * (���� ����)
	 * - ������ �� ���� ��Ҹ� ���� ���ϸ鼭 �����ϴ� ���
	 * */
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) { // ��� Ƚ��
			char swapCheck = 'n'; // ������ ��ȯ Ȯ�� - y : ����, n : �̽���
			for (int j = 1; j < arr.length - i; j++) { // �� ����
				if (arr[j - 1] > arr[j]) {
					int tmp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = tmp;
					swapCheck = 'y';
				}
			}
			// System.out.println("���� Ƚ��: " + i);
			if (swapCheck == 'n') break;
		}
	}
	
	/* QUICKSORT PARTITION */
	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[left]; // ���� ��
		int low = left;		   // ���� ���� ��ġ(���� ������ Ȯ��)
		int high = ++right;    // ������ ���� ��ġ(ū ������ Ȯ��)
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
	 * (�� ����)
	 * - ���� ���� ���� �κ� ���հ� ������ �κ� �������� �����Ͽ� �����ϴ� ���
	 * - ���� �κ� ���տ��� ���� ������ ���� ���ҵ��� �̵���Ű��, ������ �κ� ���տ��� ���� ������ ū ���ҵ��� �̵�
	 * 	> ���ذ�(pivot): ��ü ������ �߽��� �Ǵ� �� 
	 *	  ����(divide) : ������ �ڷ���� ���ذ��� �߽����� �� ���� ���� �κ������� ����
	 * 	  ����(conquer): �κ� ���� �ȿ��� ���ذ��� ���� ��ġ�� ���� 
	 * */
	public static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int center = partition(arr, left, right);
			quickSort(arr, left, center - 1);
			quickSort(arr, center + 1, right);
		}
	}
	
	public static void main(String[] args) {
		/* ���� ���� */
		System.out.println("--[���� ���� ��]--");
		inputArray(array);
		outputArray(array);
		
		System.out.println("--[���� ���� ��]--");
		selectionSort(array);
		outputArray(array);
		
		/* ���� ���� */
		System.out.println("--[���� ���� ��]--");
		inputArray(array);
		outputArray(array);
		
		System.out.println("--[���� ���� ��]--");
		bubbleSort(array);
		outputArray(array);
		
		/* �� ���� */
		System.out.println("--[�� ���� ��]--");
		inputArray(array);
		outputArray(array);
		
		System.out.println("--[�� ���� ��]--");
		quickSort(array, 0, array.length - 1); // �迭 ��ġ, ���� index, ������ index
		outputArray(array);
	}
}
