package maze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;
import tp04.MazeReadingException;

public class Maze 
implements GraphInterface

{
	private MBox labyrinthe[][];
	private int width;
	private int height;
	
	public Maze(int width, int height) {
		this.width = width;
		this.height = height;
		labyrinthe = new MBox[height][width];
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
		return labyrinthe[y][x];
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
		int i = 0;
		BufferedReader mazeFile = null;
		try {
			mazeFile = new BufferedReader(new FileReader(fileName));
			String line = mazeFile.readLine(); 							 // Init with the first line
			while (line != null) {										 // When line = null, we are at the end of the file so stop reading.
				if (line.length() != width) throw new MazeReadingException(fileName, i, "Error: The file " + fileName + "'s lines do not correpond to maze width.");
				for (int k = 0; k < width; k++) {
					char c = line.charAt(k);
					MBox newBox;
					switch(c){
						case 'A':
							newBox = new ABox(this, k, i);
							break;
						case 'W':
							newBox = new WBox(this, k, i);
							break;
						case 'E':
							newBox = new EBox(this, k, i);
							break;
						case 'D':
							newBox = new DBox(this, k, i);
							break;
						default:
							throw new MazeReadingException(fileName, i, "Error: Unexpected character in " + fileName + " at line " + i);
					}		
					this.labyrinthe[i][k] = newBox;				
					}
				line = mazeFile.readLine();
				i++;
			}
		} catch(MazeReadingException e) {
			e.printStackTrace();
		}
		catch(Exception e){	
			e.printStackTrace();
		} finally {
			try {
				mazeFile.close();
			} catch(Exception e) {}
		}
	}
}
