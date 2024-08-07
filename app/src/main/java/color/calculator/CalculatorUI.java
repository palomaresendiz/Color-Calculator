/**
 * CalculatorUI class that creates and adds buttons, event handling for the buttons,
 * and calls calculator methods and functions for logic when necessary.
 */

package color.calculator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.Random;

import static javax.swing.WindowConstants.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

abstract class OperatorButton extends JButton {
    public OperatorButton(String label) {
        super(label);
    }

    public abstract void attachActionListener(ActionListener listener);
}

class PrimitiveOperatorButton extends OperatorButton {
    public PrimitiveOperatorButton(String label) {
        super(label);
    }

    @Override
    public void attachActionListener(ActionListener listener) {
        this.addActionListener(listener);
    }
}

class TrigonometricOperatorButton extends OperatorButton {
    public TrigonometricOperatorButton(String label) {
        super(label); 
    }
	@Override
    public void attachActionListener(ActionListener listener) {
        this.addActionListener(listener);
    }
}

class CommonFunctionOperatorButton extends OperatorButton {
    
    public CommonFunctionOperatorButton(String label) {
        super(label); 
    }

	@Override
    public void attachActionListener(ActionListener listener) {
        this.addActionListener(listener);
    }
}
class OperatorButtonFactory {
    public static OperatorButton createButton(String type, String label) {
        switch (type) {
            case "primitive":
                return new PrimitiveOperatorButton(label);
            case "trigonometric":
                return new TrigonometricOperatorButton(label);
            case "commonFunction":
                return new CommonFunctionOperatorButton(label);
            default:
                throw new IllegalArgumentException("Invalid button type");
        }
    }
}

class ButtonPanel extends JPanel {
    public void addButton(OperatorButton button, ActionListener listener) {
        this.add(button);
        button.attachActionListener(listener);
    }
}

public class CalculatorUI implements ActionListener {
	public final JButton acos, asin, atan; 

	public final JFrame frame;
	public  final JPanel panel;
	public  final JTextArea text;
	public final JButton jButtons[], add, sub, mult, div, equal, cancel, sqrRt, sqr, inverse, cos, sin, tan, color;
	public  final String[] buttonValue = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

	public  final Calculator calc;


	/**
	 * The top level GUI of the calculator and it's frame, button, and text area for # display
	 */
	public CalculatorUI() {
		acos = new JButton("Cos⁻¹");
        asin = new JButton("Sin⁻¹");
        atan = new JButton("Tan⁻¹");
		frame = new JFrame("Color Calculator");
		frame.setResizable(false);
		panel = new JPanel(new FlowLayout());
		text = new JTextArea(2, 25);
		calc = new Calculator();
		

		jButtons = new JButton[10];

		for (int i = 0; i < 10; i++) {
			jButtons[i] = new JButton(String.valueOf(i));
		}

		add = new JButton("+");
		sub = new JButton("-");
		mult = new JButton("*");
		div = new JButton("/");
		equal = new JButton("=");
		sqrRt = new JButton("√");
		sqr = new JButton("x*x");
		inverse = new JButton("1/x");
		cos = new JButton("Cos");
		sin = new JButton("Sin");
		tan = new JButton("Tan");
		cancel = new JButton("Clear");
        color = new JButton("Color!");
		
	}


	/**
     * The main runner method of the UI class.
	 * Initializes UI and sets the frame size, buttons, panels.
	 */
	public void init() {
		frame.setSize(300, 380);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(text);
		AddButtonsToPanel();
		AddActionListeners();
		frame.setVisible(true);
		
	}
	private void AddButtonsToPanel() {
		for (int i = 0; i < 10; i++) {
            panel.add(jButtons[i]);
        }
		
		panel.add(add);
		panel.add(sub);
		panel.add(mult);
		panel.add(div);
		panel.add(sqr);
		panel.add(sqrRt);
		panel.add(inverse);
		panel.add(cos);
		panel.add(sin);
		panel.add(tan);
		panel.add(acos);
		panel.add(asin);
		panel.add(atan);
		panel.add(equal);
		panel.add(cancel);
        panel.add(color);
	}
	private void AddActionListeners() {
		// add event listeners
		for (int i = 0; i < 10; i++) {
            jButtons[i].addActionListener(this);
        }
		acos.addActionListener(this);
    	asin.addActionListener(this);
    	atan.addActionListener(this);
		add.addActionListener(this);
		sub.addActionListener(this);
		mult.addActionListener(this);
		div.addActionListener(this);
		sqr.addActionListener(this);
		sqrRt.addActionListener(this);
		inverse.addActionListener(this);
		cos.addActionListener(this);
		sin.addActionListener(this);
		tan.addActionListener(this);
		equal.addActionListener(this);
		cancel.addActionListener(this);
        color.addActionListener(this);

		frame.setVisible(true);
	}

