package basic04;

public class MemberDTO {
	private int memberId;
	private String memberPassword;
	public String memberName;
	private int memberBirth;
	private String memberAddress;

	public MemberDTO(int memberId, String memberPassword, String memberName, int memberBirth, String memberAddress) {
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberBirth = memberBirth;
		this.memberAddress = memberAddress;
	}

	public MemberDTO(String memberPassword, String memberName, int memberBirth, String memberAddress) {
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberBirth = memberBirth;
		this.memberAddress = memberAddress;
	}

	public MemberDTO() {

	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(int memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	@Override
	public String toString() {
		return "MemberDTO [아이디=" + memberId + ", 패스워드=" + memberPassword + ", 이름=" + memberName + ", 생년월일="
				+ memberBirth + ", 주소=" + memberAddress + "]";
	}

//	public String toStringM() {
//		return "BbsDTO [작성자=" + memberName;
//	}

}
