package customIplementations;


public class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_CAPACITY = 10;
    private int front;
    private int last;
    protected int size;

    CircularQueue() {
        this(DEFAULT_CAPACITY);
    }

    CircularQueue(int capacity) {
        this.data = new int[capacity];
        front = 0;
        last = 0;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean add(int elem) {
        if (size == data.length)
            throw new Error("Queue Overflow");
        data[last] = elem;
        last = (last + 1) % data.length;
        size++;
        return true;
    }

    public boolean offer(int elem) {
        return add(elem);
    }

    public int remove() {
        if (size == 0)
            throw new Error("Queue Underflow");
        int val = data[front];
        front = (front + 1) % data.length;
        size--;
        return val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            int idx = (front + i) % data.length;
            sb.append(data[idx]);
            if (i + 1 < size) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
