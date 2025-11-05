public class SecondOrderStatistic {
    record Pair(int smallerElement, int largerElement) {}
    public static void main(String[] parameters) {
        int[] array = new int[] {9, 8, 6, 9, 3, 7, 6, 5, 4, 7};
        int one = naiveSolution(array);
        int two = optimizedSolution(array);
        int three = optimalSolution(array);

        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
    }

    // Two Pass
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Total Comparisons: (n - 1) + (2n - 2 + 1) = 3n - 2
    static int naiveSolution(int[] array) {
        int arrayLength = array.length;
        int minimumElement = array[0];
        int minimumElementCount = 0;
        int secondMinimumElement = Integer.MAX_VALUE;

        for (int index = 1; index < arrayLength; index++) {
            int element = array[index];

            minimumElement = Math.min(minimumElement, element);
        }

        for (int element : array) {
            if (element == minimumElement) {
                minimumElementCount++;
            } else if (element < secondMinimumElement) {
                secondMinimumElement = element;
            }
        }

        return 1 < minimumElementCount ?
                minimumElement :
                secondMinimumElement;
    }

    // Single Pass
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Total Comparisons: 2n - 2
    static int optimizedSolution(int[] array) {
        int arrayLength = array.length;
        int minimumElement = array[0];
        int secondMinimumElement = Integer.MAX_VALUE;

        for (int index = 1; index < arrayLength; index++) {
            int element = array[index];

            if (element < minimumElement) {
                secondMinimumElement = minimumElement;
                minimumElement = element;
            } else if (element < secondMinimumElement) {
                secondMinimumElement = element;
            }
        }

        return secondMinimumElement;

        // Alternative approach (improvement on naive approach) would be to remove the smallest element and then find
        // the smallest element again leading to (n - 1) + (n - 2) = 2n - 3 total comparisons.
    }

    // Pairwise Comparison
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Total comparisons:
    static int optimalSolution(int[] array) {
        int arrayLength = array.length;
        int totalLeafNodes = calculateTotalLeafNodes(arrayLength);
        int totalNodes = 2 * totalLeafNodes - 1;
        Pair[] comparisonTree = createComparisonTree(arrayLength, array, totalLeafNodes, totalNodes);

        for (int nodeIndex = totalNodes - 1; 0 < nodeIndex; nodeIndex -= 2) {
            Pair childNodeOne = comparisonTree[nodeIndex];
            Pair childNodeTwo = comparisonTree[nodeIndex - 1];
            int smallerElementOne = childNodeOne.smallerElement();
            int largerElementOne = childNodeOne.largerElement();
            int smallerElementTwo = childNodeTwo.smallerElement();
            int largerElementTwo = childNodeTwo.largerElement();
            int smallerElement = Math.min(smallerElementOne, smallerElementTwo);
            int largerElement = Math.min(largerElementOne, largerElementTwo);
            Pair parentNode = new Pair(smallerElement, largerElement);
            int parentNodeIndex = nodeIndex / 2 - 1;

            comparisonTree[parentNodeIndex] = parentNode;
        }


        return comparisonTree[0].largerElement;
    }

    // Total comparisons: n / 2
    static Pair[] createComparisonTree(int arrayLength, int[] array, int totalLeafNodes, int totalNodes) {
        Pair[] comparisonTree = new Pair[totalNodes];

        for (int elementIndex = 0; elementIndex < totalLeafNodes; elementIndex += 2) {
            int smallerElement = elementIndex < arrayLength ? array[elementIndex] : Integer.MAX_VALUE;
            int largerElement = elementIndex < arrayLength - 1 ?array[elementIndex + 1] : Integer.MAX_VALUE;
            int nodeIndex = totalNodes - totalLeafNodes - 1 + elementIndex;

            if (largerElement < smallerElement) {
                int temp = smallerElement;

                smallerElement = largerElement;
                largerElement = temp;
            }

            comparisonTree[nodeIndex] = new Pair(smallerElement, largerElement);
        }

        return comparisonTree;
    }

    static int calculateTotalLeafNodes(int arrayLength) {
        int totalLeafNodes = 1;

        while (totalLeafNodes < arrayLength) {
            totalLeafNodes <<= 1;
        }

        return totalLeafNodes;
    }
}
