package customIplementations;

public class DynamicCircularQueue extends CircularQueue{

    public DynamicCircularQueue() {
        super();
    }

    public DynamicCircularQueue(int capacity) {
        super(capacity);
    }

    public boolean add(int elem) {
        if (size == data.length){
            int[] temp = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        return super.add(elem);
    }
}
