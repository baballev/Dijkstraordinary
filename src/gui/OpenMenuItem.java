package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import maze.*;

public final class OpenMenuItem extends JMenuItem implements ActionListener {
	
	private final MainWindow mainWindow;
	
	public OpenMenuItem(MainWindow mainWindow) {
		super("Ouvrir...");
		this.mainWindow = mainWindow;
		this.setAccelerator(KeyStroke.getKeyStroke('O', ActionEvent.CTRL_MASK));
		this.addActionListener(this);
	}

	public final void actionPerformed(ActionEvent e) {
		final JFileChooser fc = new JFileChooser("data/");
		fc.setDialogTitle("S�lectionner le fichier du labyrinthe");
		fc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers texte", "txt");
		fc.addChoosableFileFilter(filter);
		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File selectedMazeFile = fc.getSelectedFile();
			Maze newMaze = new Maze(10, 10); // TODO: Find a way to automatically set maze's size!
			newMaze.initFromTextFile(selectedMazeFile.getAbsolutePath());
			mainWindow.getMazeModel().setMaze(newMaze); 
		}
	}
}
