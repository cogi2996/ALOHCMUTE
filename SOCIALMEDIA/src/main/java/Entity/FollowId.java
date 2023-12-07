package Entity;

import java.io.Serializable;
import java.util.Objects;

public class FollowId implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String sourceID;
	protected String targetID;

	public FollowId(String sourceID, String targetID) {
		this.sourceID = sourceID;
		this.targetID = targetID;
	}

	public FollowId() {
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof FollowId))
			return false;
		FollowId followId = (FollowId) o;
		return Objects.equals(getSourceID(), followId.getSourceID())
				&& Objects.equals(getTargetID(), followId.getTargetID());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getSourceID(), getTargetID());
	}

}
