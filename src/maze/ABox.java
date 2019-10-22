package maze;

public class ABox 
extends MBox 
{
	private String label;
	private MBox[][] labyrinthe;
	
	public ABox(MBox[][] labyrinthe0, int x0, int y0) {
		super(x0,y0);
		labyrinthe=labyrinthe0;
		label="A";
	}
	
	@Override
	public String getLabel() {
		return label;
	}
	
}
