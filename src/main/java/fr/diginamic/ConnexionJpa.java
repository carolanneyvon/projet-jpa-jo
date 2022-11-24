package fr.diginamic;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.enumerations.Sexe;
import fr.diginamic.entites.Athlete;
import fr.diginamic.entites.Sport;

public class ConnexionJpa {

	public static void main(String[] args) throws IOException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-jpa-jo");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		// Lecture du fichier Athlete
		// Transforme les lignes en objets
		Path path = Paths.get("C:\\Users\\Formation\\Documents\\workspace-spring-tool-suite-4-4.16.0.RELEASE\\projet-jpa-jo\\src\\main\\resources\\donnees\\athlete_epreuves.csv");
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		// Pour ne pas prendre en compte les entêtes du fichier
		lines.remove(0);
		
		// Afficher les données du fichier ligne par ligne
//		for (String line : lines) {
//		 System.out.println(line);
//		}
		

		// Parcourir le fichier Athlete
		// (int i = 0; i < lines.size(); i++)
		for (int i = 0; i < 100; i++) {
			transaction.begin();
			
			// Attributs pour Athlete
			String[] tab = lines.get(i).split(";");
			int id = Integer.parseInt(tab[0]);
			String nom = tab[1];
			Sexe sexe = Sexe.valueOf(tab[2]);
			// initialisation de age / taille / poids à 0 puis si age / taille / poids différent de NA
			int age = 0;
			if (!tab[3].equals("NA")) {
				age = Integer.parseInt(tab[3]);
			}
			float taille = 0;
			if (!tab[4].equals("NA")) {
				taille = Float.parseFloat(tab[4]);
			}
			float poids = 0;
			if (!tab[5].equals("NA")) {
				poids = Float.parseFloat(tab[5]);
			}
			
			// Attributs pour Sport
			String nomSport = tab[12];
			
			// INSERTION EN BDD
			// Insertion dans la table Athlete			
			Athlete athlete = new Athlete(id, nom, sexe, taille, poids, age);	
			//find By ID si athlete n'existe pas, alors persist
			Athlete athleteBase = em.find(Athlete.class, id);
			if (athleteBase == null) {
				em.persist(athlete);
			}
			System.out.println(athlete);
			
			// Insertion dans la table Sport
			Sport sport = new Sport(nomSport);
			//Sport sportBase = em.find(Sport.class, nom);
			
			TypedQuery<Sport> sportBase = em.createQuery("SELECT s FROM Sport s WHERE s.nom= :nom", Sport.class);
			sportBase.setParameter("nom", sport.getNom());
			// récupere le resultat de la requete et le stock dans sportBaseResult
			List<Sport>sportBaseResult = sportBase.getResultList();
			if (sportBaseResult.size() == 0) {
				em.persist(sport);
			}
			System.out.println(sport);
			
			
			
			// Insertion dans la table 
			
			transaction.commit();
		}
		
	}

}
