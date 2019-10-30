package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import maze.*;

public class DijkstraMenuItem extends JMenuItem implements ActionListener{

	private final MainWindow mainWindow;
	
	public DijkstraMenuItem(MainWindow mainWindow) {
		super("R�soudre le labyrinthe");
		this.mainWindow = mainWindow;
		this.setAccelerator(KeyStroke.getKeyStroke('D', ActionEvent.CTRL_MASK));
		this.addActionListener(this);
	}

	public final void actionPerformed(ActionEvent e) {
		if (mainWindow.getMazeModel().getMaze() == null) {
			JOptionPane.showMessageDialog(new JFrame(), "Erreur: Aucun labyrinthe n'a �t� charg� et ne peut donc �tre r�solu!", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		else {
			// TODO REPRENDRE ICIIIIII
		}
		
	}
}
