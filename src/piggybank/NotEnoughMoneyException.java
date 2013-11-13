package piggybank;

public class NotEnoughMoneyException extends RuntimeException {
	
	private static final long serialVersionUID = 4685914759726744587L;

	public NotEnoughMoneyException() {
	}
	
	public NotEnoughMoneyException(String m){
		super(m);
	}

}
