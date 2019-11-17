package gui.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

import dijkstra.Dijkstra;
import dijkstra.Previous;
import dijkstra.VertexInterface;
import gui.MainWindow;
import maze.*;

public class DijkstraMenuItem extends JMenuItem implements ActionListener{

	private final MainWindow mainWindow;
	
	public DijkstraMenuItem(MainWindow mainWindow) {
		super("Résoudre le labyrinthe");
		this.mainWindow = mainWindow;
		this.setAccelerator(KeyStroke.getKeyStroke('D', ActionEvent.CTRL_MASK));
		this.addActionListener(this);
	}

	public final void actionPerformed(ActionEvent e) {
		if (mainWindow.getMazeModel().getMaze() == null) {
			JOptionPane.showMessageDialog(new JFrame(), "Erreur: Aucun labyrinthe n'a été chargé et ne peut donc être résolu!", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		else {
			int i = mainWindow.getMazeModel().solve();
			if (i == 0) {
				JOptionPane.showMessageDialog(null, "Échec de la résolution du labyrinthe: il n'existe pas de chemin du départ à l'arrivée.", "Échec", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
}
 