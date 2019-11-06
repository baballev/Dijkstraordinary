package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;

import maze.*;

public class EditorPanel extends JPanel {
	
	private final MainWindow mainWindow;
	private final ArrayList<BlockPanel> blockPanelList;
	
	public EditorPanel(MainWindow mainWindow) {
		super();
		this.mainWindow = mainWindow;
		this.blockPanelList = new ArrayList<BlockPanel>();
		this.blockPanelList.add(new BlockPanel(mainWindow, new EBox(new Maze(), 0, 0), "Empty"));
		this.blockPanelList.add(new BlockPanel(mainWindow, new WBox(new Maze(), 0, 0), "Wall"));
		this.blockPanelList.add(new BlockPanel(mainWindow, new ABox(new Maze(), 0, 0), "Arrival"));
		this.blockPanelList.add(new BlockPanel(mainWindow, new DBox(new Maze(), 0, 0), "Departure"));
		
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(200, 500));
	}

	public void notifyForUpdate(Object parameter) {
		
	}
	
}
