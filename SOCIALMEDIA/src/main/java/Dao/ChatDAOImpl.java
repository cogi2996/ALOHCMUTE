package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.Chat;
import Entity.User;
import JpaConfig.JPAConfig;

public class ChatDAOImpl implements IChatDAO{
	public static void main(String[] args) {
		System.out.println(new ChatDAOImpl().findAll("aaaa"));
	}
	@Override
	public
	List<Chat> findAll(String SourceID){
		EntityManager entityManager = JPAConfig.getEntityManager();
		String jpql ="SELECT c FROM Chat WHERE c.sourceID like :SourceID";
		TypedQuery<Chat> query = entityManager.createQuery(jpql, Chat.class);
		query.setParameter("SourceID", "%" + SourceID + "%");
        
        return query.getResultList();
	}
	@Override
	public
	void DeleteChat(String SourceID, String TargetID) {
		
	}
	@Override
	public
	void InsertChat(String SourceID, String TargetID) {
		
	}
}
