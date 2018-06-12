package application;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import application.models.Livre;
public class LivresTest<MockMvc> {
  

	@Test
	public void testGetTitre() {
		 Livre livre = new Livre();
		livre.setTitre("un tramway nommé désir");
		assertEquals("un tramway nommé désir", livre.getTitre());
		livre.setTitre("titre");
		
	}
	
	@Test
	public void testGetAnnee() {
		 Livre livre = new Livre();
		int annee = 1947;
		livre.setAnnee(annee);
		assertEquals(1947, livre.getAnnee());
		livre.setAnnee (annee);
		    
}
	@Test
	public void testGetNom_Auteur() {
		 Livre livre = new Livre();
		livre.setNom_auteur("Williams");
		assertTrue(livre.getNom_auteur().contains("Williams"));
//		assertEquals("Willimams", livre.getNom_auteur());
		livre.setNom_auteur("nom_auteur");
}
	@Test
	public void testGetPrenom_Auteur() {
		 Livre livre = new Livre();
		livre.setPrenom_auteur("Tenessee");
		assertTrue( livre.getPrenom_auteur().contains("Tenessee"));
		livre.setPrenom_auteur("prenom_auteur");
}
	@Test
	public void testGetEditeur() {
		 Livre livre = new Livre();
		livre.setEditeur("livre de poche");
		assertTrue( livre.getEditeur().contains("livre de poche"));
		livre.setEditeur("editeur");
}
	}