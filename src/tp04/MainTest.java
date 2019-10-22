package tp04;

import maze.Maze;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "data/labyrinthe.txt" ;	
		
		Maze labyrinthe = new Maze();
		labyrinthe.initFromTextFile(fileName);
		}
}