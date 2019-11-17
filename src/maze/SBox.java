package maze;

public class SBox extends MBox {
	private String label;
	public static final String NAME = "Path";

	public SBox(Maze labyrinthe0, int x0, int y0) {
		super(labyrinthe0, x0, y0);
		label = "S";
	}

	@Override
	public String getLabel() {
		return label;
	}
	@Override
	public void setLabel() {
		label=".";
	}
	@Override
	public String getName() {
		return NAME;
	}
}
