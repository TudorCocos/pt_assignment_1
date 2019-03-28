package edu.ro.utcn.calc.pt.polynomial.calc.model;

public class Monom implements Comparable<Monom>{

	private double coef;
	private int grad;
	
	public double getCoef() {
		return coef;
	}
	public void setCoef(double coef) {
		this.coef = coef;
	}
	public int getGrad() {
		return grad;
	}
	public void setGrad(int grad) {
		this.grad = grad;
	}
	public Monom(double coef, int grad){
		this.coef=coef;
		this.grad=grad;
	}
	public Monom(String s){
		try {
		String coef, grad, save=s;
		boolean sign=true;
		coef=s.split("x")[0];
		char c[]=coef.toCharArray();
		if(c[0]=='-') {
			sign=false;
			coef=coef.substring(1);
		}else
			if(c[0]=='+') {
				coef=coef.substring(1);
			}
		grad=save.split("\\^")[1];
		this.coef=Double.parseDouble(coef);
		if(sign==false)
			this.coef=(-1)*this.coef;
		this.grad=Integer.parseInt(grad);
		}
		catch (Exception e){
			System.out.println("Input invalid! Try again!");
			System.out.println("P(x) is of the form: 3.5x^3-2x^0");
		}
	}	
	
	@Override
	public int compareTo(Monom m) {
	    return Integer.compare(this.grad, m.getGrad());
	}
	
	@Override 
	public boolean equals(Object obj){
		if(obj==null)
			return false;
		if(!(obj instanceof Monom))
			return false;
		Monom m2 = (Monom) obj;
		return (this.getCoef()==m2.getCoef() && this.getGrad()==m2.getGrad());
	}
	
	public void add(Monom m){
		if(this.grad==m.grad){
			this.coef+=m.coef;
		}
	}
	public void sub(Monom m){
		if(this.grad==m.grad){
			this.coef-=m.coef;
		}
	}
}
