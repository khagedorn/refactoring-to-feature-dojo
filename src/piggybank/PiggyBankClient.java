package piggybank;

public class PiggyBankClient {
	
	private double val;

	public void save(int meur, int mct) {
		val += meur + mct / 100.0;
	}

	public double money() {
		return val;
	}

}
