
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}

	public void doIt() {
		
		MyGraph myGraph = new EL(5);
		myGraph.addEdge(0, 1, 5);
		myGraph.addEdge(0, 2, 3);
		myGraph.addEdge(1, 4, 2);
		myGraph.addEdge(2, 3, 4);
		myGraph.addEdge(3, 4, 8);
		myGraph.addEdge(4, 2, 6);
		System.out.println(myGraph);
	}
}
