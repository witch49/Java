package practice2;

public class Member extends Customer {
	public static final int PERSON_CUSTOMER = 1;
	public static final int PERSON_MEMBER = 2;
	public int temp = PERSON_MEMBER;
	public String memNo;
	public int memMileage;

	public Member(String name, String phoneNumber, String address, String memNo, int memMileage) {
		super(name, phoneNumber, address);
		this.memNo = memNo;
		this.memMileage = memMileage;
	}

	@Override
	public void show() {
		if (temp == PERSON_MEMBER)
			System.out.println("Customer [name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address
					+ ", memNo=" + memNo + ", memMileage=" + memMileage + "]");
		else
			super.show();
	}
}
