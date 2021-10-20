
public interface QueueInterface2<T> extends Iterable<T> {
	public void enqueue(T aData);
	public T dequeue();
	public T peek();
	public void print();
	public int size();
}