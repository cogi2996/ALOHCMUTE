package Entity;

import java.io.Serializable;
import java.util.Objects;

public class ClassId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sourceID;
    private String targetID;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassId chatId = (ClassId) o;
        return Objects.equals(sourceID, chatId.sourceID) &&
                Objects.equals(targetID, chatId.targetID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceID, targetID);
    }
}
