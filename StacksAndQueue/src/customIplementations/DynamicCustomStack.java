package customIplementations;

public class DynamicCustomStack extends CustomStack {
    DynamicCustomStack() {
        super();
    }

    DynamicCustomStack(int capacity) {
        super(capacity);
    }

    @Override
    public boolean push(int element) throws Exception {
        if(size == data.length){
            int[] temp = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        return super.push(element);
    }
}
