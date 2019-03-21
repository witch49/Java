package practice2;

public class Customer {
	public String name;
	public String phoneNumber;
	public String address;

	public Customer(String name, String phoneNumber, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public void show() {
		System.out.println("Customer [name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address + "]");
	}

}
