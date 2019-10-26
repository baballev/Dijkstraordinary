package gui;

import javax.swing.*;

public class MainWindow extends JFrame {

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
		
		menuBar = new MenuBar(this);
		setJMenuBar(menuBar);
		
		windowPanel = new WindowPanel(this);
		this.setContentPane(windowPanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.pack();
		this.setVisible(true);
		
	}
}
