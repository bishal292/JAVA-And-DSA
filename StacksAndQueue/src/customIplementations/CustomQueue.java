package customIplementations;

public class CustomQueue {
    protected int[] data;
    private static final int DEFAULT_CAPACITY = 10;
    protected int size;

    CustomQueue(){
        this(DEFAULT_CAPACITY);
    }
    CustomQueue(int capacity){
        this.data = new int[capacity];
        this.size = 0;
    }

    
    public int size() {
        return size == 0 ? -1: size;
    }

    
    public boolean isEmpty() {
        return size == 0;
    }

    
    public boolean contains(int o) {
        for (int i : data){
            if (i == o){
                return true;
            }
        }
        return false;
    }

    public boolean add(int elem) {
        if (size == data.length)throw new Error("Stack OverFlow");
        data[size++] = elem;
        return true;
    }


    public int remove() {
        if (size == 0)throw new Error("Queue is Empty");
        int val = data[0];
        size--;
        for (int i = 0; i < size;i++){
            data[i] = data[i+1];
        }
        return val;
    }


    public void clear() {
        size = 0;
    }

    
    public boolean offer(int elem) {
        return add(elem);
    }

    public int poll() {
        return remove();
    }

    
    public int peek() {
        if (size == 0)throw new Error("Queue is Empty");
        return data[0];
    }


    public int getCapacity(){
        return data.length;
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
}
