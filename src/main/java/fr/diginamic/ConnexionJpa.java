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

import fr.diginamic.enumerations.Saison;
import fr.diginamic.enumerations.Sexe;
import fr.diginamic.entites.Athlete;
import fr.diginamic.entites.Banniere;
import fr.diginamic.entites.Jeux;
import fr.diginamic.entites.Sport;
import fr.diginamic.entites.TraductionBanniere;
import fr.diginamic.entites.TraductionSport;

public class ConnexionJpa {

	public static void main(String[] args) throws IOException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-jpa-jo");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		// Lecture du fichier Athlete
		// Transforme les lignes en objets
		Path pathAthlete = Paths.get("C:\\Users\\Formation\\Documents\\workspace-spring-tool-suite-4-4.16.0.RELEASE\\projet-jpa-jo\\src\\main\\resources\\donnees\\athlete_epreuves.csv");
		List<String> linesAthlete = Files.readAllLines(pathAthlete, StandardCharsets.UTF_8);
		// Pour ne pas prendre en compte les entêtes du fichier
		linesAthlete.remove(0);
		

		// Parcourir le fichier Athlete
		// (int i = 0; i < linesAthlete.size(); i++)
		for (int i = 0; i < 100; i++) {
			transaction.begin();
			
			// Attributs pour Athlete
			String[] tab = linesAthlete.get(i).split(";");
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
			
			// Attributs pour Jeux
			int annee = Integer.parseInt(tab[9]);
			Saison saison = Saison.valueOf(tab[10].toUpperCase());
			String ville = tab[11];
			
			
			// INSERTION EN BDD
			// Insertion dans la table Athlete			
			Athlete athlete = new Athlete(id, nom, sexe, taille, poids, age);	
			//find By ID si athlete n'existe pas, alors persist
			Athlete athleteBase = em.find(Athlete.class, id);
			if (athleteBase == null) {
				em.persist(athlete);
			}
			System.out.println(athlete);
			
			// Insertion dans la table Jeux
			Jeux jeux = new Jeux(annee, saison, ville);	
			TypedQuery<Jeux> queryJeuxBase = em.createQuery("SELECT a FROM Jeux a WHERE a.annee = :annee AND a.ville = :ville", Jeux.class);
			queryJeuxBase.setParameter("annee", jeux.getAnnee());
			queryJeuxBase.setParameter("ville", jeux.getVille());
			// récupere le resultat de la requete et le stock dans jeuxBaseResult
			List<Jeux>jeuxBaseResult = queryJeuxBase.getResultList();
			if (jeuxBaseResult.size() == 0) {
				em.persist(jeux); // attribut un id au jeu
			}else {
				Jeux jeu = jeuxBaseResult.get(0); // objet jeux de la liste, extrait le premier element de la base
				jeux.setId(jeu.getId());
			}
			System.out.println(jeux);
			
			
			transaction.commit();
			
		}
		
			// Lecture du fichier Banniere
			// Transforme les lignes en objets
			Path pathBanniere = Paths.get("C:\\Users\\Formation\\Documents\\workspace-spring-tool-suite-4-4.16.0.RELEASE\\projet-jpa-jo\\src\\main\\resources\\donnees\\wikipedia-iso-country-codes.csv");
			List<String> linesBanniere = Files.readAllLines(pathBanniere, StandardCharsets.UTF_8);
			// Pour ne pas prendre en compte les entêtes du fichier
			linesBanniere.remove(0);
			
