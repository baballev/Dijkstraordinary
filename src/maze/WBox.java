package maze;

public class WBox extends MBox {
	private String label;

	public WBox(Maze labyrinthe0, int x0, int y0) {
		super(labyrinthe0, x0, y0);
		label = "W";
	}

	@Override
	public String getLabel() {
		return label;
	}

}