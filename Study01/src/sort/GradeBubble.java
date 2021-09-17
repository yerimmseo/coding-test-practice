package sort;

import java.util.Scanner;

public class GradeBubble {

	public static class Student {
		int no;
		int cpp;
		int java;
		int tot;
		
		@Override
		public String toString() {
			return String.format("%4d %8d %8d %8d\n", no, cpp, java, tot);
		}
	}
	
	public static Student[] students;
	
	public static int inputInteger(String message) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print(message);
		int value = sc.nextInt();
		
		return value;
	}
	
	public static Student[] makeStudent(int length) {
		students = new Student[length];
		
		for (int i = 0; i < length; i++) {
			students[i] = new Student();
		}
		return students;
	}
	
	public static int randomValue(int start, int end) {
		return (int)(Math.random() * (end - start + 1) + start);
	}
	
	public static int calcTotal(Student current) {
		return current.tot = current.cpp + current.java;
	}
	
	public static void setInfo(Student[] stu, int length) {
		System.out.println("-- �л� ���� �Է� --");
		for (int i = 0; i < length; i++) {
			stu[i].no = i + 1;
			stu[i].cpp = randomValue(40, 100);
			stu[i].java = randomValue(40, 100);
			calcTotal(stu[i]);
		}
	}
	
	public static void showTitle() {
		System.out.printf("%4s %8s %8s %6s\n", "��ȣ", "CPP", "JAVA", "����");
	}
	
	public static void showInfo(Student[] stu, int length) {
		System.out.println("-- ��  ��  ��  �� --");
		showTitle();
		for (int i = 0; i < length; i++) {
			System.out.print(stu[i]);
		}
	}
	
	public static int findTopTotal(Student[] stu, int length) {
		int top = 0; // ������ ���� ���� �л��� ��ġ
		for (int i = 1; i < length; i++) {
			if (stu[i].tot > stu[top].tot) {
				top = i;
			}
		}
		return top;
	}
	
	public static void showTopStudent(Student[] stu, int top) {
		System.out.println("-- �� �� �� �� �� �� --");
		System.out.println(stu[top]);
	}
	
	public static void topSort(Student[] stu, int length) {
		Student[] sub = stu;
		
		for (int i = 0; i < length - 1; i++) {
			char check = 'n';
			for (int j = 1; j < length - 1; j++) {
				if (sub[j - 1].tot < sub[j].tot) {
					Student tmp = sub[j - 1];
					sub[j - 1] = sub[j];
					sub[j] = tmp;
					check = 'y';
				}
			}
			if (check == 'n') break;
		}
		System.out.println("-- ������ ��� --");
		showInfo(sub, length);
	}
	
	public static void main(String[] args) {
		int stuLength = 0;
		int topIdx = 0;
		
		stuLength = inputInteger("�л��� �Է� > ");
		students = makeStudent(stuLength);
		
		setInfo(students, stuLength);
		showInfo(students, stuLength);
		
		topIdx = findTopTotal(students, stuLength);
		showTopStudent(students, topIdx);
		
		/* ������ �������� �������� �����ؼ� ����ϴ� �Լ��� ����
		 *  */
		topSort(students, stuLength);
	}
}
