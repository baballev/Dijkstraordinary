package maze;

import dijkstra.VertexInterface;

public class MBox implements VertexInterface {

	private int x;
	private int y;
	private Maze labyrinthe;

	public MBox(Maze labyrinthe0, int x0, int y0) {
		x = x0;
		y = y0;
		this.labyrinthe = labyrinthe0;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getLabel() {
		return "";
	}

}