			for (int j = 0; j < linesBanniere.size(); j++) {
				transaction.begin();
				
				// Attributs pour Banniere
				String[] tabA = linesBanniere.get(j).split(";");
				String cioCode = tabA[0];
				String nomBanniere = tabA[1];
				String statut = tabA[4];
				
				// Insertion dans la table Banniere			
				Banniere banniere = new Banniere(cioCode, nomBanniere, statut);	
				TypedQuery<Banniere> queryBanniereBase = em.createQuery("SELECT c FROM Banniere c WHERE c.cioCode = :cioCode", Banniere.class);
				queryBanniereBase.setParameter("cioCode", banniere.getCioCode());
				List<Banniere>banniereBaseResult = queryBanniereBase.getResultList();
				if (banniereBaseResult.size() == 0) {
					em.persist(banniere);
				}else {
					Banniere banniereA = banniereBaseResult.get(0); // objet banniere de la liste, extrait le premier element de la base
					banniere.setId(banniereA.getId());
				}
				System.out.println(banniere);
				
				// Attributs pour TraductionBanniereFr
				String codeLangueFr = "FR";
				String traductionBanniereFr = tabA[1];
				
				// Insertion des traduction FR dans la table TraductionBanniere			
				TraductionBanniere tradBanniereFr = new TraductionBanniere(codeLangueFr, traductionBanniereFr, banniere);
				TypedQuery<TraductionBanniere> queryTraductionBanniereFr = em.createQuery("SELECT t FROM TraductionBanniere t WHERE t.traductionBanniere = :traductionBanniere AND t.banniere = :banniere", TraductionBanniere.class);
				queryTraductionBanniereFr.setParameter("traductionBanniere", tradBanniereFr.getTraductionBanniere());
				queryTraductionBanniereFr.setParameter("banniere", tradBanniereFr.getBanniere());
				List<TraductionBanniere>traductionBanniereFrBaseResult = queryTraductionBanniereFr.getResultList();
				if (traductionBanniereFrBaseResult.size() == 0) {
					em.persist(tradBanniereFr);
				}else {
					TraductionBanniere traductionA = traductionBanniereFrBaseResult.get(0); // objet banniere de la liste, extrait le premier element de la base
					tradBanniereFr.setCodeLangue(traductionA.getCodeLangue());
				}
				System.out.println(tradBanniereFr);
				
				// Attributs pour TraductionBanniereEn
				String codeLangueEn = "EN";
				String traductionBanniereEn = tabA[2];
				
				// Insertion des traduction EN dans la table TraductionBanniere
				TraductionBanniere tradBanniereEn = new TraductionBanniere(codeLangueEn, traductionBanniereEn, banniere);
				TypedQuery<TraductionBanniere> queryTraductionBanniereEn = em.createQuery("SELECT t FROM TraductionBanniere t WHERE t.traductionBanniere = :traductionBanniere AND t.banniere = :banniere", TraductionBanniere.class);
				queryTraductionBanniereEn.setParameter("traductionBanniere", tradBanniereEn.getTraductionBanniere());
				queryTraductionBanniereEn.setParameter("banniere", tradBanniereEn.getBanniere());
				List<TraductionBanniere>traductionBanniereEnBaseResult = queryTraductionBanniereEn.getResultList();
				if (traductionBanniereEnBaseResult.size() == 0) {
					em.persist(tradBanniereEn);
				}else {
					TraductionBanniere traductionB = traductionBanniereEnBaseResult.get(0); // objet banniere de la liste, extrait le premier element de la base
					tradBanniereEn.setCodeLangue(traductionB.getCodeLangue());
				}
				System.out.println(tradBanniereEn);
				
				
				transaction.commit();
		}
			
			
			// Lecture du fichier Sport
			// Transforme les lignes en objets
			Path pathSport = Paths.get("C:\\Users\\Formation\\Documents\\workspace-spring-tool-suite-4-4.16.0.RELEASE\\projet-jpa-jo\\src\\main\\resources\\donnees\\liste_des_sports.csv");
			List<String> linesSport = Files.readAllLines(pathSport, StandardCharsets.UTF_8);
			// Pour ne pas prendre en compte les entêtes du fichier
			linesSport.remove(0);
			
			for (int k = 0; k < linesSport.size(); k++) {
				transaction.begin();
				
				// Attributs pour Sport
				String[] tabB = linesSport.get(k).split(";");
				String nomSport = tabB[1];
				
				// Insertion dans la table Sport
				Sport sport = new Sport(nomSport);
				TypedQuery<Sport> querySportBase = em.createQuery("SELECT s FROM Sport s WHERE s.nom= :nom", Sport.class);
				querySportBase.setParameter("nom", sport.getNom());
				// récupere le resultat de la requete et le stock dans sportBaseResult
				List<Sport>sportBaseResult = querySportBase.getResultList();
				if (sportBaseResult.size() == 0) {
					em.persist(sport);
				}else {
					Sport sportA = sportBaseResult.get(0); // objet sport de la liste, extrait le premier element de la base
					sport.setId(sportA.getId());
				}
				System.out.println(sport);
				
				// Attributs pour TraductionSportFr
				String codeLangueSportFr = "FR";
				String traductionSportFr = tabB[1];
				
				// Insertion des traduction FR dans la table TraductionSport		
				TraductionSport tradSportFr = new TraductionSport(codeLangueSportFr, traductionSportFr, sport);			
				TypedQuery<TraductionSport> queryTraductionSportFr = em.createQuery("SELECT t FROM TraductionSport t WHERE t.traductionSport = :traductionSport AND t.sport = :sport", TraductionSport.class);
				queryTraductionSportFr.setParameter("traductionSport", tradSportFr.getTraductionSport());
				queryTraductionSportFr.setParameter("sport", tradSportFr.getSport());
				List<TraductionSport>traductionSportFrBaseResult = queryTraductionSportFr.getResultList();
				if (traductionSportFrBaseResult.size() == 0) {
					em.persist(tradSportFr);
				}else {
					TraductionSport traductionSportA = traductionSportFrBaseResult.get(0); // objet banniere de la liste, extrait le premier element de la base
					tradSportFr.setCodeLangue(traductionSportA.getCodeLangue());
				}
				System.out.println(tradSportFr);
				
				// Attributs pour TraductionSportEn
				String codeLangueSportEn = "EN";
				String traductionSportEn = tabB[0];
				
				// Insertion des traduction EN dans la table TraductionBanniere
				TraductionSport tradSportEn = new TraductionSport(codeLangueSportEn, traductionSportEn, sport);			
				TypedQuery<TraductionSport> queryTraductionSportEn = em.createQuery("SELECT t FROM TraductionSport t WHERE t.traductionSport = :traductionSport AND t.sport = :sport", TraductionSport.class);
				queryTraductionSportEn.setParameter("traductionSport", tradSportEn.getTraductionSport());
				queryTraductionSportEn.setParameter("sport", tradSportEn.getSport());
				List<TraductionSport>traductionSportEnBaseResult = queryTraductionSportEn.getResultList();
				if (traductionSportEnBaseResult.size() == 0) {
					em.persist(tradSportEn);
				}else {
					TraductionSport traductionSportB = traductionSportEnBaseResult.get(0); // objet banniere de la liste, extrait le premier element de la base
					tradSportEn.setCodeLangue(traductionSportB.getCodeLangue());
				}
				System.out.println(tradSportEn);
				
				
				transaction.commit();
		}
		
	}

	
}
