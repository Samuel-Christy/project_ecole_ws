package application.models;

public class RemoteLivre {

	private int ref_livre;

	/**
	 * 
	 * @return ref_livre
	 */
	public int getRef_livre() {
		return ref_livre;
	}

	/**
	 * 
	 * @param ref_livre the ref_livre to set
	 */
	public void setRef_livre(int ref_livre) {
		this.ref_livre = ref_livre;
	}

	private String titre_livre, editeur_livre, nom_auteur;
	private String annee_livre;

	/**
	 * 
	 * @return titre_livre
	 */
	public String getTitre_livre() {
		return titre_livre;
	}

	/**
	 * 
	 * @param titre_livre the titre_livre to set
	 */
	public void setTitre_livre(String titre_livre) {
		this.titre_livre = titre_livre;
	}

	/**
	 * 
	 * @return editeur_livre
	 */
	public String getEditeur_livre() {
		return editeur_livre;
	}

	/**
	 * 
	 * @param editeur_livre the editeur_livre to set
	 */
	public void setEditeur_livre(String editeur_livre) {
		this.editeur_livre = editeur_livre;
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
	 * @return annee_livre
	 */
	public String getAnnee_livre() {
		return annee_livre;
	}

	/**
	 * 
	 * @param annee_livre the annee_livre to set
	 */
	public void setAnnee_livre(String annee_livre) {
		this.annee_livre = annee_livre;
	}

}