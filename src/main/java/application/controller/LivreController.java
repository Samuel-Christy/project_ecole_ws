package application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.models.Livre;

@RestController
public class LivreController {
	
	@RequestMapping("ws/book")
	 public List<Livre> getLivres()
	 {
		 //@Request Select ALL BDD 
		 List<Livre> list=new ArrayList<Livre>();
		 list.add(new Livre());
		 list.add(new Livre());
		 list.add(new Livre());
		 list.add(new Livre());
		 list.add(new Livre());

		 
		 //return List<Livre>
		 return getLivres();
	 }

	@RequestMapping(path="ws/books/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	 public Livre getLivre(@PathVariable("id")int n) {
	 
			//@request INSERT (id,titre,annee,prenomAuteur,nomAuteur,editeur)
		 return getLivres().get(n);
	 }
}
