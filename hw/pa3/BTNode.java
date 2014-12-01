
public class BTNode {
    private Integer count;
    private String word;
    private BTNode lchild;
    private BTNode rchild;
	
    public BTNode(String word) {
	lchild = null;
	rchild = null;
	count = 1;
	this.word = word;
    }

    // Data handlers
    public Integer getCount() {
	return count;
    }
    public void incrCount() {
	count++;
    }
    public String getWord() {
	return word;
    }
    public void setWord(String word) {
	this.word = word;
    }

    // Child handlers
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
