package gui;

import javax.swing.*;

public class MainWindow extends JFrame {

	private final MenuBar menuBar;
	
	public MainWindow() {
		super("Labyrinthe");
		
		menuBar = new MenuBar(this);
		setJMenuBar(menuBar);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pack();
		setVisible(true);
		
	}
}
