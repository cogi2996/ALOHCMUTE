package Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Chat")
@NamedQuery(name = "Chat.findAll", query = "select c from Chat c")
@IdClass(ClassId.class)
public class Chat implements Serializable {
	@Id
    private String sourceID;

    @Id
    private String targetID;
	@ManyToOne
	@JoinColumn( name= "userID")
	private  User user;
	
	@Override
	public String toString() {
		return "Chat{" +
                ", sourceID='" + sourceID + '\'' +
                ", targetID='" + targetID + '\'' +
                '}';
	}
	
	public Chat(String sourceID, String targetID, User user) {
		super();
		this.sourceID = sourceID;
		this.targetID = targetID;
		this.user = user;
	}
	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSourceID() {
		return sourceID;
	}
	
	public void setSourceID(String sourceID) {
		this.sourceID = sourceID;
	}
	
	public String getTargetID() {
		return targetID;
	}
	
	public void setTargetID(String targetID) {
		this.targetID = targetID;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	
}
