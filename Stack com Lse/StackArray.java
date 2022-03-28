public class StackArray implements IStack {
    private Integer[] num;
    private int top;

    public StackArray(int capacity) {
        this.num = new Integer[capacity];
        this.top = -1;
    }

    @Override
    public void push(Integer value) {
        if (this.top < this.num.length - 1) {
            this.num[top = +1] = value;
        } else {
            throw new IllegalStateException("Stack cannot push more than 3 elements"); 
        }

    }

    @Override
    public Integer pop() throws IllegalStateException {
        if (top < 0) {
            throw new IllegalStateException("isEmpty");
        }

        return this.num[this.top--];
    }

    @Override
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } 
            return false;
        
    }
}
