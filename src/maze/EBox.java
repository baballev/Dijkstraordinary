package maze;

public class EBox 
extends MBox 
{
	private String label;
	private MBox[][] labyrinthe;
	
	public EBox(MBox[][] labyrinthe0, int x0, int y0) {
		super(x0,y0);
		labyrinthe=labyrinthe0;
		label="E";
	}
	
	@Override
	public String getLabel() {
		return label;
	}
	
}
