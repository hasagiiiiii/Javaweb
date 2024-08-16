package Entity;

public class AccountEntity {
	private int id_Account;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String imgUser;
	private String role_id;
	
	
	public AccountEntity() {
		super();
	}

	public AccountEntity(int id_Account, String firstName, String lastName, String userName, String password,
			String imgUser, String role_id) {
		super();
		this.id_Account = id_Account;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.imgUser = imgUser;
		this.role_id = role_id;
	}

	public int getId_Account() {
		return id_Account;
	}

	public void setId_Account(int id_Account) {
		this.id_Account = id_Account;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImgUser() {
		return imgUser;
	}

	public void setImgUser(String imgUser) {
		this.imgUser = imgUser;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	
	
	
	
	
}
