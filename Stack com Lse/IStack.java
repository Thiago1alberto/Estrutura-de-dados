public interface IStack {

	public void push(Integer value);

	public Integer pop() throws IllegalStateException, Exception;

	public boolean isEmpty();
}
