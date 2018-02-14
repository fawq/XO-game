package account;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {

	@Test
	public void test() {
		try {
			Account.createAccount("test0", "test0");
		} catch (AccountException e) {
			System.out.println(  e.message  );
		}
		try {
			Account.createAccount("test1", "test1");
		} catch (AccountException e) {
			System.out.println(  e.message  );
		}
		try {
			Account.createAccount("test2", "test2");
		} catch (AccountException e) {
			System.out.println(  e.message  );
		}
		try {
			Account.createAccount("test3", "test3");
		} catch (AccountException e) {
			System.out.println(  e.message  );
		}		
	}

}
