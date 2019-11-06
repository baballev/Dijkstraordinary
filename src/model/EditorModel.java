package model;

import java.util.Observable;
import java.util.ArrayList;

import maze.Maze;

@SuppressWarnings("deprecation")
public final class EditorModel extends Observable {
	
	private ArrayList<Maze> mazeList;
	
	public EditorModel() {
		this.mazeList = new ArrayList<Maze>();
	}
	
	public ArrayList<Maze> getMazeList() {
		return this.mazeList;
	}
	
	public void addToMazeList(Maze maze) {
		this.mazeList.add(maze);
		this.setChanged();
		this.notifyObservers(this.mazeList);
	}
	
	public void removeFromMazeList(Maze maze) {
		this.mazeList.remove(maze);
		this.setChanged();
		this.notifyObservers(this.mazeList);
	}

}
