//package Dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
//
//import Entity.GroupPost;
//import JpaConfig.JPAConfig;
//
//public class GroupPostImpl implements IGroupPostDao {
//
//	@Override
//	public List<GroupPost> searchgroupPostText(String keyword) {
//		EntityManager entityManager = JPAConfig.getEntityManager();
//		TypedQuery<GroupPost> query = entityManager.createQuery("SELECT g FROM GroupPost g WHERE g.groupPostText LIKE :keyword",GroupPost.class);
//		query.setParameter("keyword", "%" + keyword + "%");
//
//		List<GroupPost> groupPost = query.getResultList();
//		entityManager.close();
//
//		return groupPost;
//	}
//}
