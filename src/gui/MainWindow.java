package gui;

import javax.swing.*;

import model.MazeModel;

import java.util.*;

@SuppressWarnings("deprecation")
public class MainWindow extends JFrame implements Observer {

	private final MenuBar menuBar;
	private final WindowPanel windowPanel;
	private MazeModel mazeModel = new MazeModel();
	
	public MazeModel getMazeModel() {
		return mazeModel;
	}

	public void setMazeModel(MazeModel mazeModel) {
		this.mazeModel = mazeModel;
	}

	public MainWindow() {
		super("Labyrinthe");
		this.mazeModel.addObserver(this);
		
		menuBar = new MenuBar(this);
		setJMenuBar(menuBar);
		
		windowPanel = new WindowPanel(this);
		this.setContentPane(windowPanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.pack();
		this.setVisible(true);
	}
	
	public void notifyForUpdate(Object parameter) {
		this.windowPanel.notifyForUpdate(parameter);
	}
	
	public void update(Observable observable, Object parameter) { // Called in MazeModel when using notifyObservers(Object parameter); 
		
		this.notifyForUpdate(parameter);
		this.pack();						// Needed, otherwise the panel won't display unless the window is resized.
	}
}
