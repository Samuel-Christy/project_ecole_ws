package application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.dao.LivreDAO;
import application.models.Livre;

@RestController
public class LivreController {
	
	
	@RequestMapping("ws/books")
	//return List<Livre>
	 public List<Livre> getLivres()
	 {
		LivreDAO dao=new LivreDAO();
		 return dao.getAllLivres();
	 }

	@GetMapping(path="ws/books/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	 public Livre getLivre(@PathVariable("id")int n) {
	 
			//@request INSERT (id,titre,annee,prenomAuteur,nomAuteur,editeur)
		 return getLivres().get(n);
	 }
	
	
}
