package com.saeyan.javabean;

public class MemberBeans {
	private String name;
	private String userId;

	public MemberBeans(String name, String userId) {
		this.name = name;
		this.userId = userId;
	}

	public MemberBeans() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "MemberBeans [name=" + name + ", userId=" + userId + "]";
	}

}
