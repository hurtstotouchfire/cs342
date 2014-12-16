
public class EL implements MyGraph {

	private Vertex graph;
	private int numVertices = 0;
	public static final int NO_PATH = -1;

	public EL(int num) {
		Vertex prev = null;
		
		for (int i = 0; i < num; i++) {
			Vertex tmp = new Vertex();
			tmp.setNum(i);
			
			if (i == 0) {
				graph = tmp;
			} else {
				prev.setNextVertex(tmp);
			}
			prev = tmp;
		}
		numVertices = num;
	}
	
	@Override
	public void addEdge(int source, int target, int weight) {
		Vertex n = getVertex(source);
		
		if (n == null) {
			System.out.println("No such vertex");
			return;
		}
		
		Edge e = new Edge(weight, target, n.getEdge());
		n.setEdge(e);
	}

	@Override
	public int isEdge(int source, int target) {
		Vertex n = getVertex(source);
		
		if (n == null) {
			return NO_PATH;
		}
		
		Edge e = n.getEdge();
		while(e != null) {
			if (e.getVertex() == target) {
				return e.getWeight();
			}
			e = e.getNext();
		}
		return NO_PATH;
	}

	@Override
	public void removeEdge(int source, int target) {
	
		Vertex n = getVertex(source);
		
		if (n == null) {
			return;
		}
		
		Edge cur = n.getEdge();
		Edge prev = null;
		while(cur != null) {
			if (cur.getVertex() == target) {
				if (prev == null) {
					// first item
					n.setEdge(n.getEdge().getNext());
					return;
				} else {
					prev.setNext(cur.getNext());
				}
				
			}
			prev = cur;
			cur = cur.getNext();
		}
		return;
		

	}

	@Override
	public String getLabel(int vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLabel(int vertex, String label) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] neighbors(int vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private Vertex getVertex(int num) {
		Vertex n = graph;
		for (int i = 0; i < numVertices; i++) {
			if (n.getNum() == num) {
				break;
			}
			n = n.getNextVertex();
		}
		
		return n;

	}
	
	public String toString() {
		String rtn = "";
		Vertex v = graph;
		
		while (v != null) {
			rtn += "V" + v.getNum() + "|";
			Edge e = v.getEdge();
			while (e != null) {
				rtn += e.getVertex() + "(" + e.getWeight() + ") ";
				e = e.getNext();
			}
			rtn += "\n";
			v = v.getNextVertex();
		}
		
		return rtn;
	}

}
