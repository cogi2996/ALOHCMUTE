package Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@IdClass(FollowId.class)

@Table(name = "follow")
@NamedQuery(name = "Follow.findAll", query = "select f from Follow f")

public class Follow implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String sourceID;
	@Id
	private String targetID;

	private Date followCreateTime;

	@Override
	public String toString() {
		return "Follow [sourceID=" + sourceID + ", targetID=" + targetID + ", followCreateTime=" + followCreateTime
				+ "]";
	}

	public Follow(String sourceID, String targetID, Date followCreateTime) {
		this.sourceID = sourceID;
		this.targetID = targetID;
		this.followCreateTime = followCreateTime;
	}

	public Follow() {
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

	public Date getFollowCreateTime() {
		return followCreateTime;
	}

	public void setFollowCreateTime(Date followCreateTime) {
		this.followCreateTime = followCreateTime;
	}

}
