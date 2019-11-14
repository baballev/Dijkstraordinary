package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.*;

public final class QuitMenuItem extends JMenuItem implements ActionListener {
	
	private final MainWindow mainWindow;
	
	public QuitMenuItem(MainWindow mainWindow) {
		super("Quitter");
		this.mainWindow = mainWindow;
		this.setAccelerator(KeyStroke.getKeyStroke('Q', ActionEvent.CTRL_MASK));
		this.addActionListener(this);
	}
	
	public final void actionPerformed(ActionEvent e) {
		boolean canContinue = this.mainWindow.getWindowPanel().checkBeforeContinue();
		if (canContinue) {
			mainWindow.dispatchEvent(new WindowEvent(mainWindow, WindowEvent.WINDOW_CLOSING));
		}
	}
}
