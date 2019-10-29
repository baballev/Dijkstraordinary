package tp04;

import dijkstra.Previous;
import dijkstra.PreviousInterface;
import maze.Maze;
import gui.*;
import model.*;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "data/labyrinthe.txt";

		Maze labyrinthe = new Maze(10,10);
		labyrinthe.initFromTextFile(fileName);
		
		labyrinthe.saveFromTextFile("data/labyrinthe2.txt");
		
		MainWindow window = new MainWindow(); 		// Init window.
		window.getMazeModel().setMaze(labyrinthe);	// Set the maze value in the model to the one created above from text file.
		
		
	}
}