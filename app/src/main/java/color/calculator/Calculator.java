/*
 * This class handles the core functionality of the calculator by enumerating the
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
        acos, asin, atan
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

    /**
	 * This caller handles the calculation wehn = is pressed.
	 * @param num the number passed from the calculator
	 * @return
	 */
	public Double calculateEqual(Double num) {
		if (mode == twoOperator.normal) {
			return num;
		}
		return twoOpCaller(twoOperator.normal, num);
	}

    /**
	 * Clears all numbers and text from the calculator
	 * @return
	 */
	public Double reset() {
		num2 = 0.0;
		num1 = 0.0;
		mode = twoOperator.normal;

		return Double.NaN;
	}

    /**
	 * Caller function that passes the mode for a single operator function, and returns
     * the correct value depending on which math button is pressed.
	 * @param newMode determines the single operation type
	 * @param num the number from the user as input from buttons
	 * @return
	 */
    public Double singleOpCaller(singleOperator newMode, Double num) {
        if (newMode == singleOperator.square) {
            return num * num;
        }
        if (newMode == singleOperator.squareRoot) {
            return Math.sqrt(num);
        }
        if (newMode == singleOperator.oneDividedBy) {
            return 1 / num;
        }
        if (newMode == singleOperator.cos) {
            return Math.cos(num);
        }
        if (newMode == singleOperator.sin) {
            return Math.sin(Math.toRadians(num));
        }
        if (newMode == singleOperator.tan) {
            return Math.tan(num);
        }
        if (newMode == singleOperator.acos) {
            return Math.acos(num);
        }
        if (newMode == singleOperator.asin) {
            return Math.asin(num);
        }
        if (newMode == singleOperator.atan) {
            return Math.atan(num);
        }
        throw new Error();
    }
}
