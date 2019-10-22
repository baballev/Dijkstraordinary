package dijkstra;

public interface ASetInterface {

	/**Ajoute un sommet dans l'ensemble s'il n'est pas déjà présent**/
	public void add(VertexInterface vertex);
	
	/**Test si le sommet est dans l'ensemble **/
	public boolean contains(VertexInterface vertex);
	
	
	
}
