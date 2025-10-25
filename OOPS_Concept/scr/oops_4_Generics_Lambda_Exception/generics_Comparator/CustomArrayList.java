package oops_4_Generics_Lambda_Exception.generics_Comparator;

public class CustomArrayList<T extends Number> {
    ///  here T is generics type and 'extends Number' is limiting the upper Bound means T can be either Number itself or the subclasses of 'Number' means classes extending Number.
//    private T[] data; /// Works fine.

    private Object[] data;
    /// But using Object[] gives an upper hand cuz all class in java are in a way child class of 'Object'.

    private static final int DEFAULT_SIZE = 10;
    /// The default size of custom arraylist will be 10.
    private int size = 0;

    public CustomArrayList(int size) {
//        This will throw an error because an array of generic type cannot be created directly. As JVM does not know what exact type T is → so it cannot allocate an array of T.
//        data = new T[size];

///     This will work because we have mentioned above that T is extending Number means Number is the upper class and in a way we are saying JVM that “trust me, this Number[] is used as T[]”
//        data = (T[]) (new Number[size]);

        data = new Object[size];
    }

    public CustomArrayList() {
//        data = (T[])(new Number[DEFAULT_SIZE]);

        data = new Object[DEFAULT_SIZE];

    }

    public void add(T d) {
        if (isFull()){
            reSize();
        }
        data[size++] = d;
    }

    public T get(int index) {
        if (index < 0 && index >= size) throw new IndexOutOfBoundsException("Index " + index + " out of range.");

//        return data[index];

        return (T) (data[index]);
    }

    public T remove() {
        return (T) (data[--size]);
    }

    public T remove(int index){
        if (index < 0 && index >= size) throw new IndexOutOfBoundsException("Index " + index + " out of range.");
        T removed = (T)data[index];
        for (int i = index;i<size-1;i++){
            data[i] = data[i+1];
        }
        size--;
        return removed;
    }

    public int size() {
        return size;
    }
    private boolean isFull(){
        return size == data.length;
    }
    private void reSize(){
//        T[] temp = (T[])(new Number[size*2]);
        Object[] temp = new Object[size * 2];
        for (int i = 0; i <data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
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
