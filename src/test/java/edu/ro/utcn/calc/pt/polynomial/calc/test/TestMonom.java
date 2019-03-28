package edu.ro.utcn.calc.pt.polynomial.calc.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.ro.utcn.calc.pt.polynomial.calc.model.*;

public class TestMonom {

	@Test
	public void MonomTest(){
		Monom m1 = new Monom(1.3,2), m2 = new Monom(1.5,2);
		assertEquals("tested monoms",m1,m2);
	}
	
}
