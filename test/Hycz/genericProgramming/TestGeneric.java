package genericProgramming;

import java.util.*;

public class TestGeneric {
	public static void main(String[] args){
		Manager ceo=new Manager("Gus Greedy",800000,2003,12,15);
		Manager cfo=new Manager("Sid Sneaky",600000,2003,12,15);
		Pair<Manager> buddies = new Pair<Manager>(ceo,cfo);	
		printBuddies(buddies);
		
		Pair<? extends Employee> w;
		//w=new Pair<Object>();//illegal
		w=new Pair<Employee>();
		w=new Pair<Manager>();
		Pair<? extends Employee> wildcardBuddies=buddies;
		//Manager m = wildcardBuddies.getFirst();//illegal
		Employee e = wildcardBuddies.getFirst();//legal
		Object o = wildcardBuddies.getFirst();//legal
		//wildcardBuddies.setFirst(null);//legal but useless
		//wildcardBuddies.setFirst(ceo);//illegal
		printBuddies(wildcardBuddies);
				
		class Boss extends Manager{
			Boss(String n, double s, int year, int month, int day){
				super(n,s,year,month,day);
			}
		}
		Boss bos=new Boss("Supertype Boss",800000,2003,12,15);
		Manager man=new Manager("Supertype Manager",800000,2003,12,15);
		Employee emp=new Employee("Supertype Employee",800000,2003,12,15);
		Object obj=new Object();
		Pair<? super Manager> w2=new Pair<Object>();
		Pair<? super Manager> w3=new Pair<Employee>();
		Pair<? super Manager> w4=new Pair<Manager>();
		//Pair<? super Manager> w5=new Pair<Boss>();
		w2.setFirst(bos);
		w2.setFirst(man);
		//w2.setFirst(emp);
		//w2.setFirst(obj);
		Pair<? super Employee> w6=new Pair<Object>();
		w6.setFirst(bos);
		w6.setFirst(man);
		w6.setFirst(emp);
		//w6.setFirst(obj);
		w6.getFirst();
		
		ceo.setBonus(1000000);
		cfo.setBonus(500000);
		Manager[] managers ={ceo, cfo};
		
		Pair<Employee> result = new Pair<Employee>();
		minmaxBonus(managers, result);
		System.out.println("first: "+result.getFirst().getName()+", second: "+result.getSecond().getName());
		maxminBonus(managers, result);
		System.out.println("first: "+result.getFirst().getName()+", second: "+result.getSecond().getName());
		
	}
	
	public static void printBuddies(Pair<? extends Employee> p){
		Employee first = p.getFirst();
		Employee second = p.getSecond();
		System.out.println(first.getName()+" and "+ second.getName()+" are buddies.");
	}
	
	public static void minmaxBonus(Manager[] a, Pair<? super Manager> result){
		if (a==null || a.length ==0) return;
		Manager min = a[0];
		Manager max = a[0];
		for (int i=1;i<a.length;i++){
			if (min.getBonus() > a[i].getBonus()) min = a[i];
			if (max.getBonus() < a[i].getBonus()) max = a[i];
		}
		result.setFirst(min);
		result.setSecond(max);
	}
	
	public static void maxminBonus(Manager[] a, Pair<? super Manager> result){
		minmaxBonus(a, result);
		PairAlg.swapHelper(result);
	}
}
