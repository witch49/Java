package sec02;

import java.util.*;

public class IfElseIfElseExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int score = sc.nextInt();
		// (1)
		// String line = sc.nextLine();
		// int score = Integer.parseInt(line);
		// (2)
		// int score = Integer.parseInt(sc.nextLine());
		
		if (score >= 90) {
			System.out.println("점수는 90~100입니다.");
			System.out.println("등급은 A 입니다.");
		} else if (score >= 80){
			System.out.println("점수는 80~89입니다.");
			System.out.println("등급은 B 입니다.");
		} else if (score >= 70){
			System.out.println("점수는 70~79입니다.");
			System.out.println("등급은 C 입니다.");
		} else if (score >= 60){
			System.out.println("점수는 60~69입니다.");
			System.out.println("등급은 D 입니다.");
		} else {
			System.out.println("점수가 60보다 작습니다.");
			System.out.println("등급은 F 입니다.");
		}
		sc.close();
	}
}
