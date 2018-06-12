package application.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.dao.LivreDAO;
import application.models.Livre;

@RestController
public class LivreController {

	@Autowired
	LivreDAO livreDAO;
	
	/**
	 * @return LivreDAO
	 */
	public LivreDAO getLivreDAO() {
		return livreDAO;
	}
	
	/**
	 * @params livreDAO the livreDAO to set
	 */
	public void setLivreDAO(LivreDAO livreDAO) {
		this.livreDAO = livreDAO;
	}

	
	
	/**
	 * Returns an List of Object Livre
	 * call method getAllLivres to LivreDAO who executed request Select* from database 
	 *  @return List<Livre>
	 */
	@RequestMapping(path = "${pathGetAllBooks}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Livre> getLivres() {
		//mapped to hostname:/ws/books
		ArrayList<Livre> livres = (ArrayList<Livre>) livreDAO.getAllLivres();

		return livres;
	}
	
	/**
	 * Verify if l exist on database
	 * delete l on database
	 * else @return Object Map<String,String>
	 * @params Livre id
	 * @return Object Livre 
	 */
	@GetMapping(path = "${pathBooksId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getLivre(@PathVariable("id") int n) {
		//mapped to hostname:/ws/books/{id}

		Livre l = livreDAO.getLivre(n);
		if (l != null) {
			livreDAO.deleteBook(l);
			return l;
		} else {
			// returns an error JSON.
			Map<String, String> r = new HashMap<String, String>();
			r.put("error", "not found");
			return r;
		}
	}

}
