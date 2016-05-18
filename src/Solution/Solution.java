package Solution;

import java.util.*;

public class Solution {
	/*The database consists of: 
	 * db : a primary hashtable to store key, value pairs 
	 * valueCount : a secondary hashtable to keep count of the occurrences of values
	 * */
	Hashtable<String,String> db;
	Hashtable<String,Integer> valueCount;
	
	public Solution(){
		this.db = new Hashtable<String,String>();
		this.valueCount = new Hashtable<String,Integer>();
	}
	
	public void get(String k){
		if (db.containsKey(k)){
			//System.out.println("Here");
			System.out.println(db.get(k));
		} else{
			System.out.println("NULL");
			
		}
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
		if (db.containsKey(k)){
			String val = db.get(k);
			db.remove(k);
			valueCount.put(val, (valueCount.get(val) - 1));
		}
	}
	
	public void getCount(String v){
		if (valueCount.containsKey(v)){
			System.out.println(valueCount.get(v));
		} else{
			System.out.println("0");
		}
	}
	
	
}


