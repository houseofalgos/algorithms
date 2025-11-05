public class Inversions {
    // Naive Solution
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    int naiveSolution(int[] array) {
        int arrayLength = array.length;
        int totalInversions = 0;

        for (int leftIndex = 0; leftIndex < arrayLength - 1; leftIndex++) {
            int leftElement = array[leftIndex];

            for (int rightIndex = leftIndex + 1; rightIndex < arrayLength; rightIndex++) {
                int rightElement = array[rightIndex];

                if (rightElement < leftElement) {
                    totalInversions++;
                }
            }
        }

        return totalInversions;
    }

    // Optimized Solution
    // Time Complexity: O(-)
    // Space Complexity: O(-)
    void optimizedSolution(int[] array) {
        // -
    }

    // Optimal Solution
    // Time Complexity: O(n * lg(n))
    // Space Complexity: O(n)
    int mergeSort(int[] array) {
        int arrayLength = array.length;
        int[] auxiliaryArray = new int[arrayLength];
        int totalInversions = 0;

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
                        totalInversions += leftIndexLimit - leftIndex;
                        auxiliaryArray[auxiliaryArrayIndex++] = rightElement;
                        rightIndex++;
                    }
                }

                for (int index = startIndex; index < auxiliaryArrayIndexLimit; index++) {
                    array[index] = auxiliaryArray[index];
                }
            }
        }

        return totalInversions;
    }
}
