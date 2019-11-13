package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public final class SaveMenuItem extends JMenuItem implements ActionListener {

	private final MainWindow mainWindow;
	
	public SaveMenuItem(MainWindow mainWindow) {
		super("Enregistrer...");
		this.mainWindow = mainWindow;
		this.setAccelerator(KeyStroke.getKeyStroke('S', ActionEvent.CTRL_MASK));
		this.addActionListener(this);
	}
	
	public final void actionPerformed(ActionEvent e) {
		JFileChooser saveChooser = new JFileChooser("data/");
		saveChooser.setDialogTitle("Sélectionner le fichier du labyrinthe");
		if(saveChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			this.mainWindow.getMazeModel().getMaze().saveFromTextFile(saveChooser.getSelectedFile().getAbsolutePath());
		}
		}
	
}
