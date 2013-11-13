package piggybank;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class PiggyBankTest {
	
	@Test
	public void saveTest(){
		PiggyBankClient bcl = new PiggyBankClient();
		bcl.save(10, 0);
		
		assertEquals(10.0, bcl.money());
		
	}

}
