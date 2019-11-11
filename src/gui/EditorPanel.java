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
		this.setPreferredSize(new Dimension(150, 200));
	}

	public void notifyForUpdate(Object parameter) {
		this.removeAll();
		this.blockPanelList.clear();
		for(MBox box :(ArrayList<MBox>) parameter) {
			BlockPanel blockPanel = new BlockPanel(this.mainWindow, box);
			this.blockPanelList.add(blockPanel);
			this.add(blockPanel);
			blockPanel.notifyForUpdate();
		}
	}

	
}
