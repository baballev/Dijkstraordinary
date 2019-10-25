package tp04;

import dijkstra.Previous;
import dijkstra.PreviousInterface;
import maze.Maze;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "data/labyrinthe.txt";

		Maze labyrinthe = new Maze(10, 10);
		labyrinthe.initFromTextFile(fileName);

	}
}