public class QueueArray implements IQueue {

    private Integer[] queueArray;
    private int head;
    private int tail;
    private int size;
  

    public QueueArray(Integer capacity) {
        this.queueArray = new Integer[capacity];
        this.head = 0;
        this.tail = -1;
        this.size = capacity;

    }

    @Override
    public void enqueue(Integer value) {
        if (tail == queueArray.length - 1) {
            throw new IllegalStateException("Queue cannot enqueue more than 3 elements");
        } else {
            tail++;
            queueArray[tail] = value;

        }

    }

    @Override
    public Integer dequeue() throws Exception {
        int aux = queueArray[head];
        if (!isEmpty()) {

            for (int i = 0; i < size; i++) {
                if (i < queueArray.length - 1) {
                    queueArray[head] = queueArray[i + 1];
                }

            }
            tail--;
            size--;
            return aux;
        }
        throw new IllegalStateException("Queue is empty");
    }

    @Override
    public boolean isEmpty() {
        if (tail == -1) {
            return true;
        }
        return false;
    }


}
