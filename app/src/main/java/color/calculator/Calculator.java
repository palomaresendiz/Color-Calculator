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
     * twoOpOperations handles the enumeration that returns the specified operation result.
     * @return returns the called operand's result
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
        
    /**
     * twoOpCaller handles the = operand. It calls primitives if not = operand)
     * Updates the num1 and num2 values and returns the result of the operation.
     * If normal, it displays the num and clears the mode
     * @param newMode the method of operation being passed
     * @param num the number being passed for calculation
     * @return 
     */
    public Double twoOpCaller(twoOperator newMode, Double num) {
        if (mode != twoOperator.normal) {
            num2 = num;
            num1 = twoOpOperations();
            mode = newMode;
            return num1;
        } else {
            num1 = num;
            mode = newMode;
            return Double.NaN;
        }
    }
}
