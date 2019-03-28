package edu.ro.utcn.calc.pt.polynomial.calc.services;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Gui extends JFrame{
	
	private JPanel panel;
	
	private JLabel firstInputLabel;
	private JLabel secondInputLabel;
	private JLabel firstOutputLabel;
	private JLabel secondOutputLabel;
	private JLabel opLabel;
	
	private JTextField firstInputField;
	private JTextField secondInputField;
	private JTextField firstOutputField;
	private JTextField secondOutputField;
	
	private JButton addButton;
	private JButton subButton;
	private JButton intButton;
	private JButton derivButton;
	private JButton mulButton;
	private JButton divButton;
	private JButton resetButton;
	
	public static void main(String[] args) {
		Gui frame = new Gui();
		frame.setVisible(true);
	}
	
	public JButton getJButton(String s) {
		switch(s) {
		case "add" : return addButton;
		case "sub" : return subButton;
		case "mul" : return mulButton;
		case "div" : return divButton;
		case "int" : return intButton;
		case "deriv" : return derivButton;
		
		default : return resetButton;
		}
	}
	
	public JTextField getField(int i) {
		switch(i) {
		case 1: return firstInputField;
		case 2: return secondInputField;
		case 3: return firstOutputField;
		default: return secondOutputField;
		}
	}
	
	public void setTextField(JTextField tf, String s) {
		tf.setText(s);
	}
	public void resetTextFields() {
		firstInputField.setText(null);
		secondInputField.setText(null);
		firstOutputField.setText(null);
		secondInputField.setText(null);
	}
	public Gui() {
		setTitle("Polynomial Calculator");
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		setContentPane(panel);
		panel.setLayout(null);
		
		firstInputLabel = new JLabel("First input polynomial:");
		firstInputLabel.setFont(new Font("Montserrat Light", Font.BOLD, 12));
		firstInputLabel.setBounds(30, 20, 160, 20);
		panel.add(firstInputLabel);
		
		secondInputLabel = new JLabel("Second input polynomial:");
		secondInputLabel.setFont(new Font("Montserrat Light", Font.BOLD, 12));
		secondInputLabel.setBounds(30, 90, 180, 20);
		panel.add(secondInputLabel);
		
		firstInputField = new JTextField();
		firstInputField.setFont(new Font("Lato Light", Font.PLAIN, 15));
		firstInputField.setBounds(30, 50, 380, 30);
		panel.add(firstInputField);
		
		secondInputField = new JTextField();
		secondInputField.setFont(new Font("Lato Light", Font.PLAIN, 15));
		secondInputField.setBounds(30, 120, 380, 30);
		panel.add(secondInputField);
		
		firstOutputLabel = new JLabel("Output polynomial (for division - the quotient):");
		firstOutputLabel.setFont(new Font("Montserrat Light", Font.BOLD, 12));
		firstOutputLabel.setBounds(30, 210, 330, 20);
		panel.add(firstOutputLabel);
		
		firstOutputField = new JTextField();
		firstOutputField.setEditable(false);
		firstOutputField.setFont(new Font("Lato Light", Font.PLAIN, 15));
		firstOutputField.setBounds(30, 240, 380, 30);
		panel.add(firstOutputField);
		
		secondOutputLabel = new JLabel("Output polynomial (for division ONLY - the remainder):");
		secondOutputLabel.setFont(new Font("Montserrat Light", Font.BOLD, 12));
		secondOutputLabel.setBounds(30, 280, 380, 20);
		panel.add(secondOutputLabel);
		
		secondOutputField = new JTextField();
		secondOutputField.setFont(new Font("Lato Light", Font.PLAIN, 15));
		secondOutputField.setEditable(false);
		secondOutputField.setBounds(30, 310, 380, 30);
		panel.add(secondOutputField);
		
		opLabel = new JLabel("Operations:");
		opLabel.setFont(new Font("Montserrat Light", Font.BOLD, 12));
		opLabel.setBounds(462, 20, 80, 20);
		panel.add(opLabel);
		
		addButton = new JButton("Add");
		addButton.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		addButton.setForeground(new Color(255, 255, 255));
		addButton.setBackground(new Color(34, 139, 34));
		addButton.setBounds(445, 50, 120, 30);
		panel.add(addButton);
		
		subButton = new JButton("Subtract");
		subButton.setForeground(Color.WHITE);
		subButton.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		subButton.setBackground(new Color(255, 0, 0));
		subButton.setBounds(445, 100, 120, 30);
		panel.add(subButton);
		
		mulButton = new JButton("Multiply");
		mulButton.setForeground(Color.WHITE);
		mulButton.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		mulButton.setBackground(new Color(255, 153, 51));
		mulButton.setBounds(445, 260, 120, 30);
		panel.add(mulButton);
		
		divButton = new JButton("Divide");
		divButton.setForeground(Color.WHITE);
		divButton.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		divButton.setBackground(new Color(102, 0, 153));
		divButton.setBounds(445, 310, 120, 30);
		panel.add(divButton);
		
		intButton = new JButton("Integrate");
		intButton.setForeground(Color.WHITE);
		intButton.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		intButton.setBackground(new Color(255, 204, 0));
		intButton.setBounds(445, 150, 120, 30);
		panel.add(intButton);
		
		derivButton = new JButton("Derivate");
		derivButton.setForeground(Color.WHITE);
		derivButton.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		derivButton.setBackground(new Color(0, 204, 255));
		derivButton.setBounds(445, 205, 120, 30);
		panel.add(derivButton);
		
		resetButton = new JButton("Reset");
		resetButton.setForeground(new Color(0, 0, 0));
		resetButton.setFont(new Font("Montserrat Medium", Font.PLAIN, 14));
		resetButton.setBackground(new Color(255, 255, 204));
		resetButton.setBounds(30, 169, 120, 30);
		panel.add(resetButton);
	}

}
