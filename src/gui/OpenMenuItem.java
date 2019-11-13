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
		
		// TODO: modified mazeModel, demander confirmation à l'utilisateur s'il n'a pas sauvegardé le fichier avant d'ouvrir un nouveau labyrinthe.
		
		final JFileChooser fc = new JFileChooser("data/");
		fc.setDialogTitle("Sélectionner le fichier du labyrinthe");
		fc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers texte", "txt");
		fc.addChoosableFileFilter(filter);
		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File selectedMazeFile = fc.getSelectedFile();
			Maze newMaze = new Maze();
			String path  = selectedMazeFile.getAbsolutePath();
			newMaze.setSizeFromTextFile(path);
			newMaze.initFromTextFile(path);
			mainWindow.getMazeModel().setMaze(newMaze); 
			mainWindow.getEditorModel().setupEditor();
		}
	}
}
