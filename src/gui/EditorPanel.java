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
		System.out.println("Chips");
		this.removeAll();
		MBox newMBox = (MBox) parameter;
		BlockPanel blockPanel = new BlockPanel(this.mainWindow, newMBox);
		this.blockPanelList.add(blockPanel);
		for (BlockPanel b : blockPanelList) {
			this.add(b);
			b.notifyForUpdate();
		}
	}

	
}
