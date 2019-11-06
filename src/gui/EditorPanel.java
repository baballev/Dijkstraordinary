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
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(200, 500));
	}

	public void notifyForUpdate(Object parameter) {
		this.removeAll();
		MBox newMBox = (MBox) parameter;
		this.blockPanelList.add(new BlockPanel(this.mainWindow, newMBox)); 
		for (BlockPanel b : blockPanelList) {
			b.notifyForUpdate();
		}
	}

	
}
