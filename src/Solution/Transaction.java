package Solution;

import java.util.*;

public class Transaction {
	/*The database consists of: 
	 * db : a primary hashmap to store key, value pairs 
	 * valueCount : a secondary hashmap to keep count of the occurrences of values
	 * */
	HashMap<String,String> db;
	HashMap<String,Integer> valueCount;
	Transaction prev;
	
	public Transaction(){
		this.db = new HashMap<String,String>();
		this.valueCount = new HashMap<String,Integer>();
		this.prev = null;
		
	}
	
	public void get(String k){
		
		Transaction t = this;
		
	while (t!=null){
		if (t.db.containsKey(k)){
			System.out.println(t.db.get(k));
			return;
		} else{
			if (t.prev != null){
				t = t.prev;
			} else{
				System.out.println("NULL");	
				return;
			}
			
		}
	} 
	System.out.println("NULL");	
	}
	
	public void set(String k, String v){
		if (db.containsKey(k)){
			String prev = db.get(k);
			valueCount.put(prev,(valueCount.get(prev) - 1));
			db.put(k,v);
		} else{
			db.put(k, v);
		}
		
		if (!valueCount.containsKey(v)){
			valueCount.put(v, 1);
		} else{
			valueCount.put(v, (valueCount.get(v) + 1));
		}
	}
	
	public void unset(String k){
		Transaction t = this;
		while(t!=null){
			if (t.db.containsKey(k)){
				String val = t.db.get(k);
				t.db.put(k,"NULL");
				t.valueCount.put(val, (t.valueCount.get(val) - 1));
				return;
			} else{
				if (t.prev!=null){
					t = t.prev;
				} else{
					return;
				}
			}
		}
	}
	
	public void getCount(String v){
		Transaction t = this;
		int total = 0;
		while(t!=null){
			if (t.valueCount.containsKey(v)){
				total += t.valueCount.get(v);
				System.out.println(Integer.toString(total));
				return;
			} else{
				if (t.prev != null){
					t = t.prev;
				} else{
					System.out.println(Integer.toString(total));
					return;
				}
			}
		}
		System.out.println(Integer.toString(total));
	}
	
	
}


