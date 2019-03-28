package edu.ro.utcn.calc.pt.polynomial.calc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {

	private ArrayList<Monom> poli;
	
	public Polinom(){
		this.poli = new ArrayList<Monom>();
	}
	public Polinom(String s){
		this.poli = new ArrayList<Monom>();
		Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
		Matcher matcher = pattern.matcher(s);
		int x = 0;
		while (matcher.find()) {
			x = x + 1;
			Monom m = new Monom(matcher.group(1));
			this.addMonom(m);
			//System.out.println("Group " + x + ": " + matcher.group(1));
		}
	}
	public void addMonom(Monom m){
		boolean found = false;
		for(Monom i : poli){
			if(i.getGrad()==m.getGrad()){
				i.add(m);
				found = true;
			}
		}
		if(found==false){
			poli.add(m);
		}
	}
	public void subMonom(Monom m){
		boolean found = false;
		for(Monom i : poli){
			if(i.getGrad()==m.getGrad()) {
				i.sub(m);
				found = true;
			}
		}
		if(found==false){
			m.setCoef((-1)*m.getCoef());
			poli.add(m);
		}
	}
	@Override
	public boolean equals(Object obj){
		if(obj==null)
			return false;
		if(!(obj instanceof Polinom))
			return false;
		Polinom p2 = (Polinom) obj;
		for(int i=0; i<poli.size(); i++) {
				if(!poli.get(i).equals(p2.getPoli().get(i))) {
					return false;
			}
		}
		return true;
	}
	public ArrayList<Monom> getPoli(){
		return poli;
	}
	public String poliToText(){
		sortPoli();
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<poli.size();i++) {
			double coef=poli.get(i).getCoef();
			int grad=poli.get(i).getGrad();
			if(coef > 0.0) {
				sb.append('+');
				sb.append(String.format("%.1f", coef));
				sb.append("x^");
				sb.append(grad);
			}
			else
				if(coef < 0.0) {
					sb.append(String.format("%.1f", coef));
					sb.append("x^");
					sb.append(grad);
				}
		}
		return sb.toString();
	}
	public void sortPoli(){
		Collections.sort(poli);
		Collections.reverse(poli);
	}
}
