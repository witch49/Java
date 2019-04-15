package basic03;

public class EaglesDTO {
	private int playerBackNo;
	private String playerName;
	private String playerPosition;
	private String playerHometown;
	private String playerThrowingHand;
	private String playerHitHand;
	private String playerSalary;
	private String playerBirth;

	public EaglesDTO(int playerBackNo, String playerName, String playerPosition, String playerHometown,
			String playerThrowingHand, String playerHitHand, String playerSalary, String playerBirth) {
		this.playerBackNo = playerBackNo;
		this.playerName = playerName;
		this.playerPosition = playerPosition;
		this.playerHometown = playerHometown;
		this.playerThrowingHand = playerThrowingHand;
		this.playerHitHand = playerHitHand;
		this.playerSalary = playerSalary;
		this.playerBirth = playerBirth;
	}

	public EaglesDTO() {

	}

	public int getPlayerBackNo() {
		return playerBackNo;
	}

	public void setPlayerBackNo(int playerBackNo) {
		this.playerBackNo = playerBackNo;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(String playerPosition) {
		this.playerPosition = playerPosition;
	}

	public String getPlayerHometown() {
		return playerHometown;
	}

	public void setPlayerHometown(String playerHometown) {
		this.playerHometown = playerHometown;
	}

	public String getPlayerThrowingHand() {
		return playerThrowingHand;
	}

	public void setPlayerThrowingHand(String playerThrowingHand) {
		this.playerThrowingHand = playerThrowingHand;
	}

	public String getPlayerHitHand() {
		return playerHitHand;
	}

	public void setPlayerHitHand(String playerHitHand) {
		this.playerHitHand = playerHitHand;
	}

	public String getPlayerSalary() {
		return playerSalary;
	}

	public void setPlayerSalary(String playerSalary) {
		this.playerSalary = playerSalary;
	}

	public String getPlayerBirth() {
		return playerBirth;
	}

	public void setPlayerBirth(String playerBirth) {
		this.playerBirth = playerBirth;
	}

	@Override
	public String toString() {
		return "EaglesDTO [번호:" + playerBackNo + ", 이름:" + playerName + ", \t\t포지션:" + playerPosition + ", \t출신지:"
				+ playerHometown + ", \t손1:" + playerThrowingHand + ", 손2:" + playerHitHand + ", 연봉:"
				+ playerSalary + ", \t생년월일:" + playerBirth + "]";
	}

}
