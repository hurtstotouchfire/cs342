
public class Vertex {
	private int num;
	private Vertex nextVertex;
	private Edge edge;

	public Vertex() {
		nextVertex = null;
		edge = null;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Vertex getNextVertex() {
		return nextVertex;
	}
	public void setNextVertex(Vertex nextVertex) {
		this.nextVertex = nextVertex;
	}
	public Edge getEdge() {
		return edge;
	}
	public void setEdge(Edge edge) {
		this.edge = edge;
	}

}
