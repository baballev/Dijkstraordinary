package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import maze.*;
import tp04.InvalidMazeException;

public final class OpenMenuItem extends JMenuItem implements ActionListener {
	
	private final MainWindow mainWindow;
	
	public OpenMenuItem(MainWindow mainWindow) {
		super("Ouvrir...");
		this.mainWindow = mainWindow;
		this.setAccelerator(KeyStroke.getKeyStroke('O', ActionEvent.CTRL_MASK));
		this.addActionListener(this);
	}

	public final void actionPerformed(ActionEvent e) {
		boolean canContinue;
		if (this.mainWindow.getMazeModel().isModified()) {
			int confirm = JOptionPane.showConfirmDialog(null, "Labyrinthe modifié, êtes-vous sûr de vouloir continuer sans sauvegarder?");
			if (confirm == JOptionPane.YES_OPTION) {
				canContinue = true;
			} else if (confirm == JOptionPane.NO_OPTION) {
				try {
					if (!mainWindow.getMazeModel().getMaze().isLegit()) throw new InvalidMazeException("Erreur: Labyrinthe icorrect.");
					JFileChooser saveChooser = new JFileChooser("data/");
					saveChooser.setDialogTitle("Sélectionner le fichier où sauvegarder le labyrinthe");
					if(saveChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
						this.mainWindow.getMazeModel().getMaze().saveFromTextFile(saveChooser.getSelectedFile().getAbsolutePath());
						this.mainWindow.getMazeModel().setModified(false);
						canContinue = true;
					}
					else canContinue = false;
				} catch (InvalidMazeException ime) {
					ime.printStackTrace();
					JOptionPane.showMessageDialog(new JFrame(), ime.getErrorMessage(), "Erreur",
							JOptionPane.ERROR_MESSAGE);
					canContinue = false;
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(new JFrame(), "Erreur: Une erreur s'est produite lors de l'écriture du fichier. Vérifiez les droits d'accès de l'applicaiton.", "Erreur",
							JOptionPane.ERROR_MESSAGE);
					canContinue = false;
				}
			}
			else canContinue = false;
		} else canContinue = true;
		
		if (canContinue) {
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
}
