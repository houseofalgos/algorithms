public class FirstAndNthOrderStatistic {
    // Two Pass
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Total Comparisons: 2n - 2
    int[] naiveSolution(int[] array) {
        int arrayLength = array.length;
        int minimumElement = array[0];
        int maximumElement = array[0];

        for (int index = 1; index < arrayLength; index++) {
            int element = array[index];

            minimumElement = Math.min(minimumElement, element);
        }

        for (int index = 1; index < arrayLength; index++) {
            int element = array[index];

            maximumElement = Math.max(maximumElement, element);
        }

        return new int[] {minimumElement, maximumElement};
    }

    // Single Pass
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Total Comparisons: 2n - 2
    int[] optimizedSolution(int[] array) {
        int arrayLength = array.length;
        int minimumElement = array[0];
        int maximumElement = array[0];

        for (int index = 1; index < arrayLength; index++) {
            int element = array[index];

            minimumElement = Math.min(minimumElement, element);
            maximumElement = Math.max(maximumElement, element);
        }

        return new int[] {minimumElement, maximumElement};
    }

    // Pairwise Comparison
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Total Comparisons: (3n / 2) - 2
    int[] optimalSolution(int[] array) {
        int arrayLength = array.length;
        int index;
        int minimumElement;
        int maximumElement;

        if (arrayLength % 2 == 0) {
            index = 2;
            minimumElement = array[0];
            maximumElement = array[1];

            if (maximumElement < minimumElement) {
                int temp = minimumElement;

                minimumElement = maximumElement;
                maximumElement = temp;
            }
        } else {
            index = 1;
            minimumElement = array[0];
            maximumElement = array[0];
        }

        for (; index < arrayLength - 1; index += 2) {
            int smallerElement = array[index];
            int largerElement = array[index + 1];

            if (largerElement < smallerElement) {
                int temp = smallerElement;

                smallerElement = largerElement;
                largerElement = temp;
            }

            minimumElement = Math.min(minimumElement, smallerElement);
            maximumElement = Math.max(maximumElement, largerElement);
        }

        return new int[] {minimumElement, maximumElement};
    }
}
