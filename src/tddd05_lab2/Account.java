package tddd05_lab2;

public class Account {
	private int balance;
	
	public Account (int balance){
		this.balance = balance;
	}
	
	public int getBalance(){
		return balance;
	}
	
	public void addBalance(int amount){
		balance += amount;
	}
	
	public void reduceBalance(int amount){
		balance -= amount;
	}
}
