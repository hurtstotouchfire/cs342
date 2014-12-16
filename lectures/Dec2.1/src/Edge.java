
public class Edge {
  private int weight;
  private int vertex;
  private Edge next;
  
  //private Vertex v;
  
  public Edge(int weight, int vertex, Edge next) {
	  this.weight = weight;
	  this.vertex = vertex;
	  this.next = next;
  }
  
public Edge getNext() {
	return next;
}
public void setNext(Edge next) {
	this.next = next;
}
public int getWeight() {
	return weight;
}
public void setWeight(int weight) {
	this.weight = weight;
}
public int getVertex() {
	return vertex;
}
public void setVertex(int vertex) {
	this.vertex = vertex;
}
}
