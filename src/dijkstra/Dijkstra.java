package dijkstra;

import java.util.ArrayList;

public class Dijkstra {

	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r)

	{
		ArrayList<VertexInterface> vertices = g.getAllVertices();
		int n = vertices.size();
		ASet A = new ASet();
		Pi pi = new Pi();
		Previous previous = new Previous();
		
		A.add(r);
		VertexInterface pivot = r;

		for (VertexInterface x : vertices) {
			pi.setValue(x, Integer.MAX_VALUE);
		}
		
		pi.setValue(r, 0);

		for (int j = 0; j <= n - 2; j++) {
			for (VertexInterface y : vertices) {
				if ( (g.getSuccessors(pivot)).contains(y) && !(A.contains(y)) ) {

					if (pi.getValue(pivot) + 1 < pi.getValue(y)) {
						pi.setValue(y, pi.getValue(pivot) + 1);
						previous.setValue(y, pivot);
					}
				}
			}
			// test si il existe un sommet non dans A
			// si oui, le defini comme le min
			int min = Integer.MAX_VALUE;
			VertexInterface npivot = null;
			for (VertexInterface y : vertices) {
				if ( !(A.contains(y)) ) {
					if (pi.getValue(y) <= min) {
						min = pi.getValue(y);
						npivot = y;
					}
				}
				}
				pivot = npivot;
			A.add(pivot);
		}
		return previous;
	}	
}
