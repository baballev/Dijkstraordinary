package tp04;

public class InvalidMazeException extends Exception {
	
	private String errorMessage;
	
	public InvalidMazeException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
	}

}
