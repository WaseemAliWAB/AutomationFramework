package vtiger.Practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLineTest {
	
	@Test
	public void read()
	{
		String UN = System.getProperty("username");
		System.out.println(UN);
		
		String PW = System.getProperty("password");
		System.out.println(PW);
		
	}

}
