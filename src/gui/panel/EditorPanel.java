package gui.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import gui.MainWindow;
import maze.*;

public class EditorPanel extends JPanel {
	
	private final MainWindow mainWindow;
	private final ArrayList<BlockPanel> blockPanelList;
	
	public EditorPanel(MainWindow mainWindow) {
		super();
		this.mainWindow = mainWindow;
		this.blockPanelList = new ArrayList<BlockPanel>();
		this.setBackground(Color.WHITE);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(150, 200));
	}
	

	public void notifyForUpdate(Object parameter) {
		if (parameter instanceof ArrayList<?>) {
			this.removeAll();
			this.setBackground(Color.WHITE);
			this.blockPanelList.clear();
			for (MBox box : (ArrayList<MBox>) parameter) {
				BlockPanel blockPanel = new BlockPanel(this.mainWindow, box);
				this.blockPanelList.add(blockPanel);
				this.add(blockPanel);
				blockPanel.notifyForUpdate();
			}
		}
		else {
			int index = (int) parameter;
			for (int k =0; k < this.blockPanelList.size(); k++) {
				if (k != index) this.blockPanelList.get(k).notifyForUpdate();
			}
		}
	}

}
