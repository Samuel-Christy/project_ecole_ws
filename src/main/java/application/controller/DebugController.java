package application.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import application.dao.LivreDAO;

@RestController
public class DebugController {

	@Autowired
	LivreDAO livreDAO;

	public LivreDAO getLivreDAO() {
		return livreDAO;
	}

	public void setLivreDAO(LivreDAO livreDAO) {
		this.livreDAO = livreDAO;
	}

	@GetMapping(path = "/debug/init_database", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object feedDatabase() {
		livreDAO.feed();
		Map<String, String> r = new HashMap<String, String>();
		r.put("database_reset", "" + true);
		r.put("database_feed", "" + true);
		r.put("number_of_record", "" + livreDAO.getAllLivres().size());

		return r;
	};

}
