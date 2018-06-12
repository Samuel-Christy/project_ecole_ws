package application.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.github.javafaker.Faker;

import application.models.Livre;

public class LivreDAO {

	private NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * 
	 * @return the jdbcTemplate
	 */
	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * 
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void init() {

	}

	// feed the database :
	
	/**
	 * Create the database if not exists 
	 * if exist drop table and create a new table with 30 data on table
	 *
	 */
	public void feed() {
		String createDB = "CREATE TABLE IF NOT EXISTS livres ( `id` INTEGER PRIMARY KEY, `titre` TEXT, `annee` TEXT, `nom_auteur` TEXT, `prenom_auteur` TEXT, `editeur` TEXT);";
		jdbcTemplate.getJdbcOperations().execute("DROP TABLE IF EXISTS livres;");
		jdbcTemplate.getJdbcOperations().execute(createDB);

		Faker f = new Faker();
		Random r = new Random();

		for (int i = 0; i < 30; i++) {
			Livre l = new Livre();
			l.setId(0);
			l.setTitre(f.book().title());
			l.setEditeur(f.book().publisher());
			l.setNom_auteur(f.name().lastName());
			l.setPrenom_auteur(f.name().firstName());
			l.setAnnee(2018 - r.nextInt(2018 - 1492));
			insertBook(l);

		}
	}

	/**
	 * Add a new livre on database
	 * @param livre
	 */
	public void insertBook(Livre livre) {
		Map<String, String> etat1 = new HashMap<>();

		// etat1.put("id", "" + livre.getId());
		etat1.put("titre", livre.getTitre());
		etat1.put("annee", "" + livre.getAnnee());
		etat1.put("nom_auteur", livre.getNom_auteur());
		etat1.put("prenom_auteur", livre.getPrenom_auteur());
		etat1.put("editeur", livre.getEditeur()

		);

		jdbcTemplate.update(
				"insert INTO livres(titre,annee,nom_auteur,prenom_auteur,editeur) values(:titre,:annee,:nom_auteur,:prenom_auteur,:editeur)",
				etat1);

	}

	/**
	 * Delete a livre on database
	 * @param livre
	 */
	public void deleteBook(Livre livre) {
		Map<String, Integer> etat1 = new HashMap<>();
		etat1.put("id", livre.getId());
		jdbcTemplate.update("DELETE FROM livres WHERE id=:id", etat1);
	}

	/**
	 * Execute the SELECT * on database
	 * convert the result request to Livre object
	 * @return List<Livre>
	 */
	public List<Livre> getAllLivres() {

		String sql = "SELECT * FROM livres";

		List<Livre> livres = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Livre>(Livre.class));
		// System.err.println(livres);
		// for (Livre livre : livres) {
		// System.err.println(livre.getEditeur());
		// }
		return livres;

	}
		/**
		 * add the id to Map<String,Integer>
		 * Execute the request Select to select one livre with the @params id 
		 * try to convert the result request to Livre r 
		 * catch if request fail and Livre r are null
		 * convert the result request to Livre r
		 * 
		 * @param id
		 * @return Livre
		 */
	public Livre getLivre(int id) {
		Map<String, Integer> etat = new HashMap<>();
		Livre r;
		String sql = "SELECT * FROM livres where id LIKE :id";

		etat.put("id", id);
		try {
			r = jdbcTemplate.queryForObject(sql, etat, new BeanPropertyRowMapper<Livre>(Livre.class));
		} catch (Exception e) {
			r = null;
		}

		return r;
	}

}
