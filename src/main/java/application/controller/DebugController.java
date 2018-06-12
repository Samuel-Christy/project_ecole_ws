package application.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import application.dao.LivreDAO;

@RestController
public class DebugController {
	
	@Value("${DBreset}")
	private String databaseReset;
	
	@Value("${DBfeed}")
	private String databaseFeed;
	
	@Value("${DBnumber}")
	private String databaseNumber;
	
	
	@Autowired
	LivreDAO livreDAO;

	public LivreDAO getLivreDAO() {
		return livreDAO;
	}

	public void setLivreDAO(LivreDAO livreDAO) {
		this.livreDAO = livreDAO;
	}

	@GetMapping(path = "${pathInitDatabase}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object feedDatabase() {
		livreDAO.feed();
		Map<String, String> r = new HashMap<String, String>();
		r.put(databaseReset, "" + true);
		r.put(databaseFeed, "" + true);
		r.put(databaseNumber, "" + livreDAO.getAllLivres().size());

		return r;
	};

}
