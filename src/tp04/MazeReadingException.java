package tp04;

public class MazeReadingException extends Exception {
	public MazeReadingException(String fileName, int lineNumber, String errorMessage) {
		super(errorMessage);

	}
}
