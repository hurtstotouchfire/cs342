public interface MyBTree {

	public abstract boolean add(Integer data);

	public abstract void print();

	public abstract void preOrder();

	public abstract void inOrder();

	public abstract void postOrder();

	public abstract boolean search(Integer num);

}