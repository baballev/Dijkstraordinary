package gui;

import javax.swing.*;

import model.*;

import java.awt.Dimension;
import java.util.*;

@SuppressWarnings("deprecation")
public class MainWindow extends JFrame implements Observer {	// TODO: ORGANISER TOUT LE PACKAGE GUI EN SOUS PACKAGES.

	private final MenuBar menuBar;
	private final WindowPanel windowPanel;
	private MazeModel mazeModel = new MazeModel();
	private EditorModel editorModel = new EditorModel();
	
	public MainWindow() {
		super("Labyrinthe");
		this.mazeModel.addObserver(this);
		this.editorModel.addObserver(this);
		
		menuBar = new MenuBar(this);
		setJMenuBar(menuBar);
		
		windowPanel = new WindowPanel(this);
		this.setContentPane(windowPanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.pack();
		this.setVisible(true);
	}
	
	public MazeModel getMazeModel() {
		return this.mazeModel;
	}

	public void setMazeModel(MazeModel mazeModel) {
		this.mazeModel = mazeModel;
	}
	
	public EditorModel getEditorModel() {
		return this.editorModel;
	}

	public void setEditorModel(EditorModel editorModel) {
		this.editorModel = editorModel;
	}
	
	public void notifyForUpdate(Observable observable, Object parameter) {
		this.windowPanel.notifyForUpdate(observable, parameter);
	}

	public void update(Observable observable, Object parameter) { // Called in MazeModel when using notifyObservers(Object parameter); 
		this.notifyForUpdate(observable, parameter);
		this.pack();						// Needed, otherwise the panel won't display unless the window is resized.
	}
}
