package edu.ro.utcn.calc.pt.polynomial.calc.services;

import edu.ro.utcn.calc.pt.polynomial.calc.model.Monom;
import edu.ro.utcn.calc.pt.polynomial.calc.model.Polinom;

public class Operations {
	
	public Polinom addPoli(Polinom p1, Polinom p2){
		Polinom p1Copy = new Polinom();
		p1Copy=p1;
		for(Monom m2 : p2.getPoli())
		{
			p1Copy.addMonom(m2);
		}
		return p1Copy;
	}
	public Polinom subPoli(Polinom p1, Polinom p2){
		Polinom p1Copy = new Polinom();
		p1Copy=p1;
		for(Monom m2 : p2.getPoli())
		{
			p1Copy.subMonom(m2);
		}
		return p1Copy;
	}
	public Polinom mulPoli(Polinom p1, Polinom p2){
		Polinom b = new Polinom();
		for(Monom m1 : p2.getPoli()) {
			for(Monom m2 : p1.getPoli())
			{
				b.addMonom(new Monom(m1.getCoef()*m2.getCoef(),m1.getGrad()+m2.getGrad()));
			}
		}
		return b;
	}
	public void divPoli(Polinom p1, Polinom p2){
		//try {
			Polinom q = new Polinom();
			Polinom r = new Polinom();
			Polinom p = new Polinom();
			Monom t;
			for(Monom i: p1.getPoli()) {
				r.addMonom(new Monom(i.getCoef(),i.getGrad()));
			}
			while(isZeroPoli(r)==false && leadTerm(r).getGrad()>=leadTerm(p2).getGrad()) {
				t=divMonom(leadTerm(r),leadTerm(p2));
				q.addMonom(t);
				p=mulPoliWithMonom(p2,t);
				r=subPoli(r,p);
			}
			p1.getPoli().clear();
			p2.getPoli().clear();
			for(Monom i: q.getPoli()) {
				p1.addMonom(new Monom(i.getCoef(),i.getGrad()));
			}
			for(Monom i: r.getPoli()) {
				p2.addMonom(new Monom(i.getCoef(),i.getGrad()));
			}
	}
	public Polinom intPoli(Polinom p1){
		p1.sortPoli();
		Polinom p1Copy = new Polinom();
		for(Monom m : p1.getPoli()) {
			m.setGrad(m.getGrad()+1);
			m.setCoef(m.getCoef()/(double)m.getGrad());
			p1Copy.addMonom(m);
		}
		return p1Copy;
	}
	public Polinom derivPoli(Polinom p1){
		p1.sortPoli();
		Polinom p1Copy = new Polinom();
		Monom m;
		for(int i=0;i<p1.getPoli().size();i++) {
			m=p1.getPoli().get(i);
			if(m.getGrad()>=1)
			{
				m.setCoef(m.getCoef()*m.getGrad());
				m.setGrad(m.getGrad()-1);
				p1Copy.addMonom(m);
			}
		}
		return p1Copy;
	}
	public boolean isZeroPoli(Polinom p) {
		for(Monom m : p.getPoli()) {
			if(m.getCoef()!=0.0) {
				return false;
			}
		}
		return true;
	}
	public Monom leadTerm(Polinom p) {
		p.sortPoli();
		for(Monom i : p.getPoli()) {
			if(i.getCoef()!=0)
				return i;
		}
		return null;
	}
	public Monom divMonom(Monom m1, Monom m2) {
		Monom rez=new Monom(m1.getCoef()/m2.getCoef(),m1.getGrad()-m2.getGrad());
		return rez;
	}
	public Polinom mulPoliWithMonom(Polinom p, Monom m) {
		Polinom pCopy = new Polinom();
		//pCopy=p;
		for(Monom i : p.getPoli()) {
			pCopy.addMonom(new Monom(i.getCoef()*m.getCoef(),i.getGrad()+m.getGrad()));
		}
		return pCopy;
	}
}
