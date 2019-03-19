package exercise;

import java.util.Scanner;

public class StudentScoreExample {
	public static void main(String[] args) {
		StudentScore student = new StudentScore("", 0, 0, 0);

		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		student.name = sc.nextLine();
		System.out.print("수학 점수 입력 : ");
		student.scoreMath = Integer.parseInt(sc.nextLine());
		System.out.print("영어 점수 입력 : ");
		student.scoreEnglish = Integer.parseInt(sc.nextLine());
		System.out.print("과학 점수 입력 : ");
		student.scoreScience = Integer.parseInt(sc.nextLine());
		student.average();	// 점수 평균 구하기
		System.out.println(student.toString());

		sc.close();
	}
}
