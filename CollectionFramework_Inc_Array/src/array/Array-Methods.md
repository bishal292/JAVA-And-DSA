# Arrays: Static Methods in Java

## Overview
Java's `Arrays` class (from the `java.util` package) provides utility methods for array manipulation. These methods are all static.

---

## Methods

### 1. `Arrays.sort()`
- **Description**: Sorts the array in ascending order.
- **Usage**: `Arrays.sort(array);`

### 2. `Arrays.binarySearch()`
- **Description**: Searches for a specific element in a sorted array.
- **Usage**: `int index = Arrays.binarySearch(array, key);`

### 3. `Arrays.equals()`
- **Description**: Compares two arrays for equality.
- **Usage**: `boolean isEqual = Arrays.equals(array1, array2);`

### 4. `Arrays.fill()`
- **Description**: Fills the entire array or a part of it with a specific value.
- **Usage**: `Arrays.fill(array, value);`

### 5. `Arrays.copyOf()`
- **Description**: Creates a new array by copying elements from an existing array up to a specified length.
- **Usage**: `int[] newArray = Arrays.copyOf(array, newLength);`

### 6. `Arrays.copyOfRange()`
- **Description**: Creates a new array by copying a specified range of elements.
- **Usage**: `int[] newArray = Arrays.copyOfRange(array, start, end);`

### 7. `Arrays.toString()`
- **Description**: Returns a string representation of the array.
- **Usage**: `String arrayString = Arrays.toString(array);`

### 8. `Arrays.asList()`
- **Description**: Converts an array into a fixed-size `List`.
- **Usage**: `List<Integer> list = Arrays.asList(array);`

### 9. `Arrays.deepToString()`
- **Description**: Returns a string representation of a multidimensional array.
- **Usage**: `String arrayString = Arrays.deepToString(array);`

### 10. `Arrays.deepEquals()`
- **Description**: Compares two multidimensional arrays for deep equality.
- **Usage**: `boolean isEqual = Arrays.deepEquals(array1, array2);`

### 11. `Arrays.stream()`
- **Description**: Creates a sequential stream from the array.
- **Usage**: `Stream<Integer> stream = Arrays.stream(array);`

### 12. `Arrays.parallelSort()`
- **Description**: Sorts the array using a parallel sorting algorithm.
- **Usage**: `Arrays.parallelSort(array);`

### 13. `Arrays.mismatch()`
- **Description**: Finds and returns the first index where two arrays differ.
- **Usage**: `int index = Arrays.mismatch(array1, array2);`

---

## Example Usage
```java
import java.util.Arrays;

public class ArrayStaticMethodsDemo {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1};
        Arrays.sort(array);
        System.out.println("Sorted Array: " + Arrays.toString(array));

        int index = Arrays.binarySearch(array, 8);
        System.out.println("Index of 8: " + index);

        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 42);
        System.out.println("Filled Array: " + Arrays.toString(filledArray));
    }
}
