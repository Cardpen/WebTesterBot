package Drivers;

public class Account {
	String userName;
	String password;
	String runnerID;
	String hitterID;
	String muleID;
	
	public Account(String userName, String password, 
			String runnerID, String hitterID, String muleID) {
		this.userName = userName;
		this.password = password;
		this.runnerID = runnerID;
		this.hitterID = hitterID;
		this.muleID = muleID;
		
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}

	public String getRunnerID() {
		return runnerID;
	}

	public String getHitterID() {
		return hitterID;
	}

	public String getMuleID() {
		return muleID;
	}
}
