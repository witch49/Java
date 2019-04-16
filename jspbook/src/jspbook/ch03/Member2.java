package jspbook.ch03;

import java.util.Objects;

public class Member2 {
	
	public int createId(String name, String email, String phoneNo) {
		if (name != null && email != null && phoneNo != null) {
			int id = Objects.hash(name, email, phoneNo);
			return id;
		}
		return 0;
	}

}
