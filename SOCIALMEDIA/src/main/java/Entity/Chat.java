package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Chat")
@NamedQuery(name = "Chat.findAll", query = "select p from Chat p")
public class Chat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int chatID;
	private int boxChatID;

	// 1-nhiều giữa chat với chatbox
	@ManyToOne
	@JoinColumn(name = "boxChatID")
	private BoxChat boxChat;

	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getChatID() {
		return chatID;
	}

	public void setChatID(int chatID) {
		this.chatID = chatID;
	}

	public BoxChat getBoxChat() {
		return boxChat;
	}

	public void setBoxChat(BoxChat boxChat) {
		this.boxChat = boxChat;
	}
}
