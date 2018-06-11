package application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
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

	@RequestMapping("/ws/books")
	// return List<Livre>
	public List<Livre> getLivres(Model model) {

		ArrayList<Livre> livres = (ArrayList<Livre>) livreDAO.getAllLivres();
		for (int i = 0; i < livres.size(); i++) {	
		model.addAttribute("id",livres.get(i).getId());
		model.addAttribute("titre", livres.get(i).getTitre());
		model.addAttribute("annee", livres.get(i).getAnnee());
		model.addAttribute("nom_auteur", livres.get(i).getNom_auteur());
		model.addAttribute("prenom_auteur", livres.get(i).getPrenom_auteur());
		model.addAttribute("editeur", livres.get(i).getEditeur());
		
		}
		return livres;

	}

	@GetMapping(path = "ws/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Livre getLivre(@PathVariable("id") int n) {

		
		return livreDAO.getLivre(n);
	}

}
