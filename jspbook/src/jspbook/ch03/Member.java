package jspbook.ch03;

import java.util.Objects;

public class Member {
	private int id;
	private String name;
	private String email;
	private String phoneNo;

	public void createId() {
		if (name != null && email != null && phoneNo != null) {
			id = Objects.hash(name, email, phoneNo);
			System.out.println(toString());
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getId(){
		return id;
	}

	@Override
	public String toString() {
		return "Member : [id=" + id + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + "]";
	}
	
}
