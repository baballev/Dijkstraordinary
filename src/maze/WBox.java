package maze;

public class WBox 
extends MBox 
{
	private String label;
	private MBox[][] labyrinthe;
	
	public WBox(MBox[][] labyrinthe0, int x0, int y0) {
		super(x0,y0);
		labyrinthe=labyrinthe0;
		label="W";
	}
	
	@Override
	public String getLabel() {
		return label;
	}
	
}