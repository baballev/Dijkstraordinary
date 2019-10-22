package maze;

public class ABox 
extends MBox 
{
	private String label;
	
	public ABox(Maze labyrinthe0, int x0, int y0) {
		super(labyrinthe0, x0,y0);
		label="A";
	}
	
	@Override
	public String getLabel() {
		return label;
	}
	
}
