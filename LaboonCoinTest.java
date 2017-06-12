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
	// Asserts that running the validHash()
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
	// Asserts that running the validHash()
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
	// Asserts that running the validHash()
	// returns equal to itself
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
	
}