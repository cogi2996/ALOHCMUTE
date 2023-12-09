package JpaConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAConfig {
	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alohcmute");
		return factory.createEntityManager();
		
	}

//	public static void main(String[] args) {
//		EntityManager entityManager = JPAConfig.getEntityManager();
//
//		try {
//			// Thử kết nối đến cơ sở dữ liệu
//			entityManager.getTransaction().begin();
//			System.out.println("ket noi thanh cong");
//			entityManager.getTransaction().commit();
//		} catch (Exception e) {
//			System.err.println("Ket  noi that bai: " + e.getMessage());
//			if (entityManager.getTransaction().isActive()) {
//				entityManager.getTransaction().rollback();
//			}
//		} finally {
//			entityManager.close();
//		}
//	}
}
