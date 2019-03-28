package edu.ro.utcn.calc.pt.polynomial.calc.services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ro.utcn.calc.pt.polynomial.calc.model.Polinom;

public class Control {

	private Gui gui;
	private Operations ops;

	public void run() {
		gui.getJButton("reset").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gui.resetTextFields();
			}
		});

		gui.getJButton("add").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// ADDITION
				String s1 = gui.getField(1).getText();
				//System.out.println(s1);
				String s2 = gui.getField(2).getText();
				Polinom p1 = new Polinom(s1);
				Polinom p2 = new Polinom(s2);
				Polinom sum = ops.addPoli(p1, p2);
				String rez = sum.poliToText();
				gui.setTextField(gui.getField(3), rez);
				}
		});
		gui.getJButton("sub").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// SUBTRACTION
				String s1 = gui.getField(1).getText();
				String s2 = gui.getField(2).getText();
				Polinom p1 = new Polinom(s1);
				Polinom p2 = new Polinom(s2);
				Polinom dif = ops.subPoli(p1, p2);
				String rez = dif.poliToText();
				gui.setTextField(gui.getField(3), rez);
			}
		});
		gui.getJButton("mul").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// MULTIPLICATION
				String s1 = gui.getField(1).getText();
				String s2 = gui.getField(2).getText();
				Polinom p1 = new Polinom(s1);
				Polinom p2 = new Polinom(s2);
				Polinom prod = ops.mulPoli(p1, p2);
				String rez = prod.poliToText();
				gui.setTextField(gui.getField(3), rez);
			}
		});
		gui.getJButton("div").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// DIVISION
				String s1 = gui.getField(1).getText();
				String s2 = gui.getField(2).getText();
				Polinom p1 = new Polinom(s1);
				Polinom p2 = new Polinom(s2);
				if(ops.isZeroPoli(p2)) {
					gui.setTextField(gui.getField(3), "The second polynom is zero!");
					gui.setTextField(gui.getField(4), "Can't execute division! Division by zero!");
				}else {
					ops.divPoli(p1, p2);
					String q = p1.poliToText();
					String r = p2.poliToText();
					gui.setTextField(gui.getField(3), q);
					gui.setTextField(gui.getField(4), r);
				}
			}
		});
		gui.getJButton("int").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// INTEGRATION
				String s1 = gui.getField(1).getText();
				Polinom p1 = new Polinom(s1);
				Polinom integr = ops.intPoli(p1);
				String rez = integr.poliToText()+"+C";
				gui.setTextField(gui.getField(3), rez);
			}
		});
		gui.getJButton("deriv").addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// DERIVATION
				String s1 = gui.getField(1).getText();
				Polinom p1 = new Polinom(s1);
				Polinom deriv = ops.derivPoli(p1);
				String rez = deriv.poliToText();
				gui.setTextField(gui.getField(3), rez);
			}
		});
	}
	public Control() {
		this.gui = new Gui();
		this.ops = new Operations();
		run();
	}
	
	public static void main(String[] args) {
		Control ctrl = new Control();
		ctrl.gui.setVisible(true);
	}
}
