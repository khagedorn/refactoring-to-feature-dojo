package piggybank;

public class PiggyBankClient {
	
	private double val;

	public void save(int meur, int mct) {
		val += meur + mct / 100.0;
	}

	public String money() {
		double nBehDec = Math.round((val - ((int) val)) * 100.0);
		String decNumberStr = (int) nBehDec + "";
		if (decNumberStr.length() == 1) decNumberStr += 0;
		return "Saved amount: " + ((int) val) + "." + decNumberStr;
	}

	public void withdraw(int i, int j) {
		if (i + j / 100 > val)
			throw new NotEnoughMoneyException("You are too poor to withdraw that much!");
		
		val -= i + j / 100.0;
	}

}
