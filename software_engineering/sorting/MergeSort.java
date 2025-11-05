public class MergeSort {
    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(n)
    void recursiveSort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null.");
        }

        int arrayLength = array.length;
        int[] auxiliaryArray = new int[arrayLength];

        recursiveSort(array, auxiliaryArray, 0, arrayLength - 1);
    }

    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(lg(n))
    void recursiveSort(int[] array, int[] auxiliaryArray, int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }

        int middleIndex = startIndex + (endIndex - startIndex) / 2;

        recursiveSort(array, auxiliaryArray, startIndex, middleIndex);
        recursiveSort(array, auxiliaryArray, middleIndex + 1, endIndex);

        if (array[middleIndex] <= array[middleIndex + 1]) {
            return;
        }

        merge(array, auxiliaryArray, startIndex, middleIndex, endIndex);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void merge(int[] array, int[] auxiliaryArray, int startIndex, int middleIndex, int endIndex) {
        int leftIndex = startIndex;
        int rightIndex = middleIndex + 1;

        for (int index = startIndex; index <= endIndex; index++) {
            int leftElement = leftIndex <= middleIndex ? array[leftIndex] : Integer.MAX_VALUE;
            int rightElement = rightIndex <= endIndex ? array[rightIndex] : Integer.MAX_VALUE;

            if (leftElement <= rightElement) {
                auxiliaryArray[index] = leftElement;
                leftIndex++;
            } else {
                auxiliaryArray[index] = rightElement;
                rightIndex++;
            }
        }

        for (int index = startIndex; index <= endIndex; index++) {
            array[index] = auxiliaryArray[index];
        }
    }

    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(n)
    static void reverseRecursiveSort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null.");
        }

        int arrayLength = array.length;
        int[] auxiliaryArray = new int[arrayLength];

        reverseRecursiveSort(array, auxiliaryArray, 0, arrayLength - 1);
    }

    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(lg(n))
    static void reverseRecursiveSort(int[] array, int[] auxiliaryArray, int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }

        int middleIndex = startIndex + (endIndex - startIndex) / 2;

        reverseRecursiveSort(array, auxiliaryArray, startIndex, middleIndex);
        reverseRecursiveSort(array, auxiliaryArray, middleIndex + 1, endIndex);

        if (array[middleIndex + 1] <= array[middleIndex]) {
            return;
        }

        reverseMerge(array, auxiliaryArray, startIndex, middleIndex, endIndex);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    static void reverseMerge(int[] array, int[] auxiliaryArray, int startIndex, int middleIndex, int endIndex) {
        int leftIndex = startIndex;
        int rightIndex = middleIndex + 1;

        for (int index = startIndex; index <= endIndex; index++) {
            int leftElement = leftIndex <= middleIndex ? array[leftIndex] : Integer.MIN_VALUE;
            int rightElement = rightIndex <= endIndex ? array[rightIndex] : Integer.MIN_VALUE;

            if (rightElement <= leftElement) {
                auxiliaryArray[index] = leftElement;
                leftIndex++;
            } else {
                auxiliaryArray[index] = rightElement;
                rightIndex++;
            }
        }

        for (int index = startIndex; index <= endIndex; index++) {
            array[index] = auxiliaryArray[index];
        }
    }

    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(n)
    void sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null.");
        }

        int arrayLength = array.length;
        int[] auxiliaryArray = new int[arrayLength];

        for (int halfSubArrayLength = 1; halfSubArrayLength < arrayLength; halfSubArrayLength *= 2) {
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

    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(n)
    void reverseSort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null.");
        }

        int arrayLength = array.length;
        int[] auxiliaryArray = new int[arrayLength];

        for (int halfSubArrayLength = 1; halfSubArrayLength < arrayLength; halfSubArrayLength *= 2) {
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
}
