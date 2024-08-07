/*
 * This class completes the main functions of the calculator by enumerating the
 * actions and using a constructor that returns the appropriately enumerated command.
 * Then, it can split into two operator or single operator calculations using the
 * .operand which completes the actual calculation and returns the correct values.
 */

package color.calculator;

public class Calculator {

    public enum twoOperator {
        normal, add, subtract, multiply, divide
    }

    public enum singleOperator {
        square, squareRoot, oneDividedBy, cos, sin, tan,
        acos, aisn, atan
    }

    public Double num1, num2;
    public twoOperator mode = twoOperator.normal;

    /**
     * The enumeration that returns the specified operation result
     */
    public Double twoOpOperations() {
        if (mode == twoOperator.normal) {
            return num2;
        }
        if (mode == twoOperator.add) {
            return num1 + num2;
        }
        if (mode == twoOperator.subtract) {
            return num1 - num2;
        }
        if (mode == twoOperator.multiply) {
            return num1 * num2;
        }
        if (mode == twoOperator.divide) {
            return num1 / num2;
        }
        throw new Error();
    }
}
