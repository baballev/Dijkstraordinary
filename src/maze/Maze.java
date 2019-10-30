package maze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;
import tp04.MazeReadingException;

public class Maze implements GraphInterface

{
	private MBox labyrinthe[][];
	private int width;
	private int height;

	public Maze(int width, int height) {
		this.width = width;
		this.height = height;
		labyrinthe = new MBox[height][width];
	}

	public Maze() { // Default maze size is 10 x 10
		this.height = 10;
		this.width = 10;
		this.labyrinthe = new MBox[this.height][this.width];
	}
	
	public ArrayList<VertexInterface> getAllVertices() {
		ArrayList<VertexInterface> verticesList = new ArrayList<VertexInterface>();
		for (MBox[] X : labyrinthe) {
			for (MBox x : X) {
				if (x.getLabel().compareTo("W") != 0) {
					verticesList.add(x);
				}
			}
		}
		return verticesList;
	}

	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		MBox box = (MBox) vertex;
		int x = box.getX();
		int y = box.getY();
		ArrayList<VertexInterface> successorsList = new ArrayList<VertexInterface>();

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (Math.abs(i - j) == 1 && y+i >= 0 && y+i <= 9 && x+j >= 0 && x+j <= 9) {
					MBox v = labyrinthe[y + i][x + j];
					if (v.getLabel().compareTo("W") != 0) {
						successorsList.add(v);
					}
				}
			}
		}
		return successorsList;
	}
	
	public void setSizeFromTextFile(String path) { // Allows to set the size of maze object according to the structure of a text file
		BufferedReader mazeFile = null;
		try {
			mazeFile = new BufferedReader(new FileReader(path));
			int i = 1;
			String line = mazeFile.readLine();
			this.width = line.length();
			while (line != "") {
				// TODO height counting the numbers of line
				i++;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
			mazeFile.close();
			} catch(Exception e) {
			}
			
		}
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public MBox[][] getLabyrinthe() {
		return this.labyrinthe;
	}

	public MBox getMbox(int x, int y) {
		return labyrinthe[y][x];
	}

	public int getWeight(VertexInterface src, VertexInterface dst) {
		ArrayList<VertexInterface> successorsList = getSuccessors(src);

		if (successorsList.contains(dst)) {
			return 1;
		} else {
			return Integer.MAX_VALUE;
		}
	}

	public VertexInterface getStart() {
		int i = 0 ;
		int j = 0 ;
		int count = 0;
		MBox v = labyrinthe[i][j];
		String str = v.getLabel();
		while ( str != "D") {
			count += 1;
			i= count / width;
			j= count % width;			 
			v = labyrinthe[i][j];
			str = v.getLabel();
		}
		return (v);
	}
	public VertexInterface getEnd() {
		int i = 0 ;
		int j = 0 ;
		int count = 0;
		MBox v = labyrinthe[i][j];
		String str = v.getLabel();
		while ( str != "A") {
			count += 1;
			i= count / width;
			j= count % width;			 
			v = labyrinthe[i][j];
			str = v.getLabel();
		}
		return (v);
	}	

	public final void initFromTextFile(String fileName) { // TODO: Manage exceptions on mutltiple DBox or ABox.
		int i = 0;
		BufferedReader mazeFile = null;
		try {
			mazeFile = new BufferedReader(new FileReader(fileName));
			String line = mazeFile.readLine(); // Init with the first line
			while (line != null) { // When line = null, we are at the end of the file so stop reading.
				if (line.length() != width)
					throw new MazeReadingException(fileName, i,
							"Error: The file " + fileName + "'s lines do not correpond to maze width.");
				for (int k = 0; k < width; k++) {
					char c = line.charAt(k);
					MBox newBox;
					switch (c) {
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
						throw new MazeReadingException(fileName, i,
								"Error: Unexpected character in " + fileName + " at line " + i);
					}
					this.labyrinthe[i][k] = newBox;
				}
				line = mazeFile.readLine();
				i++;
				if (i > height)
					throw new MazeReadingException(fileName, i,
							"Error: The number of lines in the file " + fileName + " does not match the maze's height.");
			}
		} catch (MazeReadingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				mazeFile.close();
			} catch (Exception e) {
			}
		}
	}
	
	public final void saveFromTextFile(String fileName) { // TODO: Manage exceptions on multiple DBox or ABox.
		
		BufferedWriter writer = null;
		try{
			writer = new BufferedWriter(new FileWriter(fileName));
		
		
			for (MBox[] X : labyrinthe) {
				for (MBox x : X) {
					String str;
					str = x.getLabel();
					char c = str.charAt(0);
					writer.write(c);
				}
				writer.write("\n");
			}
		}
		catch(Exception e){}
		finally {
			try {
				writer.close();
				} 
			catch (Exception e) {
			}
		}
	}
}
