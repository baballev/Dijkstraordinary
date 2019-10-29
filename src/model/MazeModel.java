package model;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import maze.*;

@SuppressWarnings("deprecation")
public final class MazeModel extends Observable { 
	
	private Maze maze;
	
	public MazeModel() {
		this.maze = null;
	}

	public Maze getMaze() {
		return maze;
	}

	public void setMaze(Maze maze) {
		this.maze = maze;
	}

	//  setChanged(); to call when the observable is modified
	// notifyObservers();  or notifyObservers(Object parameter); after
	
	
	
	
}
