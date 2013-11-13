package piggybank;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;


public class PiggyBankTest {
	
	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();
	
	@Test
	public void testSave() throws IOException {
		tempFolder.create();
		
		File f = tempFolder.newFile();
		
		PiggyBankClient client = new PiggyBankClient(f);

		client.doStr("save 10.00");
		assertEquals("Saved amount: 10.00", client.doStr("balance"));
		
		client.doStr("save 21.32");
		client.doStr("save 33.00");
		
		assertEquals("Saved amount: 64.32", client.doStr("balance"));
		
		tempFolder.delete();
	}

	@Test
	public void testWithdraw() throws IOException {
		tempFolder.create();
		
		File f = tempFolder.newFile();
		
		PiggyBankClient client = new PiggyBankClient(f);

		client.doStr("save 10.00");
		assertEquals("Saved amount: 10.00", client.doStr("balance"));
		
		client.doStr("withdraw 5.00");

		assertEquals("Saved amount: 5.00", client.doStr("balance"));
		
		assertEquals("You are too poor to withdraw that much!", client.doStr("withdraw 8.00"));
		
		tempFolder.delete();
	}

}
