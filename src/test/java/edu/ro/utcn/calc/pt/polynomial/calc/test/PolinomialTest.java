package edu.ro.utcn.calc.pt.polynomial.calc.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.ro.utcn.calc.pt.polynomial.calc.model.*;
import edu.ro.utcn.calc.pt.polynomial.calc.services.*;

public class PolinomialTest {

	Operations ops = new Operations();
	
	@Test
	public void addTest() {
		Polinom expectedAddResult = new Polinom();
		expectedAddResult.addMonom(new Monom(2, 2));
		expectedAddResult.addMonom(new Monom(0, 1));
		expectedAddResult.addMonom(new Monom(1, 0));
		Polinom add1 = new Polinom();
		add1.addMonom(new Monom(1.5, 0));
		add1.addMonom(new Monom(1.5, 2));
		add1.addMonom(new Monom(1.5, 1));
		Polinom add2 = new Polinom();
		add2.addMonom(new Monom(0.5, 2));
		add2.addMonom(new Monom(-1.5, 1));
		add2.addMonom(new Monom(-0.5, 0));
		
		Polinom addRez = ops.addPoli(add1, add2);
		addRez.sortPoli();
		expectedAddResult.sortPoli();
		assertEquals("test addition",expectedAddResult, addRez);
	}
	
	@Test
	public void subTest() {
		Polinom expectedSubResult = new Polinom();
		expectedSubResult.addMonom(new Monom(2, 5));
		expectedSubResult.addMonom(new Monom(-1.5, 3));
		expectedSubResult.addMonom(new Monom(-2, 2));
		expectedSubResult.addMonom(new Monom(2, 0));
		Polinom sub1 = new Polinom();
		sub1.addMonom(new Monom(3.5, 5));
		sub1.addMonom(new Monom(-2, 2));
		Polinom sub2 = new Polinom();
		sub2.addMonom(new Monom(1.5, 3));
		sub2.addMonom(new Monom(1.5, 5));
		sub2.addMonom(new Monom(-2, 0));
		
		Polinom subRez = ops.subPoli(sub1, sub2);
		subRez.sortPoli();
		expectedSubResult.sortPoli();
		assertEquals("test subtraction",expectedSubResult, subRez);
	}
	
	@Test
	public void intTest() {
		Polinom expectedIntResult = new Polinom();
		expectedIntResult.addMonom(new Monom(1, 3));
		expectedIntResult.addMonom(new Monom(-0.8, 2));
		expectedIntResult.addMonom(new Monom(0.5, 8));
		Polinom int1 = new Polinom();
		int1.addMonom(new Monom(3,2));
		int1.addMonom(new Monom(-1.6,1));
		int1.addMonom(new Monom(4,7));
		Polinom intRez = ops.intPoli(int1);
		intRez.sortPoli();
		expectedIntResult.sortPoli();
		assertEquals("test subtraction",expectedIntResult, intRez);
	}
	
	@Test
	public void derivTest() {
		Polinom expectedDerivResult = new Polinom();
		expectedDerivResult.addMonom(new Monom(-5, 0));
		expectedDerivResult.addMonom(new Monom(14, 6));
		expectedDerivResult.addMonom(new Monom(6, 1));
		Polinom deriv1 = new Polinom();
		deriv1.addMonom(new Monom(2,7));
		deriv1.addMonom(new Monom(-5,1));
		deriv1.addMonom(new Monom(3,2));
		deriv1.addMonom(new Monom(3,0));
		Polinom derivRez = ops.derivPoli(deriv1);
		derivRez.sortPoli();
		expectedDerivResult.sortPoli();
		assertEquals("test subtraction",expectedDerivResult, derivRez);
	}
	
	@Test
	public void mulTest() {
		Polinom expectedMulResult = new Polinom();
		expectedMulResult.addMonom(new Monom(3, 4));
		expectedMulResult.addMonom(new Monom(4,7));
		expectedMulResult.addMonom(new Monom(-4.5,6));
		expectedMulResult.addMonom(new Monom(-6,9));
		Polinom mul1 = new Polinom();
		mul1.addMonom(new Monom(2, 3));
		mul1.addMonom(new Monom(-3, 5));
		Polinom mul2 = new Polinom();
		mul2.addMonom(new Monom(1.5, 1));
		mul2.addMonom(new Monom(2,4));
		
		Polinom mulRez = ops.mulPoli(mul1, mul2);
		mulRez.sortPoli();
		expectedMulResult.sortPoli();
		assertEquals("test subtraction",expectedMulResult, mulRez);
	}
	
	@Test
	public void divTest() {
		Polinom expectedDivResult1 = new Polinom();
		expectedDivResult1.addMonom(new Monom(1, 1));
		expectedDivResult1.addMonom(new Monom(1,0));
		Polinom expectedDivResult2 = new Polinom();
		Polinom div1 = new Polinom();
		div1.addMonom(new Monom(1, 2));
		div1.addMonom(new Monom(-1, 0));
		Polinom div2 = new Polinom();
		div2.addMonom(new Monom(1, 1));
		div2.addMonom(new Monom(-1,0));
		ops.divPoli(div1, div2);
		div1.sortPoli();
		div2.sortPoli();
		expectedDivResult1.sortPoli();
		assertEquals("test quotient",expectedDivResult1, div1);
		assertEquals("test remainder",expectedDivResult2, div2);
	}
}
