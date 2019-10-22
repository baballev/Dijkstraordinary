package maze;

import dijkstra.VertexInterface;

public class MBox 
implements VertexInterface
{
	
	private int x;
	private int y;
	
	public MBox(int x0, int y0) {
		x=x0;
		y=y0;
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
