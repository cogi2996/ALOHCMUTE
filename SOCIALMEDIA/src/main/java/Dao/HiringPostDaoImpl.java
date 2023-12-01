package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.HiringPost;
import JpaConfig.JPAConfig;


public class HiringPostDaoImpl implements IHiringPostDao {
	@Override
	public List<HiringPost> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<HiringPost> query = enma.createNamedQuery("HiringPost.findAll", HiringPost.class);
		return query.getResultList();
	}
	
	@Override
	public HiringPost findById(int id) {
		EntityManager enma = JPAConfig.getEntityManager();
		HiringPost entity = enma.find(HiringPost.class, id);
		return entity;
	}
}
