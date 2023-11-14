package Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "BoxChat")
@NamedQuery(name = "BoxChat.findAll", query = "SELECT b FROM BoxChat b")
public class BoxChat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int boxChatID;
	private int userID;

	// user sở hữu boxchat
	@OneToOne(mappedBy = "boxChat")
	private User user;

	// các đoạn chat trong boxchat
//	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "boxChat",fetch = FetchType.EAGER)
	private List<Chat> chats;

	@Override
	public String toString() {
		return "BoxChat [boxChatID=" + boxChatID + ", userID=" + userID + "]";
	}



	public BoxChat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBoxChatID() {
		return boxChatID;
	}

	public void setBoxChatID(int boxChatID) {
		this.boxChatID = boxChatID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public List<Chat> getChats() {
		return chats;
	}

	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}

}
