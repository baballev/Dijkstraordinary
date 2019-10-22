package dijkstra;

public class Dijkstra {
	

	private static PreviousInterface dijkstra(GraphInterface g,
VertexInterface r)
	
	{	int n = 100;
		ASet A = new ASet();
		Pi pi = new Pi();
		Previous previous = new Previous();
		
		A.add(r);
		VertexInterface pivot = r;
		
		for (VertexInterface x : g.getAllVertices() ) {
			pi.setValue(x , Integer.MAX_VALUE) ;}
		pi.setValue(r,0);
		
		
		
		for (int j = 1 ; j <= n-1 ; j++) {
			
			for (VertexInterface y : g.getAllVertices() ) {
				if ((g.getSuccessors(pivot)).contains(y) && ! A.contains(y) ){
					
					if ( pi.getValue(pivot) + 1 < pi.getValue(y) ) {
						pi.setValue(y, pi.getValue(pivot) + 1 );
						previous.setValue(y,pivot);
					}
				}
			}
			
			//test si il existe un sommet non dans A
			// si oui, le defini comme le min
			
			int min = Integer.MAX_VALUE; 
			VertexInterface newpivot = null;
			
			for (VertexInterface y : g.getAllVertices() ) {
				if (! A.contains(y) ){
					
					int min = ;
					vertexInterface newpivot = ;
					
				}
			}
			
			
		}
		/****/
		
		
		
		
		
		
		
		
		return previous;
	}

}
