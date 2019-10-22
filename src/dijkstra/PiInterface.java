package dijkstra;

public interface PiInterface {

	/** pi de vertex recoit value **/
	public void setValue(VertexInterface vertex, int value);
	
	/** donne la valeur de pi de vertex **/
	public int getValue(VertexInterface vertex);
	
	
}
