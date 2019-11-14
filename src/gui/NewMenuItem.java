package gui;

import javax.swing.*; // GUI

import maze.Maze;
import tp04.InvalidMazeException;

import java.awt.*;    // KeyStrokes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class NewMenuItem extends JMenuItem implements ActionListener {

	private final MainWindow mainWindow;
	
	public NewMenuItem(MainWindow mainWindow) {
		super("Nouveau");
		this.mainWindow = mainWindow;
		this.setAccelerator(KeyStroke.getKeyStroke('N', ActionEvent.CTRL_MASK));
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
			} else canContinue = false;
		} else canContinue = true;
		if (canContinue) {
		boolean done = false;
		while (!done) {
			JTextField widthField = new JTextField();
			JTextField heightField = new JTextField();
			Object[] fields = { "Largeur: ", widthField, "Hauteur: ", heightField };
			int newPane = JOptionPane.showConfirmDialog(null, fields, "Nouveau labyrinthe",
					JOptionPane.OK_CANCEL_OPTION);
			if (newPane == JOptionPane.YES_OPTION) {
				try {
					int width = Integer.parseInt(widthField.getText());
					int height = Integer.parseInt(heightField.getText());
					Maze newMaze = new Maze(width, height);
					newMaze.fillWithEmpty();
					this.mainWindow.getMazeModel().setMaze(newMaze);
					mainWindow.getEditorModel().setupEditor();
					
					done = true;
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
					JOptionPane.showMessageDialog(new JFrame(), "Erreur: Largeur ou hauteur incorrecte(s).", "Erreur",
							JOptionPane.ERROR_MESSAGE);
				}
			} else if (newPane == JOptionPane.CANCEL_OPTION || newPane == JOptionPane.CLOSED_OPTION) done = true;
		}
		}
	}
}
