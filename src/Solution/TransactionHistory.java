package Solution;

import java.util.HashMap;
import java.util.LinkedList;

public class TransactionHistory {
	
	LinkedList<Transaction> transactions;
	Transaction prev = null;
	
	
	public TransactionHistory(){
		this.transactions = new LinkedList<Transaction>();
		Transaction current = new Transaction();
		transactions.add(current);
		
	}
	
	public void begin(){
		Transaction prev = this.transactions.getLast(); 
		Transaction t = new Transaction();
		t.prev = prev;
		transactions.add(t);
		
	}
	
	public void get(String var){
		Transaction t = transactions.getLast();
		t.get(var);
		
	}
	
	public void set(String k, String v){
		transactions.getLast().set(k, v);
	}
	
	public void unset(String k){
		transactions.getLast().unset(k);
	}
	
	public void numEqualTo(String k){
		transactions.getLast().getCount(k);
	}
	
	public void rollback(){
		if (transactions.size() > 1){
			transactions.removeLast();
		} else{
			System.out.println("NO TRANSACTION");
		}
	}
	
}
