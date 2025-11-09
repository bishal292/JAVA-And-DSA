package customIplementations;

public class CustomStack {
    private static final int DEFAULT_CAPACITY = 10;
    protected int[] data;
    protected int size;

    CustomStack(int capacity) {
        data = new int[capacity];
        this.size = 0;
    }

    CustomStack() {
        this(DEFAULT_CAPACITY);
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public boolean push(int element) throws Exception {
        if (size >= data.length) throw new Exception("Stack Overflow");
        data[size++] = element;
        return true;
    }

    public int pop() throws Exception {
        if (size == 0) throw new Exception("Stack UnderFlow");
        return data[--size];
    }

    public int peek() throws Exception {
        if (size <= 0) throw new Exception("Stack UnderFlow");
        int idx = size - 1;
        return data[idx];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i + 1 < size) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public int getSize() {
        return size;
    }

    public int getCapacity(){
        return data.length;
    }
}
