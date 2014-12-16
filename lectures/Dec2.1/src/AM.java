
public class AM implements MyGraph {
	
	private int matrix[][];
	public static final int NO_PATH = -1;
	
	public AM(int numVertices) {
		matrix = new int[numVertices][numVertices];
		
		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++) {
				matrix[i][j] = NO_PATH;
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see MyGraph#addEdge(int, int, int)
	 */
	@Override
	public void addEdge(int source, int target, int weight) {
		matrix[source][target] = weight;
	}
	
	/* (non-Javadoc)
	 * @see MyGraph#isEdge(int, int)
	 */
	@Override
	public int isEdge(int source, int target) {
		return matrix[source][target];
	}
	
	/* (non-Javadoc)
	 * @see MyGraph#removeEdge(int, int)
	 */
	@Override
	public void removeEdge(int source, int target) {
		matrix[source][target] = NO_PATH;
	}
	
	/* (non-Javadoc)
	 * @see MyGraph#getLabel(int)
	 */
	@Override
	public String getLabel(int vertex) {
		return "Not implemented";
	}
	
	/* (non-Javadoc)
	 * @see MyGraph#setLabel(int, java.lang.String)
	 */
	@Override
	public void setLabel(int vertex, String label) {
		System.out.println("Not implemented");
	}

	/* (non-Javadoc)
	 * @see MyGraph#neighbors(int)
	 */
	@Override
	public int[] neighbors (int vertex) {
		return matrix[vertex];
	}
	
	/* (non-Javadoc)
	 * @see MyGraph#size()
	 */
	@Override
	public int size() {
		return matrix[0].length;
	}
	
	/* (non-Javadoc)
	 * @see MyGraph#toString()
	 */
	@Override
	public String toString() {
		String rtn = "";
		
		for (int i = 0; i < matrix[0].length; i++) {
			rtn += "V" + i + "|";
			for (int j = 0; j < matrix[0].length; j++) {
				rtn += matrix[i][j] + " ";
			}
			rtn += "\n";
		}
		
		
		return rtn;
	}
}
