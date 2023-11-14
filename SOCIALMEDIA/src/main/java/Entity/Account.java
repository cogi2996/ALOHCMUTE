package Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
@NamedQuery(name = "Account.findAll", query = "SELECT c FROM Account c")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int uid;
	private String gmail;
	private String userName;
	private String password;

	@OneToOne(mappedBy = "account")
	private User user;

	@Override
	public String toString() {
		return "Account [uid=" + uid + ", gmail=" + gmail + ", userName=" + userName + ", password=" + password + "]";
	}

	public Account(int uid, String gmail, String userName, String password, User user) {
		super();
		this.uid = uid;
		this.gmail = gmail;
		this.userName = userName;
		this.password = password;
		this.user = user;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
