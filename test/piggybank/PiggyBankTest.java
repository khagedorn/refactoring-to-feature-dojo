package piggybank;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class PiggyBankTest {
	
	@Test
	public void testSave(){
		PiggyBankClient bcl = new PiggyBankClient();
		bcl.save(10, 0);
		
		assertEquals("Saved amount: 10.00", bcl.money());
		
		bcl.save(21, 32);
		bcl.save(33, 0);
		
		assertEquals("Saved amount: 64.32", bcl.money());
	}
	
	@Test
	public void testWithdraw(){
		PiggyBankClient bcl = new PiggyBankClient();
		bcl.save(10, 0);
		
		assertEquals("Saved amount: 10.00", bcl.money());
		
		bcl.withdraw(5, 0);
		
		assertEquals("Saved amount: 5.00", bcl.money());
		
		try {
			bcl.withdraw(8, 0);			
		} catch (NotEnoughMoneyException e){
			assertEquals("You are too poor to withdraw that much!", e.getMessage());
		}
	}

}
