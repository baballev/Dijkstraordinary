package gui;

import javax.swing.*; // GUI

import maze.Maze;

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
