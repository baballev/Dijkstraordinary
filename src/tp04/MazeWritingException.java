package tp04;

public class MazeWritingException extends Exception {
	
	public MazeWritingException(String fileName, int lineNumber, String errorMessage) {
		super(errorMessage);
	}

}
