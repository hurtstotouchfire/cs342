
public class LSNode {
	private double data;
	private LSNode next;
	
	public LSNode() {
		next = null;
		data = 0.0;
	}
	
	public double getData() {
		return data;
	}
	public void setData(double data) {
		this.data = data;
	}
	public LSNode getNext() {
		return next;
	}
	public void setNext(LSNode next) {
		this.next = next;
	}
	
}
