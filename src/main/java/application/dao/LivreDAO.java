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

	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void init() {

		String createDB = "CREATE TABLE IF NOT EXISTS livres ( `id` INTEGER PRIMARY KEY, `titre` TEXT, `annee` TEXT, `nom_auteur` TEXT, `prenom_auteur` TEXT, `editeur` TEXT);";
		jdbcTemplate.getJdbcOperations().execute("DROP TABLE IF EXISTS etat;");
		jdbcTemplate.getJdbcOperations().execute(createDB);

		Faker f = new Faker();
		Random r = new Random();

		if (getAllLivres().size() == 0) {

			for (int i = 0; i < 100; i++) {
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

		// feed the database :

	}

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

	public void deleteBook(Livre livre) {
		Map<String, Integer> etat1 = new HashMap<>();
		etat1.put("id", livre.getId());
		jdbcTemplate.update("DELETE FROM livres WHERE id=:id", etat1);
	}

	public List<Livre> getAllLivres() {

		String sql = "SELECT * FROM livres";

		List<Livre> livres = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Livre>(Livre.class));
		// System.err.println(livres);
		// for (Livre livre : livres) {
		// System.err.println(livre.getEditeur());
		// }
		return livres;

	}

	public Livre getLivre(int id) {
		Map<String, Integer> etat = new HashMap<>();

		String sql = "SELECT * FROM livres where id LIKE :id";

		etat.put("id", id);
		Livre r = jdbcTemplate.queryForObject(sql, etat, new BeanPropertyRowMapper<Livre>(Livre.class));
		System.out.println(r);
		return r;
	}

}
