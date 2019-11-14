package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import gui.MainWindow;
import maze.Maze;
import tp04.InvalidMazeException;

public final class SaveMenuItem extends JMenuItem implements ActionListener {

	private final MainWindow mainWindow;
	
	public SaveMenuItem(MainWindow mainWindow) {
		super("Enregistrer...");
		this.mainWindow = mainWindow;
		this.setAccelerator(KeyStroke.getKeyStroke('S', ActionEvent.CTRL_MASK));
		this.addActionListener(this);
	}
	
	public final void actionPerformed(ActionEvent e) {
		if (mainWindow.getMazeModel().getMaze() == null) {
			JOptionPane.showMessageDialog(new JFrame(),
					"Erreur: Aucun labyrinthe n'a �t� charg� et ne peut donc �tre sauvegard�!", "Erreur",
					JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				if (!mainWindow.getMazeModel().getMaze().isLegit())
					throw new InvalidMazeException("Erreur: Labyrinthe icorrect.");
				JFileChooser saveChooser = new JFileChooser("data/");
				saveChooser.setDialogTitle("S�lectionner le fichier o� sauvegarder le labyrinthe");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers texte", "txt");
				saveChooser.setFileFilter(filter);
				if (saveChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					this.mainWindow.getMazeModel().getMaze()
							.saveFromTextFile(saveChooser.getSelectedFile().getAbsolutePath());
					this.mainWindow.getMazeModel().setModified(false);
				}
			} catch (InvalidMazeException ime) {
				ime.printStackTrace();
				JOptionPane.showMessageDialog(new JFrame(), ime.getErrorMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(new JFrame(),
						"Erreur: Une erreur s'est produite lors de l'�criture du fichier. V�rifiez les droits d'acc�s de l'applicaiton.",
						"Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
