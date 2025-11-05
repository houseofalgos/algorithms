public class HybridMergeSort {
    // Time Complexity: O(nm + n * lg(n / m))
    // Space Complexity: O(n)
    void sort(int[] array, int insertionSortThreshold) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null.");
        }

        if (insertionSortThreshold <= 0) {
            throw new IllegalArgumentException("Lower bound must be greater than 0.");
        }

        int arrayLength = array.length;

        for (int startIndex = 0; startIndex < arrayLength; startIndex += insertionSortThreshold) {
            int endIndex = Math.min(
                    arrayLength - 1,
                    startIndex + insertionSortThreshold - 1
            );

            sort(array, startIndex, endIndex);
        }

        int[] auxiliaryArray = new int[arrayLength];

        for (int halfSubArrayLength = insertionSortThreshold; halfSubArrayLength < arrayLength; halfSubArrayLength *= 2) {
            int subArrayLength = 2 * halfSubArrayLength;

            for (int startIndex = 0; startIndex < arrayLength; startIndex += subArrayLength) {
                int auxiliaryArrayIndex = startIndex;
                int auxiliaryArrayIndexLimit = Math.min(arrayLength, startIndex + subArrayLength);
                int leftIndex = startIndex;
                int leftIndexLimit = startIndex + halfSubArrayLength;
                int rightIndex = leftIndexLimit;

                while (auxiliaryArrayIndex < auxiliaryArrayIndexLimit) {
                    int leftElement = leftIndex < leftIndexLimit ? array[leftIndex] : Integer.MAX_VALUE;
                    int rightElement = rightIndex < auxiliaryArrayIndexLimit ? array[rightIndex] : Integer.MAX_VALUE;

                    if (leftElement <= rightElement) {
                        auxiliaryArray[auxiliaryArrayIndex++] = leftElement;
                        leftIndex++;
                    } else {
                        auxiliaryArray[auxiliaryArrayIndex++] = rightElement;
                        rightIndex++;
                    }
                }

                for (int index = startIndex; index < auxiliaryArrayIndexLimit; index++) {
                    array[index] = auxiliaryArray[index];
                }
            }
        }
    }

    // Time Complexity: O(m^2)
    // Space Complexity: O(1)
    void sort(int[] array, int startIndex, int endIndex) {
        for (int iteration = startIndex; iteration <= endIndex; iteration++) {
            int index = iteration - 1;
            int currentElement = array[iteration];

            while (startIndex <= index && currentElement < array[index]) {
                array[index + 1] = array[index--];
            }

            array[index + 1] = currentElement;
        }
    }

    // Time Complexity: O(nm + n * lg(n / m))
    // Space Complexity: O(n)
    void reverseSort(int[] array, int insertionSortThreshold) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null.");
        }

        if (insertionSortThreshold <= 0) {
            throw new IllegalArgumentException("Lower bound must be greater than 0.");
        }

        int arrayLength = array.length;

        for (int startIndex = 0; startIndex < arrayLength; startIndex += insertionSortThreshold) {
            int endIndex = Math.min(
                    arrayLength - 1,
                    startIndex + insertionSortThreshold - 1
            );

            reverseSort(array, startIndex, endIndex);
        }

        int[] auxiliaryArray = new int[arrayLength];

        for (int halfSubArrayLength = insertionSortThreshold; halfSubArrayLength < arrayLength; halfSubArrayLength *= 2) {
            int subArrayLength = 2 * halfSubArrayLength;

            for (int startIndex = 0; startIndex < arrayLength; startIndex += subArrayLength) {
                int auxiliaryArrayIndex = startIndex;
                int auxiliaryArrayIndexLimit = Math.min(arrayLength, startIndex + subArrayLength);
                int leftIndex = startIndex;
                int leftIndexLimit = startIndex + halfSubArrayLength;
                int rightIndex = leftIndexLimit;

                while (auxiliaryArrayIndex < auxiliaryArrayIndexLimit) {
                    int leftElement = leftIndex < leftIndexLimit ? array[leftIndex] : Integer.MIN_VALUE;
                    int rightElement = rightIndex < auxiliaryArrayIndexLimit ? array[rightIndex] : Integer.MIN_VALUE;

                    if (rightElement <= leftElement) {
                        auxiliaryArray[auxiliaryArrayIndex++] = leftElement;
                        leftIndex++;
                    } else {
                        auxiliaryArray[auxiliaryArrayIndex++] = rightElement;
                        rightIndex++;
                    }
                }

                for (int index = startIndex; index < auxiliaryArrayIndexLimit; index++) {
                    array[index] = auxiliaryArray[index];
                }
            }
        }
    }

    // Time Complexity: O(m^2)
    // Space Complexity: O(1)
    void reverseSort(int[] array, int startIndex, int endIndex) {
        for (int iteration = startIndex; iteration <= endIndex; iteration++) {
            int index = iteration - 1;
            int currentElement = array[iteration];

            while (startIndex <= index && array[index] < currentElement) {
                array[index + 1] = array[index--];
            }

            array[index + 1] = currentElement;
        }
    }
}
