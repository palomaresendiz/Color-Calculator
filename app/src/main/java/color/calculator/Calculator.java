/*
 * This class completes the big functions of the calculator by enumerating the
 * actions and using a constructor that returns the appropriately enumerated command.
 * Then, it can split into two operator and one operator calculations using the
 * .operand which completes the actual calculation and returns the correct values.
 */

package color.calculator;

public class Calculator {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new Calculator().getGreeting());
    }
}
