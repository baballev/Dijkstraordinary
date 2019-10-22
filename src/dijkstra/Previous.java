package dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

public class Previous 
implements PreviousInterface
{
	
	private Hashtable<VertexInterface, VertexInterface> previous;
	
	public Previous() {
		previous = new Hashtable<VertexInterface, VertexInterface>();
	}

	public void setValue(VertexInterface vertex, VertexInterface value) {
		previous.put(vertex, value);	
	}

	public VertexInterface getValue(VertexInterface vertex) {
		return previous.get(vertex);
	}

	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex) {
		
		ArrayList<VertexInterface> path = new ArrayList<VertexInterface>();
		
		VertexInterface v = previous.get(vertex);
		
		while( v != null) {
			path.add(v);
			VertexInterface w = v;
			v = previous.get(w);
		}
		
		return path;
	}
	
	
}
