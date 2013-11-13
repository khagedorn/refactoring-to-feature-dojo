package piggybank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PiggyBank {
	
	private File file;

	public PiggyBank(File file){
		this.file = file;
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext()){
				String l = sc.nextLine();
				String c = l.split(" ")[2].trim(); // index 0 is the date, index 1 is the command
				// and if the command has an amount, index 2 is the amount
				if(c.equals("save") || c.equals("withdraw")){
					String a = l.split(" ")[3].trim();
					double amount = Double.parseDouble(a);
					
					if(c.equals("save"))
						val += amount;
					if(c.equals("withdraw"))
						val -= amount;
				}
				
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private double val;

	public void save(int meur, int mct) {
		val += meur + mct / 100.0;
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
			String date = new SimpleDateFormat("dd.MM.yyyy, hh:mm").format(new Date());
			bufferedWriter.append(date + " save " + meur + "." + mct + "\n");
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String money() {
		double nBehDec = Math.round((val - ((int) val)) * 100.0);
		String decNumberStr = (int) nBehDec + "";
		if (decNumberStr.length() == 1) decNumberStr += 0;
		return "Saved amount: " + ((int) val) + "." + decNumberStr;
	}

	public boolean withdraw(int i, int j) {
		if (i + j / 100 > val)
			return false;
		
		val -= i + j / 100.0;
		
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
			String date = new SimpleDateFormat("dd.MM.yyyy, hh:mm").format(new Date());
			bufferedWriter.append(date + " withdraw " + i + "." + j + "\n");
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}

}
