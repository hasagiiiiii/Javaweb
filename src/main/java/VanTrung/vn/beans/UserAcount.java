package VanTrung.vn.beans;

public class UserAcount {
	public static final String GENDER_MALE = "chuot";
	public static final String GENDER_FEMALE = "meo";
	private String userName;
	private String GENDER ;
	private String Password;
	
	public UserAcount() {
		
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGENDER() {
		return GENDER;
	}
	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	public UserAcount(String userName, String gENDER, String password) {
		super();
		this.userName = userName;
		GENDER = gENDER;
		Password = password;
	}
}
