package customIplementations;

public class DynamicCustomQueue extends CustomQueue{
    DynamicCustomQueue() {
        super();
    }

    DynamicCustomQueue(int capacity) {
        super(capacity);
    }

    @Override
    public boolean add(int elem) {
        if(size == data.length){
            int[] temp = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        return super.add(elem);
    }
}
