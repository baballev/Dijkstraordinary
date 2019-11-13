package model;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import maze.*;

@SuppressWarnings("deprecation")
public final class MazeModel extends Observable { 
	
	private Maze maze;
	private EditorModel editorModel;
	private boolean modified;
	
	public MazeModel() {
		this.maze = null;
		this.modified = false;
	}

	public Maze getMaze() {
		return maze;
	}
	
	public void setEditorModel(EditorModel editorModel){
		this.editorModel = editorModel;
	}
	
	public void setMaze(Maze maze) {
		this.maze = maze;
		this.setChanged();
		this.notifyObservers(maze);
	}
	
	public boolean isModified() {
		return this.modified;
	}
	
	public void changeMBox(int x, int y) {
		if (this.editorModel.getClickedIndex() == 0) {
			this.maze.setMbox(x, y, new EBox(this.maze, x, y));
		} else if (this.editorModel.getClickedIndex() == 1) {
			this.maze.setMbox(x, y, new WBox(this.maze, x, y));
		} else if (this.editorModel.getClickedIndex() == 2) {
			this.maze.setMbox(x, y, new DBox(this.maze, x, y));
		} else if (this.editorModel.getClickedIndex() == 3) {
			this.maze.setMbox(x, y, new ABox(this.maze, x, y));
		}
		this.modified = true;
		this.setChanged();
		this.notifyObservers(maze);
	}
}
