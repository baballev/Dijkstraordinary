package gui;

import javax.swing.*;

import gui.menu.MenuBar;
import gui.model.EditorModel;
import gui.model.MazeModel;
import gui.panel.WindowPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.util.*;

@SuppressWarnings("deprecation")
public class MainWindow extends JFrame implements Observer {

	private final MenuBar menuBar;
	private final WindowPanel windowPanel;
	private MazeModel mazeModel = new MazeModel();
	private EditorModel editorModel = new EditorModel();
	
	public MainWindow() {
		super("Labyrinthe");
		this.mazeModel.addObserver(this);
		this.editorModel.addObserver(this);
		this.mazeModel.setEditorModel(this.editorModel);
		this.editorModel.setMazeModel(this.mazeModel);
		
		menuBar = new MenuBar(this);
		setJMenuBar(menuBar);
		
		windowPanel = new WindowPanel(this);
		this.setContentPane(windowPanel);
		this.setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Allow the app to make sure the user has saves what he wants to save before closing.
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
	
	public WindowPanel getWindowPanel() {
		return this.windowPanel;
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
