package account;

public class AccountException extends Exception{

	private static final long serialVersionUID = 1L;
	
	protected String message;
	
	public AccountException()
	{
		
	}
	
	public AccountException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
