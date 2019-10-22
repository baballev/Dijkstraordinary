package maze;

public class DBox 
extends MBox 
{
	private String label;
	private MBox[][] labyrinthe;
	
	public DBox(MBox[][] labyrinthe0, int x0, int y0) {
		super(x0,y0);
		labyrinthe=labyrinthe0;
		label="D";
	}
	
	@Override
	public String getLabel() {
		return label;
	}
	
}
