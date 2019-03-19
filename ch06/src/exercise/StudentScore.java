package exercise;

public class StudentScore {
	/**
	 * 1. 다음의 필드를 갖는 StudentScore Class를 작성하시오
	 * 
	 * 성명, 수학, 영어, 과학, 평균
	 * 
	 * 2. 성명과 수학, 영어, 과학 점수를 매개변수로 하는 생성자를 작성하시오.
	 * 
	 * 3. toString() 메소드를 만드시오.
	 * 
	 * 4. 평균을 구하는 메소드(double average())를 만드시오.
	 * 
	 * 단, 이 메소드는 평균값을 리턴도 하여야 하고, 필드의 평균값도 고쳐야 함.
	 * 
	 * 5. 이름과 수학, 영어, 과학 성적을 입력으로 받아서
	 * 
	 * 이름과 수학, 영어, 과학, 평균을 출력하는 프로그램을 작성하시오.
	 */

	String name;
	int scoreMath;
	int scoreEnglish;
	int scoreScience;
	double avg;

	StudentScore(String name, int scoreMath, int scoreEnglish, int scoreScience) {
		this.name = name;
		this.scoreMath = scoreMath;
		this.scoreEnglish = scoreEnglish;
		this.scoreScience = scoreScience;
	}

	public double average() {
		double avg = (double) (scoreMath + scoreEnglish + scoreScience) / 3;
		this.avg = avg;
		return avg;
	}

	@Override
	public String toString() {
		return "이름: " + name + ", 수학점수: " + scoreMath + ", 영어점수: " + scoreEnglish + ", 과학점수: " + scoreScience + ", 평균: "
				+ avg;
	}

}
