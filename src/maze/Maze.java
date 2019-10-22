package maze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;

public class Maze 
implements GraphInterface

{
	private MBox labyrinthe[][];
	
	public Maze() {
		labyrinthe = new MBox[10][10];
	}
	
	
	public ArrayList<VertexInterface> getAllVertices() {
		ArrayList<VertexInterface> verticesList = new ArrayList<VertexInterface>();
		for (MBox[] X : labyrinthe) {
			for(MBox x : X) {
				if (x.getLabel().compareTo("W") != 0) {
					verticesList.add(x);
				}
			}
		}
		return verticesList;
	}
	
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		MBox box = (MBox)vertex ;
		int x=box.getX();
		int y=box.getY();		
		ArrayList<VertexInterface> successorsList = new ArrayList<VertexInterface>();
		
		for (int i = -1; i <= 1; i++ ) {
			for (int j = -1; j <= 1; j++ ) {
				if (Math.abs(i -j) == 1) {
					MBox v=labyrinthe[x+i][y+j];
					if (v.getLabel().compareTo("W") != 0) {
						successorsList.add(v);
					}
				}
			}
		}
		return successorsList;
	}
	
	public MBox getMbox(int x, int y) {
		return (MBox) labyrinthe[x][y];
				}
	
	public int getWeight(VertexInterface src,VertexInterface dst) {
		ArrayList<VertexInterface> successorsList =  getSuccessors(src);
		
		if (successorsList.contains(dst)) {
			return 1;
		}
		else {
			return Integer.MAX_VALUE;
		}
	}
	
	
	public final void initFromTextFile(String fileName) {
		
		
		//BufferedReader mazeFile = null;
		try {
			FileReader a = new FileReader(fileName);
			BufferedReader b = new BufferedReader(a);
			
			int intCurrentCara;
			int nbCara = 0;
		      while ((intCurrentCara = b.read() ) != -1) {
		    	  if (intCurrentCara == 87) {
		    		  System.out.println("W");
		    		  nbCara+=1;
		    		  int ligne = (nbCara-1)/10;
		    		  int colonne = (nbCara-1)%10;
		    		  labyrinthe[ligne][colonne]= new WBox(labyrinthe,ligne,colonne);
		    	  }
		    	  if (intCurrentCara == 69) {
		    		  System.out.println("E");
		    		  nbCara+=1;
		    		  int ligne = (nbCara-1)/10;
		    		  int colonne = (nbCara-1)%10;
		    		  labyrinthe[ligne][colonne]= new EBox(labyrinthe,ligne,colonne);
		    	  }
		    	  if (intCurrentCara == 68) {
		    		  System.out.println("D");
		    		  nbCara+=1;
		    		  int ligne = (nbCara-1)/10;
		    		  int colonne = (nbCara-1)%10;
		    		  labyrinthe[ligne][colonne]= new DBox(labyrinthe,ligne,colonne);
		    	  }
		    	  if (intCurrentCara == 65) {
		    		  System.out.println("A");
		    		  nbCara+=1;
		    		  int ligne = (nbCara-1)/10;
		    		  int colonne = (nbCara-1)%10;
		    		  labyrinthe[ligne][colonne]= new ABox(labyrinthe,ligne,colonne);
		    	  }
		      }
		      
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
