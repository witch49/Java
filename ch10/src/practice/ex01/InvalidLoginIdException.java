package practice.ex01;

public class InvalidLoginIdException extends Exception {
	public InvalidLoginIdException() {

	}

	public InvalidLoginIdException(String message) {
		super(message);
	}
}
