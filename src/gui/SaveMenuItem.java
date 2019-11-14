package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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
			try {
				if (!mainWindow.getMazeModel().getMaze().isLegit()) throw new InvalidMazeException("Erreur: Labyrinthe icorrect.");
				JFileChooser saveChooser = new JFileChooser("data/");
				saveChooser.setDialogTitle("Sélectionner le fichier où sauvegarder le labyrinthe");
				if(saveChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					this.mainWindow.getMazeModel().getMaze().saveFromTextFile(saveChooser.getSelectedFile().getAbsolutePath());
					this.mainWindow.getMazeModel().setModified(false);
				}
			} catch (InvalidMazeException ime) {
				ime.printStackTrace();
				JOptionPane.showMessageDialog(new JFrame(), ime.getErrorMessage(), "Erreur",
						JOptionPane.ERROR_MESSAGE);
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(new JFrame(), "Erreur: Une erreur s'est produite lors de l'écriture du fichier. Vérifiez les droits d'accès de l'applicaiton.", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	
}