	/**
	 * Event handling implementation for button pressing
	 * @param e for event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		final Object source = e.getSource();
		// check 0-9 and update textfield
		for (int i = 0; i < 10; i++) {
			if (source == jButtons[i]) {
				text.replaceSelection(buttonValue[i]);
				return;
			}
		}

		if (source == acos) {
			writer(calc.singleOpCaller(Calculator.singleOperator.acos, reader()));
		} else if (source == asin) {
			writer(calc.singleOpCaller(Calculator.singleOperator.asin, reader()));
		} else if (source == atan) {
			writer(calc.singleOpCaller(Calculator.singleOperator.atan, reader()));
		} else if (source == add) {
			writer(calc.twoOpCaller(Calculator.twoOperator.add, reader()));
		} else if (source == sub) {
			writer(calc.twoOpCaller(Calculator.twoOperator.subtract, reader()));
		} else if (source == mult) {
			writer(calc.twoOpCaller(Calculator.twoOperator.multiply,
					reader()));
		} else if (source == div) {
			writer(calc.twoOpCaller(Calculator.twoOperator.divide, reader()));
		} else if (source == sqr) {
			writer(calc.singleOpCaller(Calculator.singleOperator.square,
					reader()));
		} else if (source == sqrRt) {
			writer(calc.singleOpCaller(Calculator.singleOperator.squareRoot,
					reader()));
		} else if (source == inverse) {
			writer(calc.singleOpCaller(
					Calculator.singleOperator.oneDividedBy, reader()));
		} else if (source == cos) {
			writer(calc.singleOpCaller(Calculator.singleOperator.cos,
					reader()));
		} else if (source == sin) {
			writer(calc.singleOpCaller(Calculator.singleOperator.sin,
					reader()));
		} else if (source == tan) {
			writer(calc.singleOpCaller(Calculator.singleOperator.tan,
					reader()));
		} else if (source == equal) {
			Double result = calc.calculateEqual(reader());
       		writer(result);
		} else if (source == cancel) {
			writer(calc.reset());
		}
        else if (source == color) {
            changeButtonColor();
        }
		text.selectAll();
	}

	/**
	 * Helper function that gets the texfield area and updates the number input
	 * @return the updated number
	 */
	public Double reader() {
		Double num;
		String str;
		str = text.getText();
		num = Double.valueOf(str);

		return num;
	}

	/**
	 * Helper function that sets the textfield with the number, and avoids NaN issues
	 * @param num
	 */
	public void writer(final Double num) {
		if (Double.isNaN(num)) {
			text.setText("");
		} else {
			text.setText(Double.toString(num));
		}
	}

    /**
     * Change the color of all the buttons to a random color
     */
    public void changeButtonColor() {
        Color randomColor = generateRandomColor();
        for (int i = 0; i < 10; i++) {
            jButtons[i].setBackground(randomColor);
            jButtons[i].setOpaque(true);
            jButtons[i].setBorderPainted(false);
        }
        add.setBackground(randomColor);
        add.setOpaque(true);
        add.setBorderPainted(false);

        sub.setBackground(randomColor);
        sub.setOpaque(true);
        sub.setBorderPainted(false);

        mult.setBackground(randomColor);
        mult.setOpaque(true);
        mult.setBorderPainted(false);

        div.setBackground(randomColor);
        div.setOpaque(true);
        div.setBorderPainted(false);

        sqr.setBackground(randomColor);
        sqr.setOpaque(true);
        sqr.setBorderPainted(false);

        sqrRt.setBackground(randomColor);
        sqrRt.setOpaque(true);
        sqrRt.setBorderPainted(false);

        inverse.setBackground(randomColor);
        inverse.setOpaque(true);
        inverse.setBorderPainted(false);

        cos.setBackground(randomColor);
        cos.setOpaque(true);
        cos.setBorderPainted(false);


        sin.setBackground(randomColor);
        sin.setOpaque(true);
        sin.setBorderPainted(false);

        tan.setBackground(randomColor);
        tan.setOpaque(true);
        tan.setBorderPainted(false);

        acos.setBackground(randomColor);
        acos.setOpaque(true);
        acos.setBorderPainted(false);

        asin.setBackground(randomColor);
        asin.setOpaque(true);
        asin.setBorderPainted(false);

        atan.setBackground(randomColor);
        atan.setOpaque(true);
        atan.setBorderPainted(false);

        equal.setBackground(randomColor);
        equal.setOpaque(true);
        equal.setBorderPainted(false);

        cancel.setBackground(randomColor);
        cancel.setOpaque(true);
        cancel.setBorderPainted(false);

        color.setBackground(randomColor);
        color.setOpaque(true);
        color.setBorderPainted(false);

        panel.revalidate();
        panel.repaint();
    }

    /**
     * Helper function to generate a random color 
     * @return a random color object
     */
    public Color generateRandomColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r, g, b);
    } 
}