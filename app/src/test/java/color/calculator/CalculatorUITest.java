package color.calculator;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorUITest {

    private static CalculatorUI classUnderTest;
    private static JTextField text;

    @BeforeAll
    public static void setUp() {
        classUnderTest = new CalculatorUI();
        text = new JTextField();
    }
    private void simulateButtonPress(JButton button) {
        ActionEvent e = new ActionEvent(button, ActionEvent.ACTION_PERFORMED, "");
        classUnderTest.actionPerformed(e);
    }
    
    @Test 
    void appPanelIsCreated() {
        assertNotNull(classUnderTest, "app should have a panel object");
    }

    @DisplayName("Testing that reader reads string and retuns double")
    @Test
    void testReader() {
        classUnderTest.text.setText("10.0");
        double result = classUnderTest.reader();
        assertEquals(10.0, result);
    }

    @DisplayName("Testing the writer with NaN ")
    @Test
    void testWriter() {
        classUnderTest.writer(Double.NaN);
        text = new JTextField();
        assertEquals("", text.getText());
    }

    @DisplayName("Testing Button[5] writes '5' to display")
    @Test
    void testNumberButton() {
        simulateButtonPress(classUnderTest.jButtons[5]);
        assertEquals("5", classUnderTest.text.getText());
    }

    @DisplayName("Testing addition operation")
    @Test
    void testAddButton() {
        classUnderTest.text.setText("5");
        simulateButtonPress(classUnderTest.add);
        simulateButtonPress(classUnderTest.jButtons[3]);
        simulateButtonPress(classUnderTest.equal);
        assertEquals("8.0", classUnderTest.text.getText());
    }

    @DisplayName("Testing subtraction operation")
    @Test
    void testSubtractButton() {
        classUnderTest.text.setText("9");
        simulateButtonPress(classUnderTest.sub);
        simulateButtonPress(classUnderTest.jButtons[4]);
        simulateButtonPress(classUnderTest.equal);
        assertEquals("5.0", classUnderTest.text.getText());
    }

    @DisplayName("Testing multiplication operation")
    @Test
    void testMultiplyButton() {
        classUnderTest.text.setText("4");
        simulateButtonPress(classUnderTest.mult);
        simulateButtonPress(classUnderTest.jButtons[2]);
        simulateButtonPress(classUnderTest.equal);
        assertEquals("8.0", classUnderTest.text.getText());
    }

    @DisplayName("Testing division operation")
    @Test
    void testDivideButton() {
        classUnderTest.text.setText("8");
        simulateButtonPress(classUnderTest.div);
        simulateButtonPress(classUnderTest.jButtons[2]);
        simulateButtonPress(classUnderTest.equal);
        assertEquals("4.0", classUnderTest.text.getText());
    }

    @DisplayName("Testing equal button functionality")
    @Test
    void testEqualButton() {
        classUnderTest.text.setText("7");
        simulateButtonPress(classUnderTest.equal);
        assertEquals("7.0", classUnderTest.text.getText());
    }

    @DisplayName("Testing square root operation")
    @Test
    void testSquareRootButton() {
        classUnderTest.text.setText("16");
        simulateButtonPress(classUnderTest.sqrRt);
        assertEquals("4.0", classUnderTest.text.getText());
    }

    @DisplayName("Testing sine operation")
    @Test
    void testSinButton() {
        classUnderTest.text.setText("30"); // Assuming the angle is in degrees
        simulateButtonPress(classUnderTest.sin);
        double expectedResult = Math.sin(Math.toRadians(30.0)); // Convert to radians as Java's Math.sin() assumes radians
        double actualResult = Double.parseDouble(classUnderTest.text.getText());
        assertEquals(expectedResult, actualResult, 0.0001, "The sin operation should calculate the sine of the input value.");
    }

    @DisplayName("Testing that writer writes the display: assumes public fields")
    @Test
    public void writerSetText() {
        JTextArea textAreaUnderTest = classUnderTest.text;
        Double numberToWrite = 22.2;
        classUnderTest.writer(numberToWrite);
        // Test that the value of “text” is “mytext”
        assertEquals(numberToWrite.toString(), textAreaUnderTest.getText());
    }

    @DisplayName("Testing Button[0] writes zero to display: assumes public fields ")
    @Test
    public void writeZeroToDisplay() {
       
        ActionEvent e = new ActionEvent(classUnderTest.jButtons[0], 
                                        ActionEvent.ACTION_PERFORMED, 
                                        "");
        classUnderTest.actionPerformed(e);
        String expectedDisplayText = classUnderTest.buttonValue[0];
        String actualDisplayText = classUnderTest.text.getText();
        assertEquals(expectedDisplayText,actualDisplayText);
    }

}

