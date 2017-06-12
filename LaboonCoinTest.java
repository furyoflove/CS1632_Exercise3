import static org.junit.Assert.*;

import org.junit.*;

public class LaboonCoinTest {

	// Assert that creating a new LaboonCoin instance
	// does not return a null reference
	@Test
	public void testLaboonCoinExists() {
	LaboonCoin l = new LaboonCoin();
	assertNotNull(l);
	}
	
	// Test for hash()
	// Assert that running the hash() 
	// returns a non-null value
	@Test
	public void testLaboonCoinHashExists() {
		LaboonCoin coin = new LaboonCoin();
		int output = coin.hash("boo");
		assertNotNull(output);
	}
	
	// Test for hash()
	// Assert that running the hash() 
	// returns equal to itself
	@Test
	public void testLaboonCoinHashEqualsItself() {
		LaboonCoin coin = new LaboonCoin();
		int output = coin.hash("boo");
		assertEquals(output, output);
	}
	
	// Test for hash()
	// Assert that running the hash() method
	// returns the expected output
	@Test
	public void testLaboonCoinHashMatchesExpected() {
		LaboonCoin coin = new LaboonCoin();
		int output = coin.hash("boo");
		assertEquals(String.format("%08x", 1428150834), String.format("%08x", output));
	}
	
	// Test for validHash()
	// Asserts that running the validHash() method
	// returns a non-null value
	@Test
	public void testLaboonCoinValidHashExists(){
		LaboonCoin coin = new LaboonCoin();
		// Simulate passing in "boo" as the first entry and then being hashed
		String data = "boo";
		String toTry = String.format("%08x", 0) + String.format("%08x", 0) + data;
		int hashVal =  coin.hash(toTry),
			difficulty = 3;
		boolean status = coin.validHash(difficulty,hashVal);
		
		assertNotNull(status);
	}
	
	// Test for validHash()
	// Asserts that running the validHash() method
	// returns equal to itself
	@Test
	public void testLaboonCoinValidHashEqualsItself(){
		LaboonCoin coin = new LaboonCoin();
		// Simulate passing in "boo" as the first entry and then being hashed
		String data = "boo";
		String toTry = String.format("%08x", 0) + String.format("%08x", 0) + data;
		int hashVal =  coin.hash(toTry),
			difficulty = 3;
		boolean status = coin.validHash(difficulty,hashVal);
		
		assertEquals(status, status);
	}
	
	// Test for validHash()
	// Asserts that running the validHash() method
	// returns true that it matches an expected value
	@Test
	public void testLaboonCoinValidHashMatchesExpected(){
		LaboonCoin coin = new LaboonCoin();
		// Simulate passing in "boo" as the first entry and then being hashed
		String data = "boo";
		String toTry = String.format("%08x", 0) + String.format("%08x", 0) + data;
		int hashVal =  coin.hash(toTry),
			difficulty = 3;
		boolean status = coin.validHash(difficulty,hashVal);
		
		// This test should be false for the first valid hash attempt with nonce = 0
		assertEquals(false, status);
	}
	
	// Test for createBlock()
	// Asserts that running createBlock() method
	// returns a non-null value
	@Test
	public void testLaboonCoinCreateBlockExists() {
		LaboonCoin coin = new LaboonCoin();
		// Simulate passing in "boo" as the first entry and then being hashed
		String data = "boo";
		String toTry = String.format("%08x", 0) + String.format("%08x", 0) + data;
		int hashVal =  coin.hash(toTry);
		// previous hash and nonce are set to 0
		String newblock = coin.createBlock(data, 0, 0, hashVal);
		assertNotNull(newblock);
	}
	
	// Test for createBlock()
	// Asserts that running createBlock() method
	// returns equal to itself
	@Test
	public void testLaboonCoinCreateBlockEqualsItself() {
		LaboonCoin coin = new LaboonCoin();
		// Simulate passing in "boo" as the first entry and then being hashed
		String data = "boo";
		String toTry = String.format("%08x", 0) + String.format("%08x", 0) + data;
		int hashVal =  coin.hash(toTry);

		String newblock = coin.createBlock(data, 0, 0, hashVal);
		assertEquals(newblock, newblock);
	}
	
	// Test for createBlock()
	// Asserts that running createBlock() method
	// returns true that it adds the block properly compared to expected. 
	@Test
	public void testLaboonCoinCreateBlockMatchesExpected() {
		LaboonCoin coin = new LaboonCoin();
		// Simulate passing in "boo" as the first entry and then being hashed
		String data = "boo";
		String toTry = String.format("%08x", 0) + String.format("%08x", 0) + data;
		int hashVal =  coin.hash(toTry);
		
		// integer values for the previous hash, nonce, and final hash will converted
		// from integers to hexadecimal
		String newblock = coin.createBlock(data, 0, 4283, 738238);
		assertEquals("boo|00000000|000010bb|000b43be", newblock);
	}
	
	// Test for getBlockChain()
	// Asserts that running getBlockChain() method
	// returns a non-null value
	@Test
	public void testLaboonCoinGetBlockChainExists() {
		LaboonCoin coin = new LaboonCoin();
		// Simulate passing in "boo" as the first entry and then being hashed
		String data = "boo";
		String toTry = String.format("%08x", 0) + String.format("%08x", 0) + data;
		int hashVal =  coin.hash(toTry);

		String newblock = coin.createBlock(data, 0, 0, hashVal);
		coin.blockchain.add(newblock);
		String block = coin.getBlockChain();
		assertNotNull(block);
	}
	
	// Test for getBlockChain()
	// Asserts that running getBlockChain() method
	// returns equal to itself
	@Test
	public void testLaboonCoinGetBlockChainEqualsItself() {
		LaboonCoin coin = new LaboonCoin();
		// Simulate passing in "boo" as the first entry and then being hashed
		String data = "boo";
		String toTry = String.format("%08x", 0) + String.format("%08x", 0) + data;
		int hashVal =  coin.hash(toTry);

		String newblock = coin.createBlock(data, 0, 0, hashVal);
		coin.blockchain.add(newblock);
		String block = coin.getBlockChain();
		assertEquals(block, block);
	}
	
	// Test for getBlockChain()
	// Asserts that running getBlockChain() method
	// returns true that it matches an expected output
	@Test
	public void testLaboonCoinGetBlockChainMatchesExpected() {
		LaboonCoin coin = new LaboonCoin();
		// Simulate passing in "boo" as the first entry and then being hashed
		String data = "boo";
		String toTry = String.format("%08x", 0) + String.format("%08x", 0) + data;
		int hashVal =  coin.hash(toTry);
		String newblock = coin.createBlock(data, 0, 0, hashVal);
		// System.out.println(newblock);
		coin.blockchain.add(newblock);
		String block = coin.getBlockChain();
		// System.out.println(block);
		assertEquals("boo|00000000|00000000|ae4c0d92", block );
	}
	
}