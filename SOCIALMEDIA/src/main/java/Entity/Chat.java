package Entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "Chat")
// Object khóa chính, tạo ra class khóa chính riêng nhưng ở đây class Chat này có 2 trường là 2 thuộc tính khóa chính nên dùng luôn
@IdClass(Chat.class)
public class Chat implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "varchar(100)")
	private String sourceId;
	@Column(columnDefinition = "varchar(100)")
	@Id
	private String targetId;

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sourceId, targetId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chat other = (Chat) obj;
		return Objects.equals(sourceId, other.sourceId) && Objects.equals(targetId, other.targetId);
	}
		
	public Chat() {
		super();
	}
	
	public Chat(String sourceId, String targetId) {
		super();
		this.sourceId = sourceId;
		this.targetId = targetId;
	}
}
