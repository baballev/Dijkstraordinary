package dijkstra;

import java.util.HashSet;
import java.util.Set;

public class ASet implements ASetInterface {

	private HashSet<VertexInterface> A;

	public void add(VertexInterface vertex) {
		A.add(vertex);
	}

	public boolean contains(VertexInterface vertex) {
		return (A.contains(vertex));
	}

}
