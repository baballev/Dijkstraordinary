package model;

import java.util.Observable;

import maze.ABox;
import maze.DBox;
import maze.EBox;
import maze.MBox;
import maze.Maze;
import maze.WBox;

import java.util.ArrayList;

@SuppressWarnings("deprecation")
public final class EditorModel extends Observable {
	
	private int clickedIndex;
	private ArrayList<MBox> boxList;
	private MazeModel mazeModel;
	
	public EditorModel() {
		this.boxList = new ArrayList<MBox>();
		this.clickedIndex = -1;
	}
	
	public void setMazeModel(MazeModel editorModel){
		this.mazeModel = mazeModel;
	}
	
	public int getClickedIndex() {
		return clickedIndex;
	}

	public void setClickedIndex(int clickedIndex) {
		this.clickedIndex = clickedIndex;
	}

	public ArrayList<MBox> getMazeList() {
		return this.boxList;
	}
	
	private void addToBoxList(MBox box) {
		this.boxList.add(box);
		this.setChanged();
		this.notifyObservers(this.boxList);
	}
	
	private void clearBoxList() {
		this.boxList.clear();
		this.setChanged(); 
		this.notifyObservers(this.boxList);
	}

	public void setClicked(MBox boxClicked) {
		this.clickedIndex = this.boxList.indexOf(boxClicked);
		this.setChanged(); 
		this.notifyObservers(this.clickedIndex);
	}

	
	public void setupEditor() {
		this.clearBoxList();	
		this.addToBoxList(new EBox(new Maze(), 0, 0));
		this.addToBoxList(new WBox(new Maze(), 0, 0));
		this.addToBoxList(new DBox(new Maze(), 0, 0));
		this.addToBoxList(new ABox(new Maze(), 0, 0));
	}
}
