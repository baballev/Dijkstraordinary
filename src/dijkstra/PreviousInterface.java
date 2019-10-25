package dijkstra;

public interface PreviousInterface {

	/** p�re de vertex recois value **/
	public void setValue(VertexInterface vertex, VertexInterface value);

	/** donne la valeur de p�re de vertex **/
	public VertexInterface getValue(VertexInterface vertex);

}
