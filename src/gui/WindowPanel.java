package gui;

import javax.swing.*;

import maze.Maze;

import java.awt.*;

public final class WindowPanel extends JPanel{
	private final MazePanel mazePanel;  // TODO: check final keyword.
	private final EditorPanel editorPanel;
	
	public WindowPanel(MainWindow mainWindow) {
		super();
		
		this.setLayout(new BorderLayout());
		
		this.add(mazePanel = new MazePanel(mainWindow), BorderLayout.CENTER);
		this.add(editorPanel = new EditorPanel(mainWindow), BorderLayout.EAST);
	}
	
	public void notifyForUpdate(Object parameter) {
		this.mazePanel.notifyForUpdate(parameter);
	}
}
