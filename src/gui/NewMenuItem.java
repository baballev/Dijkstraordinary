package gui;

import javax.swing.*; // GUI
import java.awt.*;    // KeyStrokes
import java.awt.event.ActionEvent;

public final class NewMenuItem extends JMenuItem {

	private final MainWindow mainWindow;
	
	public NewMenuItem(MainWindow mainWindow) {
		super("Nouveau");
		this.mainWindow = mainWindow;
		this.setAccelerator(KeyStroke.getKeyStroke('N', ActionEvent.CTRL_MASK));
	}
}
