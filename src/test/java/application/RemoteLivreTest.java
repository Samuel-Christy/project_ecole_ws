package application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import application.models.RemoteLivre;

public class RemoteLivreTest {
	@Test
	public void testGetTitreLivre() {
		 RemoteLivre livre = new RemoteLivre();
		livre.setTitre_livre("un tramway nommé désir");
		assertEquals("un tramway nommé désir", livre.getTitre_livre());
		livre.setTitre_livre("titre");
		
	}
	
	@Test
	public void testGetAnneeLivre() {
		RemoteLivre livre = new RemoteLivre();
		String annee = "1947";
		livre.setAnnee_livre(annee);
		assertEquals("1947", livre.getAnnee_livre());
		livre.setAnnee_livre(annee);
		    
}
	@Test
	public void testGetNom_Auteur() {
		RemoteLivre livre = new RemoteLivre();
		livre.setNom_auteur("Tenesse Williams ");
		assertTrue(livre.getNom_auteur().contains("Williams"));
//		assertEquals("Willimams", livre.getNom_auteur());
		livre.setNom_auteur("nom_auteur");
}
	
	@Test
	public void testGetEditeurLivre() {
		RemoteLivre livre = new RemoteLivre();
		livre.setEditeur_livre("livre de poche");
		assertTrue( livre.getEditeur_livre().contains("livre de poche"));
		livre.setEditeur_livre("editeur");
}
}
