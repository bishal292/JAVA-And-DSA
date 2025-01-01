
---

### **Instance Methods of ArrayList in Java**

```markdown
# ArrayList: Instance Methods in Java

## Overview
`ArrayList` is part of the `java.util` package and provides dynamic arrays in Java. It includes various instance methods for manipulating list elements.

---

## Methods

### 1. `add()`
- **Description**: Adds an element to the list.
- **Usage**: `list.add(element);`

### 2. `add(index, element)`
- **Description**: Inserts an element at a specific index.
- **Usage**: `list.add(index, element);`

### 3. `remove(index)`
- **Description**: Removes the element at the specified index.
- **Usage**: `list.remove(index);`

### 4. `remove(Object)`
- **Description**: Removes the first occurrence of the specified object.
- **Usage**: `list.remove(object);`

### 5. `get(index)`
- **Description**: Retrieves the element at the specified index.
- **Usage**: `T element = list.get(index);`

### 6. `set(index, element)`
- **Description**: Replaces the element at the specified index with a new value.
- **Usage**: `list.set(index, element);`

### 7. `size()`
- **Description**: Returns the number of elements in the list.
- **Usage**: `int size = list.size();`

### 8. `contains()`
- **Description**: Checks if the list contains a specific element.
- **Usage**: `boolean exists = list.contains(element);`

### 9. `indexOf()`
- **Description**: Returns the index of the first occurrence of the specified element.
- **Usage**: `int index = list.indexOf(element);`

### 10. `lastIndexOf()`
- **Description**: Returns the index of the last occurrence of the specified element.
- **Usage**: `int index = list.lastIndexOf(element);`

### 11. `isEmpty()`
- **Description**: Checks if the list is empty.
- **Usage**: `boolean isEmpty = list.isEmpty();`

### 12. `clear()`
- **Description**: Removes all elements from the list.
- **Usage**: `list.clear();`

### 13. `toArray()`
- **Description**: Converts the list to an array.
- **Usage**: `Object[] array = list.toArray();`

### 14. `subList()`
- **Description**: Returns a sublist from the list.
- **Usage**: `List<T> subList = list.subList(start, end);`

### 15. `forEach()`
- **Description**: Performs the specified action for each element in the list.
- **Usage**: `list.forEach(action);`

### 16. `iterator()`
- **Description**: Returns an iterator for the list.
- **Usage**: `Iterator<T> it = list.iterator();`

---

## Example Usage
```java
import java.util.ArrayList;

public class ArrayListInstanceMethodsDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // Add elements
        list.add(10);
        list.add(20);
        list.add(30);

        // Access element
        System.out.println("Element at index 1: " + list.get(1));

        // Modify element
        list.set(1, 25);
        System.out.println("Modified List: " + list);

        // Remove element
        list.remove((Integer) 25);
        System.out.println("After Removal: " + list);
    }
}
