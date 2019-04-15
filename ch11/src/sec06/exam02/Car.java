package sec06.exam02;

public class Car {
	public String model;
	public String owner;

	public Car() {

	}

	public Car(String model) {
		this.model = model;
	}

	public Car(String model, String owner) {
		super();
		this.model = model;
		this.owner = owner;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}
