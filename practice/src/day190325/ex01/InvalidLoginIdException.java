package day190325.ex01;

public class InvalidLoginIdException extends Exception {
	public InvalidLoginIdException() {

	}

	public InvalidLoginIdException(String message) {
		super(message);
	}
}
