package gui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import maze.*;
import model.*;
import tp04.InvalidMazeException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

@SuppressWarnings("deprecation")
public final class WindowPanel extends JPanel{
	private final MazePanel mazePanel;
	private final EditorPanel editorPanel;
	private final MainWindow mainWindow;
	
	public WindowPanel(MainWindow mainWindow) {
		super();
		
		this.mainWindow = mainWindow;
		
		this.setLayout(new BorderLayout());
		
		this.add(mazePanel = new MazePanel(mainWindow), BorderLayout.WEST);
		this.add(editorPanel = new EditorPanel(mainWindow), BorderLayout.EAST);
		this.setBackground(Color.WHITE);
	}
	
	public boolean checkBeforeContinue() { //Return true if saving the maze to a file is successful and false otherwise
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
						FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers texte", "txt");
						saveChooser.addChoosableFileFilter(filter);
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
		
		return canContinue;
	}
	
	public void notifyForUpdate(Observable observable, Object parameter) {
		if (observable instanceof MazeModel) { 	// Allow to know where the notify comes from.
			this.mazePanel.notifyForUpdate(parameter); 
		}
		else if (observable instanceof EditorModel) this.editorPanel.notifyForUpdate(parameter);
	}
}
