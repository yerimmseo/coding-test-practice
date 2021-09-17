package sort;

import java.util.Arrays;
import java.util.Scanner;

public class LottoSelect {

	/* �ζ� ��ȣ�� �����ϴ� ���α׷��� �ۼ�
	 * - �ζ� �Ѱ��� : 1 ~ 45 ������ ���� �� 6�� (�ߺ��� X)
	 * - ���� ���� �Է¹ް�, �Է��� ���� �� ��ŭ�� ��ȣ�� �����ؼ� ���
	 * */
	private static final int LOTTO_LENGTH = 6;
	private static int[] lotto = new int[LOTTO_LENGTH];
	
	public static int inputInteger(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.print(message);
		int value = sc.nextInt();
		
		return value;
	}
	
	public static void setLotto(int[] lotto) {
		for (int i = 0; i < LOTTO_LENGTH; i++) {
			lotto[i] = (int)(Math.random() * 45 + 1);
			for (int b = 0; b < i; b++) {
				if (lotto[b] == lotto[i]) {
					i = b; // �ߺ��� üũ�ؼ� �ߺ��� �κ� �ٽ� ������ ������
					break;
				}
			}
		}
	}
	
	public static void sortLotto(int[] lotto) {
		for (int i = 0; i < LOTTO_LENGTH - 1; i++) {
			for (int j = i + 1; j < LOTTO_LENGTH; j++) {
				if (lotto[i] > lotto[j]) {
					int tmp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = tmp;
				}
			}
		}
	}
	
	public static void showLotto(int[] lotto) {
		System.out.println(Arrays.toString(lotto));
	}
	
	public static void lottoRun() {
		 int game = 0;
		 game = inputInteger("���� �� �Է� > ");
		 
		 for (int cnt = 1; cnt <= game; cnt++) {
			 setLotto(lotto);
			 sortLotto(lotto);
			 showLotto(lotto);
			 if (cnt % 5 == 0) {
				 System.out.println("");
			 }
		 }
	}
	
	public static void main(String[] args) {
		lottoRun();
	}
}
