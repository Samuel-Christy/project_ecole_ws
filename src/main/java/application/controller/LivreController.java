package application.controller;

import java.util.ArrayList;
import java.util.List;

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

	public LivreDAO getLivreDAO() {
		return livreDAO;
	}

	public void setLivreDAO(LivreDAO livreDAO) {
		this.livreDAO = livreDAO;
	}

	@RequestMapping(path = "ws/books", produces = MediaType.APPLICATION_JSON_VALUE)
	
	// return List<Livre>
	public List<Livre> getLivres() {
		
		ArrayList<Livre> livres = (ArrayList<Livre>) livreDAO.getAllLivres();

		return livres;

	}
	//delete on database 
	@GetMapping(path = "ws/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getLivre(@PathVariable("id") int n) {

		Livre l = livreDAO.getLivre(n);
		if (l != null) {
			livreDAO.deleteBook(l);
			return l;
		} else {
			return new String[] { "error", "not found" };
		}
	}

}
