package tp04;

import dijkstra.Previous;
import dijkstra.VertexInterface;

import java.util.ArrayList;

import dijkstra.Dijkstra;
import maze.MBox;
import maze.Maze;
import gui.*;

public class MainTest {

	public static void main(String[] args) {
		String fileName = "data/labytest.txt";
		Maze labyrinthe = new Maze();
		labyrinthe.setSizeFromTextFile(fileName);
		labyrinthe.initFromTextFile(fileName);

		VertexInterface start = labyrinthe.getStart();
		VertexInterface end = labyrinthe.getEnd();
		
		Previous previous = (Previous) Dijkstra.dijkstra(labyrinthe, start);
		ArrayList<VertexInterface> path = previous.getShortestPathTo(end);
		
		// PROBLEME: Le sommet 'end' n'est pas dans la hashtable de previous.
		// D'où un path = null de longueur 0.
		// Déduction: Il y a un problème durant l'éxecution de Dijkstra.dijkstra
		// La question c'est de savoir où.
		
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
		
		new MainWindow();  	// Init window.
	}
}