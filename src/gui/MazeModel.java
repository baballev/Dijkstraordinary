package gui;

import java.awt.*;
import javax.swing.*;
import maze.*;

public final class MazeModel {
	
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

}
