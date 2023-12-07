package Dao;

import java.util.List;

import Entity.Chat;

public interface IChatDAO {
	public List<Chat> findAll(String SourceID);
	public void DeleteChat(String SourceID, String TargetID);
	public void InsertChat(String SourceID, String TargetID);
}
