package jspbook.ch04;

public class Score {
	
	public int calcSum(int scoreKor, int scoreEng, int scoreMath) {
		return scoreKor + scoreEng + scoreMath;
	}

	public double calcAvg(int scoreKor, int scoreEng, int scoreMath) {
		return (double) (scoreKor + scoreEng + scoreMath) / 3;
	}

}
