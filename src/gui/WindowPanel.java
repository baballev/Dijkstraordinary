package gui;

import javax.swing.*;
import java.awt.*;

public final class WindowPanel extends JPanel{
	private final MazePanel mazePanel;
	
	public WindowPanel(MainWindow mainWindow) {
		super();
		
		this.setLayout(new BorderLayout());
		
		this.add(mazePanel = new MazePanel(mainWindow), BorderLayout.CENTER);
	}
	
	public void notifyForUpdate(Object parameter) {
		this.mazePanel.notifyForUpdate(parameter);
	}
}
