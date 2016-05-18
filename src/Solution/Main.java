package Solution;
import java.io.Console;
import java.util.Scanner;

public class Main {
	public static void main(String [] args){
		TransactionHistory database = new TransactionHistory();
		Scanner s = new Scanner(System.in);
		while (s.hasNextLine()){
			String line = s.nextLine();
			String[] parsedInput = line.split("\\s+");
			String action = parsedInput[0].toUpperCase();
			if (action.equals("END")){
				System.exit(0);
				s.close();
				return;
			}
			if(action.equals("BEGIN")) {
				database.begin();
			} else if (action.equals("ROLLBACK")){
				database.rollback();
			}
			else{
				String k = null;
			if (parsedInput.length > 1){
				k = parsedInput[1];
			}
			if (action.equals("GET") && parsedInput.length==2){
				//System.out.println("Here");
				database.get(k);
			} else if(action.equals("SET") && parsedInput.length==3){
				String v = parsedInput[2];
				database.set(k,v); 
			} else if(action.equals("UNSET") && parsedInput.length==2){
				database.unset(k);
			} else if(action.equals("NUMEQUALTO") && parsedInput.length==2){
				database.numEqualTo(k);
			} 
			
			  else{
				System.out.println("Unexpected input");
			}
			}
		}
		
	}
}