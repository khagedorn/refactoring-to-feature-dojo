package piggybank;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class PiggyBankClient {
	
	private boolean exit = false;
	private PiggyBank piggyBank;

	public PiggyBankClient(File f) {
		piggyBank = new PiggyBank(f);
	}

	public static void main(String[] args){
		String fileName = args.length > 0 ? args[0] : "piggybank.pbk";
		File f = new File(fileName);
		
		if(!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		PiggyBankClient client = new PiggyBankClient(f);
		while(!client.exit ){
			BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
			try {
				System.out.print("pb: ");
				String line = r.readLine();
				String output = client.doStr(line);
				System.out.print(output);
				if(output.length() > 0 && !output.endsWith("\n"))
					System.out.println("");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	String doStr(String line) {
		if ("q".equals(line.trim()) || "quit".equals(line.trim())){
			exit = true;
			return "Exiting...";
		} else if  ("b".equals(line.trim()) || "balance".equals(line.trim())){
			return piggyBank.money();
		} else if  (line.startsWith("s") || line.startsWith("save")){
			String str = line.split(" ")[1];
			String befDec = str.split("\\.")[0];
			String afterDec;
			try {
				afterDec = str.split("\\.")[1];
			} catch (ArrayIndexOutOfBoundsException e){
				afterDec = "00";
			}
			piggyBank.save(Integer.parseInt(befDec), Integer.parseInt(afterDec));
			return "ok";
		} else if  (line.startsWith("w") || line.startsWith("withdraw")){
			String str = line.split(" ")[1];
			String befDec = str.split("\\.")[0];
			String afterDec;
			try {
				afterDec = str.split("\\.")[1];
			} catch (ArrayIndexOutOfBoundsException e){
				afterDec = "00";
			}
			boolean withdraw = piggyBank.withdraw(Integer.parseInt(befDec), Integer.parseInt(afterDec));
			
			if(!withdraw)
				return "You are too poor to withdraw that much!";
			return "ok";
		} else {
			return "Unknown Command: " + line.trim();			
		}
	}
}
