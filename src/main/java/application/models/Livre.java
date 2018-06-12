package application.models;

public class Livre {
	
	private int id, annee;
	private String titre, nom_auteur, prenom_auteur, editeur;

	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return annee
	 */
	public int getAnnee() {
		return annee;
	}

	/**
	 * 
	 * @param annee the annee to set
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}

	/**
	 * 
	 * @return titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * 
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * 
	 * @return nom_auteur
	 */
	public String getNom_auteur() {
		return nom_auteur;

	}

	/**
	 * 
	 * @param nom_auteur the nom_auteur to set
	 */
	public void setNom_auteur(String nom_auteur) {
		this.nom_auteur = nom_auteur;
	}
	
	/**
	 * 
	 * @return prenom_auteur
	 */
	public String getPrenom_auteur() {
		return prenom_auteur;
	}

	/**
	 * 
	 * @param prenom_auteur the prenom_auteur to set
	 */
	public void setPrenom_auteur(String prenom_auteur) {
		this.prenom_auteur = prenom_auteur;
	}

	
	/**
	 * 
	 * @return editeur
	 */
	public String getEditeur() {
		return editeur;
	}
	
	/**
	 * 
	 * @param editeur the editeur to set
	 */
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

}
