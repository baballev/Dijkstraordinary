package dijkstra;

public interface PiInterface {
	// Infinity will be represented Integer.MAX_VALUE

	/* Sets the value of a given vertex to an integer or infinity */
	public void setValue(VertexInterface vertex, int value);

	/* Returns the value of the given vertex as a positive integer */
	public int getValue(VertexInterface vertex);

}
