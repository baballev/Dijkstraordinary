package tp04;

import dijkstra.GraphInterface;
import dijkstra.Previous;
import dijkstra.PreviousInterface;
import dijkstra.VertexInterface;

import java.util.ArrayList;

import dijkstra.Dijkstra;
import maze.MBox;
import maze.Maze;
import gui.*;

public class MainTest {

	public static void main(String[] args) {
		String fileName = "data/labyrinthe.txt";
		Maze labyrinthe = new Maze();
		labyrinthe.setSizeFromTextFile(fileName);
		labyrinthe.initFromTextFile(fileName);
		
		VertexInterface start = labyrinthe.getStart();
		VertexInterface end = labyrinthe.getEnd();
		
		Previous previous = (Previous)Dijkstra.dijkstra(labyrinthe, start);
		 
		ArrayList<VertexInterface> path = previous.getShortestPathTo(end);
		int n = path.size();
		if (path.get(n-1) == start) {
			System.out.println("Il existe un plus court chemin de D vers A de longueur " + n +"." );
			for (int i = 0; i <= n-2 ;i++) {
				VertexInterface v = path.get(i);
				MBox box = (MBox)v;
				box.setLabel();
			}
		}
		else {
			System.out.println("Il n'existe pas de chemin de longueur de D vers A." );
		}
		labyrinthe.saveFromTextFile("data/labyrinthe2.txt");
		
		MainWindow window = new MainWindow(); 		// Init window.
		
	}
}