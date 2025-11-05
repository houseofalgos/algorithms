public class HornersRule {
    // Naive Solution
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    int naiveSolution(int[] coefficients, int variable) {
        int totalCoefiicients = coefficients.length;
        int result = 0;

        for (int exponent = 0; exponent < totalCoefiicients; exponent++) {
            int power = 1;
            int coefficient = coefficients[exponent];

            while (0 < exponent--) {
                power *= variable;
            }

            result += coefficient * power;
        }

        return result;
    }

    // Optimized Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    int hornersRule(int[] coefficients, int variable) {
        int totalCoefficients = coefficients.length;
        int result = 0;

        for (int index = totalCoefficients - 1; 0 <= index; index--) {
            int coefficient = coefficients[index];

            result += coefficient + result * variable;
        }

        return result;
    }

    // Optimal Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    int optimalSolution(int[] coefficients, int variable) {
        int result = 0;
        int power = 1;

        for (int coefficient : coefficients) {
            result += coefficient * power;
            power *= variable;
        }

        return result;
    }
}
