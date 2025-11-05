public class SelectionSort {
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    void sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null.");
        }

        int arrayLength = array.length;

        for (int leftIndex = 0; leftIndex < arrayLength - 1; leftIndex++) {
            int smallestElement = array[leftIndex];
            int smallestElementIndex = leftIndex;

            for (int rightIndex = leftIndex + 1; rightIndex < arrayLength; rightIndex++) {
                int currentElement = array[rightIndex];

                if (currentElement < smallestElement) {
                    smallestElement = currentElement;
                    smallestElementIndex = rightIndex;
                }
            }

            if (smallestElementIndex != leftIndex) {
                array[smallestElementIndex] = array[leftIndex];
                array[leftIndex] = smallestElement;
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
            int largestElement = array[leftIndex];
            int largestElementIndex = leftIndex;

            for (int rightIndex = leftIndex + 1; rightIndex < arrayLength; rightIndex++) {
                int currentElement = array[rightIndex];

                if (largestElement < currentElement) {
                    largestElement = currentElement;
                    largestElementIndex = rightIndex;
                }
            }

            if (largestElementIndex != leftIndex) {
                array[largestElementIndex] = array[leftIndex];
                array[leftIndex] = largestElement;
            }
        }
    }
}
