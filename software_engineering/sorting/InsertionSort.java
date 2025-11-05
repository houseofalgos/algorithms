public class InsertionSort {
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    void sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null.");
        }

        int arrayLength = array.length;

        for (int iteration = 1; iteration < arrayLength; iteration++) {
            int index = iteration - 1;
            int currentElement = array[iteration];

            while (0 <= index && currentElement < array[index]) {
                array[index + 1] = array[index--];
            }

            array[index + 1] = currentElement;
        }
    }

    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    void reverseSort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null.");
        }

        int arrayLength = array.length;

        for (int iteration = 1; iteration < arrayLength; iteration++) {
            int index = iteration - 1;
            int currentElement = array[iteration];

            while (0 <= index && array[index] < currentElement) {
                array[index + 1] = array[index--];
            }

            array[index + 1] = currentElement;
        }
    }
}
