package gui.model;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import dijkstra.Dijkstra;
import dijkstra.Previous;
import dijkstra.VertexInterface;
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
		this.setModified(false);
		this.setChanged();
		this.notifyObservers(maze);
	}
	
	public boolean isModified() {
		return this.modified;
	}
	
	public void setModified(boolean b) {
		this.modified = b;
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
	
	public int solve() {
		Maze solvedMaze = this.maze;
		
		VertexInterface start = solvedMaze.getStart();
		VertexInterface end = solvedMaze.getEnd();
		
		Previous previous = (Previous) Dijkstra.dijkstra(solvedMaze, start);
		ArrayList<VertexInterface> path = previous.getShortestPathTo(end);
		
		int n = path.size();
		if (path.get(n-1) == start) {
			for (int i = 0; i <= n-2 ;i++) {
				VertexInterface v = path.get(i);
				MBox box = (MBox)v;
				this.maze.setMbox(box.getX(), box.getY(), new SBox(this.maze, box.getX(), box.getY()));
			}
			this.setChanged();
			this.notifyObservers(maze);
			return 1;
		}
		else {
			this.setChanged();
			this.notifyObservers(maze);
			return 0;
		}
	}
}
