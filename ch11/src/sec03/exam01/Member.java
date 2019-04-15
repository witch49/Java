package sec03.exam01;

public class Member {
	public String id;

	public Member(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		/* Member 타입으로 강제 타입 변환하고 id 필드값이 동일한지 검사해 동일하다면 true 리턴 */
		if (obj instanceof Member) {	// instanceof : 부모자식 관계인지 확인
			Member member = (Member) obj;
			if (id.equals(member.id))
				return true;
		}
		return false;	// 매개값이 Member가 아니거나 id 필드값이 다를 경우 false 리턴
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
