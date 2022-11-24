package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ConnexionJpa {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-jpa-jo");
		EntityManager em = entityManagerFactory.createEntityManager();
//		EntityTransaction transaction = em.getTransaction();
//
//		transaction.begin();
//		
//		transaction.commit();
	}

}
