package account;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.Session;

import game.HibernateUtil;

@Entity
public class Account {
	
	@Id
	String name;
	int passHash;
	
	
	
	private Account() {};
	private Account(String name , String password)
	{
		this.name = name;
		passHash = getHash(password);
	}
	
	static Account signIn(String name , String password)
	{
		
		return null;
	}
	static Account createAccount(String name , String password) throws AccountException
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
 
        List<Account> accounts = session.createQuery("from Account where name='"+name+"'").list();
        
		session.getTransaction().commit();
		
		if(accounts.size()>0)
		{
			throw new AccountException("Nick is used");
		}
		
		
        session = HibernateUtil.getSessionFactory().getCurrentSession();              
        
        session.beginTransaction();
        Account account = new Account(name, password);
        session.save(account);
        session.getTransaction().commit();
		return account;
		
	}
	
	static void printAllAccount()
	{
		List<Account> list = getAllAccount();
		for (Account account : list) {
			System.out.println(account.name +"  "+ account.passHash);
		}
	}
	
	static List<Account> getAllAccount()
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
 
        List<Account> list = session.createQuery("from Account").list();
        session.getTransaction().commit();
        return list;
	}
	
	static int getHash(String password)
	{
		return password.hashCode();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPassHash() {
		return passHash;
	}

	public void setPassHash(int passHash) {
		this.passHash = passHash;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Account)
		{
			if(  ((Account)obj).name.equals(name) && passHash == ((Account)obj).passHash) 
			{
				return true;
			}
		}
		return false;
	}
	@Override
	public int hashCode() {
		return name.hashCode()+passHash;
	}
}
