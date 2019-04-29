package day190415.ex01;

import java.util.ArrayList;
import java.util.List;

public class Marathon {
	public static void main(String[] args) {
		// 마라톤 참여 선수 리스트
		List<String> participants = new ArrayList<>();
		participants.add("홍길동");
		participants.add("김자바");
		participants.add("김자바");
		participants.add("김철수");
		participants.add("박영희");
		participants.add("이비자");

		// 완주한 선수 리스트
		List<String> completioners = new ArrayList<>();
		completioners.add("홍길동");
		completioners.add("김자바");
		completioners.add("김철수");
		completioners.add("박영희");
		completioners.add("이비자");

		System.out.println(fails(participants, completioners));

	}

	/* 완주 실패 선수 리스트(항상 1명) */
	public static String fails(List<String> participants, List<String> completioners) {
		for (int i = 0; i < participants.size(); i++) {
			for (int k = 0; k < completioners.size(); k++) {
				if (participants.get(i).equals(completioners.get(k))) {
					participants.remove(i);
					completioners.remove(k);
				}
			}
		}
		return participants.get(0);
	}

}
