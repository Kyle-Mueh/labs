package mini;

public class VendingMachine extends java.lang.Object {
	private int quarters, purchases, dimes, nickels, balance;
	public VendingMachine(int numQuarters, int numDimes, int numNickels){
		quarters=numQuarters;
		dimes=numDimes;
		nickels=numNickels;
	}
	public void cancel(){
		quarters-=balance/25;
		balance%=25;
		dimes-=balance/10;
		balance%=10;
		nickels-=balance/5;
		balance%=5;

	}
	public int getBalance(){
		return balance;
	}
	public int getCount(){
		return purchases;
	}
	public int getDimes(){
		return dimes;
	}
	public int getNickels(){
		return nickels;
	}
	public int getQuarters(){
		return quarters;
	}
	public int getTotalValue(){
		return((quarters*25)+(dimes*10)+(nickels*5));
	}
	public void insertDimes(int numDimes){
		dimes+=numDimes;
		balance+=(numDimes*10);
	}
	public void insertNickels(int numNickels){
		nickels+=numNickels;
		balance+=(numNickels+5);
	}
	public void insertQuarters(int numQuarters){
		quarters+=numQuarters;
		balance+=(numQuarters*25);
	}
	public void purchase(int cost){
		if((balance-cost)>0)
			balance-= cost;
		quarters-=balance/25;
		balance%=25;
		dimes-=balance/10;
		balance%=10;
		nickels-=balance/5;
		nickels%=5;
	}
	public String toString(){
		String s=""+quarters+", "+dimes+", "+nickels;
		
		return s;
	}
	
}
