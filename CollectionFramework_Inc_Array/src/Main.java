import java.util.LinkedList;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
///        Similar as Arraylist but it is thread safe means no multiple threads can access simultaneously.
///        For further details have a look to the specific contents section

        Vector<Integer> vector = new Vector<>();

        vector.add(12);
        vector.add(21);
        vector.add(14);
        vector.add(15);

        System.out.println(vector);

    }
}
