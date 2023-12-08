package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entity.Chat;
import JpaConfig.JPAConfig;

public class ChatDaoImpl implements IChatDao {

	@Override
	public List<Chat> findBySourceId(String sourceId) {
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT c FROM Chat c WHERE c.sourceId = :sourceId";
		TypedQuery<Chat> query = enma.createQuery(jpql, Chat.class);
		query.setParameter("sourceId", sourceId);
		return query.getResultList();
	}

	@Override
	public boolean insert(Chat chat) {
		boolean result = false;
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(chat);
			trans.commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			enma.close();
		}
		return result;
	}

	@Override
	public boolean delete(Chat chat) {
		boolean result = false;
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			Chat entity = em.find(Chat.class, chat);
			if (entity != null) {
				em.remove(entity);
			}
			trans.commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return result;
	}
}
