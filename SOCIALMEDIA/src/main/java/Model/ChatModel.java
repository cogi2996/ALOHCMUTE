package Model;

import java.util.Date;

public class ChatModel {
	private String sourceID;
	private String targetID;
	private String sourceName;
	private String targetName;
	private String sourceAvatar;
	private String targetAvatar;
	@Override
	    public String toString() {
	        return "ChatModel{" +
	                "sourceID='" + sourceID + '\'' +
	                ", targetID='" + targetID + '\'' +
	                ", sourceName='" + sourceName + '\'' +
	                ", targetName='" + targetName + '\'' +
	                ", sourceAvatar='" + sourceAvatar + '\'' +
	                ", targetAvatar='" + targetAvatar + '\'' +
	                '}';
	    }
	public ChatModel() {
		super();
    }

    public ChatModel(String sourceID, String targetID, String sourceName, String targetName, String sourceAvatar, String targetAvatar) {
        this.sourceID = sourceID;
        this.targetID = targetID;
        this.sourceName = sourceName;
        this.targetName = targetName;
        this.sourceAvatar = sourceAvatar;
        this.targetAvatar = targetAvatar;
    }

    // Getter and Setter methods
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

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getSourceAvatar() {
        return sourceAvatar;
    }

    public void setSourceAvatar(String sourceAvatar) {
        this.sourceAvatar = sourceAvatar;
    }

    public String getTargetAvatar() {
        return targetAvatar;
    }

    public void setTargetAvatar(String targetAvatar) {
        this.targetAvatar = targetAvatar;
    }
}
