package model;

import java.util.Observable;

import maze.MBox;

import java.util.ArrayList;

@SuppressWarnings("deprecation")
public final class EditorModel extends Observable {
	
	private int clickedIndex;
	private ArrayList<MBox> boxList;
	
	public EditorModel() {
		this.boxList = new ArrayList<MBox>();
		this.clickedIndex = -1;
	}
	
	public ArrayList<MBox> getMazeList() {
		return this.boxList;
	}
	
	public void addToBoxList(MBox box) {
		this.boxList.add(box);
		this.setChanged();
		this.notifyObservers(this.boxList);
	}
	
	public void clearBoxList() {
		this.boxList.clear();
		this.setChanged(); 
		this.notifyObservers(this.boxList);
	}

	public void setClicked(MBox boxClicked) {
		this.clickedIndex = this.boxList.indexOf(boxClicked);
		this.setChanged(); 
		this.notifyObservers(this.clickedIndex);
	}

}
