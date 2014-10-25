
public class LSNode {
	private int data;
	private LSNode next;
	
	public LSNode() {
		next = null;
		data = 0;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LSNode getNext() {
		return next;
	}
	public void setNext(LSNode next) {
		this.next = next;
	}
	
}
