
// Exercise on pages 745-748

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JResort extends JFrame implements ItemListener
{
	// Data field variables and constants for this class
	final int BASE_PRICE = 200;
	final int WEEKEND_PREMIUM = 100;
	final int BREAKFAST_PREMIUM = 20;
	final int GOLF_PREMIUM = 75;	
	int totalPrice = BASE_PRICE;

	// Create Three JCheckBox objects
	JCheckBox weekendBox = new JCheckBox("Weekend Premium $" + WEEKEND_PREMIUM, false // not pre-selected
		);
	JCheckBox breakfastBox = new JCheckBox("Breakfast $" + BREAKFAST_PREMIUM, false);
	JCheckBox golfBox = new JCheckBox("Gold Premium $" + GOLF_PREMIUM, false);

	// Create four JLabel objects
	JLabel resortLabel = new JLabel("Resort Price Calculator");
	JLabel optionExplainLabel = new JLabel("The base price for a room is $" + BASE_PRICE + ".");
	JLabel optionExplainLabel2 = new JLabel("Check the options you want to add.");
	JLabel priceLabel = new JLabel("The price for your stay is ");

	// Create one JTextField object
	JTextField priceField = new JTextField(4);

	// Constructor method for this class
	public JResort()
	{
		super("Resort Price Estimator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		add(resortLabel);
		add(optionExplainLabel);
		add(optionExplainLabel2); 
		add(weekendBox);
		add(breakfastBox);
		add(golfBox);
		add(priceLabel);
		add(priceField);

		// Set the priceField value when the GUI loads
		priceField.setText("$" + totalPrice);

		//Add the event listeners for the JCheckBox objects
		weekendBox.addItemListener(this);
		breakfastBox.addItemListener(this);
		golfBox.addItemListener(this);
	}

	//Event handling method for this GUI
	@Override
	public void itemStateChanged(ItemEvent e)
	{
		Object source = e.getSource();
		int select = e.getStateChange();


		// Decide which component triggered this event
		// Adjust the totalPrice accordingly
		if(source == weekendBox) 
		{
			// If the box is checked, add the premium.
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += WEEKEND_PREMIUM;
			}
			else
			{
				totalPrice -= WEEKEND_PREMIUM;
			}
		}
		else if (source == breakfastBox)
		{
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += BREAKFAST_PREMIUM;
			}
			else
			{
				totalPrice -= BREAKFAST_PREMIUM;
			}
		}
		else // When the source == golfBox which is the last source left
		{
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += GOLF_PREMIUM;
			}
			else
			{
				totalPrice -= GOLF_PREMIUM;
			}
		}
	
		priceField.setText("$"+ totalPrice);	
	}

	public static void main(String[] args) 
	{
		// Create an object from the JResort class
		JResort aFrame = new JResort();
		aFrame.setSize(300, 200);
		aFrame.setVisible(true);

	}
}