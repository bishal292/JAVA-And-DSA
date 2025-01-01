## More Instance Methods of ArrayList

### 17. `retainAll()`
- **Description**: Retains only the elements in this list that are contained in the specified collection.
- **Usage**: `list.retainAll(collection);`

### 18. `removeAll()`
- **Description**: Removes all elements in the list that are also contained in the specified collection.
- **Usage**: `list.removeAll(collection);`

### 19. `addAll()`
- **Description**: Adds all elements of a specified collection to the list.
- **Usage**: `list.addAll(collection);`

### 20. `addAll(index, collection)`
- **Description**: Inserts all elements of a specified collection into the list at a specified index.
- **Usage**: `list.addAll(index, collection);`

### 21. `equals()`
- **Description**: Compares the specified object with this list for equality.
- **Usage**: `boolean isEqual = list.equals(otherList);`

### 22. `hashCode()`
- **Description**: Returns the hash code for the list.
- **Usage**: `int hashCode = list.hashCode();`

### 23. `replaceAll()`
- **Description**: Replaces each element in the list with the result of applying a given unary operator.
- **Usage**: `list.replaceAll(operator);`

### 24. `sort()`
- **Description**: Sorts the elements in the list using the specified comparator.
- **Usage**: `list.sort(comparator);`

### 25. `removeIf()`
- **Description**: Removes all elements that satisfy the given predicate.
- **Usage**: `list.removeIf(predicate);`

### 26. `spliterator()`
- **Description**: Creates a late-binding and fail-fast spliterator for the elements of this list.
- **Usage**: `Spliterator<T> spliterator = list.spliterator();`

### 27. `stream()`
- **Description**: Returns a sequential stream with this list as its source.
- **Usage**: `Stream<T> stream = list.stream();`

### 28. `parallelStream()`
- **Description**: Returns a possibly parallel stream with this list as its source.
- **Usage**: `Stream<T> parallelStream = list.parallelStream();`

---

## Example Usage of Advanced Methods
```java
import java.util.ArrayList;
import java.util.List;

public class AdvancedArrayListMethodsDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Remove if element is even
        list.removeIf(n -> n % 2 == 0);
        System.out.println("After removeIf: " + list); // [1, 3, 5]

        // Replace all elements
        list.replaceAll(n -> n * 2);
        System.out.println("After replaceAll: " + list); // [2, 6, 10]

        // Sort elements
        list.sort((a, b) -> b - a);
        System.out.println("After sort: " + list); // [10, 6, 2]
    }
}
