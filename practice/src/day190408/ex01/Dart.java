package day190408.ex01;

import java.util.*;

public class Dart {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("다트 점수를 계산할 문자열을 입력하세요.");
		System.out.println("0~10점 사이 / S,D,T 영역 / *,# 옵션 / 입력 예시: 1T2D3D#");
		System.out.print("입력> ");
		String str = sc.nextLine().trim();
		// String str = "1T2D3D#";
		parseDart(str);
	}

	public static void parseDart(String str) {
		StringTokenizer sScore = new StringTokenizer(str, ".S?D?T?.\\*?#?");
		StringTokenizer sArea = new StringTokenizer(str, "0123456789");
		int[] scores = { 1, 1, 1 };
		String[] areas = { "", "", "" };
		while (sScore.hasMoreTokens()) {
			String temp = sScore.nextToken();
			int count = sScore.countTokens();
			scores[count] = Integer.parseInt(temp);
		}
		// scores[0] : 3번째, scores[1] : 2번째, scores[2] : 첫번째

		while (sArea.hasMoreTokens()) {
			String temp = sArea.nextToken();
			int count = sArea.countTokens();
			areas[count] = temp;
		}
		// areas[0] : 3번째, areas[1] : 2번째, areas[2] : 첫번째

		int[] resultScores = { 1, 1, 1 };
		for (int i = 0; i <= 2; i++)
			resultScores[i] = scoreEval(scores[i], areas[i]);

		if (areas[1].matches(".\\*")) {
			resultScores[2] += resultScores[2];
		}
		if (areas[0].matches(".\\*")) {
			resultScores[1] += resultScores[1];
		}

		System.out.println("다트 결과: " + (resultScores[2] + resultScores[1] + resultScores[0]));
	}

	public static int scoreEval(int score, String str) {
		if (str.matches("S")) {
			return score;
		} else if (str.matches("S\\*")) {
			return score * 2;
		} else if (str.matches("S#")) {
			return score * (-1);
		}

		if (str.matches("D")) {
			return score * score;
		} else if (str.matches("D\\*")) {
			return score * score * 2;
		} else if (str.matches("D#")) {
			return score * score * (-1);
		}

		if (str.matches("T")) {
			return score * score * score;
		} else if (str.matches("T\\*")) {
			return score * score * score * 2;
		} else if (str.matches("T#")) {
			return score * score * score * (-1);
		}
		return 0;
	}

}
