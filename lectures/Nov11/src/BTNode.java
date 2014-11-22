
public class BTNode {
	private Integer data;
	private BTNode lchild;
	private BTNode rchild;
	
	
	public BTNode() {
		lchild = null;
		rchild = null;
	}
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public BTNode getLchild() {
		return lchild;
	}
	public void setLchild(BTNode lchild) {
		this.lchild = lchild;
	}
	public BTNode getRchild() {
		return rchild;
	}
	public void setRchild(BTNode rchild) {
		this.rchild = rchild;
	}
}
