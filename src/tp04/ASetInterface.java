package tp04;

public interface ASetInterface {

	/**Ajoute un sommet dans l'ensemble s'il n'est pas déjà présent**/
	public void addElement(VertexInterface vertex);
	
	/**Test si le sommet est dans l'ensemble **/
	public boolean testPresence(VertexInterface vertex);
	
	
	
}
