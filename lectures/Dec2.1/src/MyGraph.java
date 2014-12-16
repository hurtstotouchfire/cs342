public interface MyGraph {

	public abstract void addEdge(int source, int target, int weight);

	public abstract int isEdge(int source, int target);

	public abstract void removeEdge(int source, int target);

	public abstract String getLabel(int vertex);

	public abstract void setLabel(int vertex, String label);

	public abstract int[] neighbors(int vertex);

	public abstract int size();

	public abstract String toString();

}