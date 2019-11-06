package model;

import java.util.Observable;

import maze.MBox;

import java.util.ArrayList;

@SuppressWarnings("deprecation")
public final class EditorModel extends Observable {
	
	private ArrayList<MBox> boxList;
	
	public EditorModel() {
		this.boxList = new ArrayList<MBox>();
	}
	
	public ArrayList<MBox> getMazeList() {
		return this.boxList;
	}
	
	public void addToBoxList(MBox box) {
		this.boxList.add(box);
		this.setChanged();
		this.notifyObservers(this.boxList.get(this.boxList.size()-1));
	}
	
	public void removeFromBoxList(MBox box) {
		this.boxList.remove(box);
		this.setChanged();
		this.notifyObservers(this.boxList.get(this.boxList.size()-1));
	}

}
