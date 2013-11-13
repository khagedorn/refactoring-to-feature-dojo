package piggybank;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class PiggyBankTest {
	
	@Test
	public void testSave(){
		PiggyBankClient bcl = new PiggyBankClient();
		bcl.save(10, 0);
		
		assertEquals(10.0, bcl.money(), 0);
		
		bcl.save(21, 32);
		bcl.save(33, 0);
		
		assertEquals(64.32, bcl.money(), 0);
	}

}
