package maze;

public class DBox 
extends MBox 
{
	private String label;
	
	public DBox(Maze labyrinthe0, int x0, int y0) {
		super(labyrinthe0, x0,y0);
		label="D";
	}
	
	@Override
	public String getLabel() {
		return label;
	}
	
}
