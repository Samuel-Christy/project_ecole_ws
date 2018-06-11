package application.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

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

		

	}

}
