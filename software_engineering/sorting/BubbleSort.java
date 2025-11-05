public class BubbleSort {
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    void sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null.");
        }

        int arrayLength = array.length;

        for (int leftIndex = 0; leftIndex < arrayLength - 1; leftIndex++) {
            for (int rightIndex = arrayLength - 1; leftIndex < rightIndex; rightIndex--) {
                if (array[rightIndex] < array[rightIndex - 1]) {
                    int temp = array[rightIndex - 1];

                    array[rightIndex - 1] = array[rightIndex];
                    array[rightIndex] = temp;
                }
            }
        }
    }

    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    void reverseSort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null.");
        }

        int arrayLength = array.length;

        for (int leftIndex = 0; leftIndex < arrayLength - 1; leftIndex++) {
            for (int rightIndex = arrayLength - 1; leftIndex < rightIndex; rightIndex--) {
                if (array[rightIndex - 1] < array[rightIndex]) {
                    int temp = array[rightIndex - 1];

                    array[rightIndex - 1] = array[rightIndex];
                    array[rightIndex] = temp;
                }
            }
        }
    }
}
