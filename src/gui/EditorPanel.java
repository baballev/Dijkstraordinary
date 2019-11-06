package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import maze.*;

public class EditorPanel extends JPanel {
	
	private final MainWindow mainWindow;
	private final ArrayList<BlockPanel> blockPanelList;
	
	public EditorPanel(MainWindow mainWindow) {
		super();
		this.mainWindow = mainWindow;
		this.blockPanelList = new ArrayList<BlockPanel>();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.blockPanelList.add(new BlockPanel(this.mainWindow, new EBox(new Maze(), 0, 0), "Empty"));
		this.blockPanelList.add(new BlockPanel(this.mainWindow, new WBox(new Maze(), 0, 0), "Wall"));
		this.blockPanelList.add(new BlockPanel(this.mainWindow, new ABox(new Maze(), 0, 0), "Arrival"));
		this.blockPanelList.add(new BlockPanel(this.mainWindow, new DBox(new Maze(), 0, 0), "Departure"));
		
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(300, 500));
		
	}

	public void notifyForUpdate() {
		for (BlockPanel b : blockPanelList) {
			b.notifyForUpdate();
		}
	}
	
}
