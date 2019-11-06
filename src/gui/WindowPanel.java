package gui;

import javax.swing.*;

import maze.*;
import model.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

@SuppressWarnings("deprecation")
public final class WindowPanel extends JPanel{
	private final MazePanel mazePanel;
	private final EditorPanel editorPanel;
	
	public WindowPanel(MainWindow mainWindow) {
		super();
		
		this.setLayout(new BorderLayout());
		
		this.add(mazePanel = new MazePanel(mainWindow), BorderLayout.CENTER);
		this.add(editorPanel = new EditorPanel(mainWindow), BorderLayout.EAST);
	}
	
	public void notifyForUpdate(Observable observable, Object parameter) {
		if (observable instanceof MazeModel) this.mazePanel.notifyForUpdate(parameter);
		else if (observable instanceof EditorModel) this.editorPanel.notifyForUpdate(parameter);
	}
}
