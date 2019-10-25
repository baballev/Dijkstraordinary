package dijkstra;

import java.util.Hashtable;

public class Pi implements PiInterface {

	Hashtable<VertexInterface, Integer> pi;

	public Pi() {
		pi = new Hashtable<VertexInterface, Integer>();
	}

	public void setValue(VertexInterface vertex, int value) {
		Integer v = new Integer(value);
		pi.put(vertex, v);
	}

	public int getValue(VertexInterface vertex) {
		int tmp;
		tmp = pi.get(vertex).intValue();
		return tmp;

	}

}