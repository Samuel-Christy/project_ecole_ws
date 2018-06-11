package application.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivreController {
	
	@RequestMapping("ws/book")
	 public List<Livre> getLivres()
	 {
		 //@Request Select ALL BDD 
		 
		 //return List<Livre>
		 return getLivre();
	 }

	 @RequestMapping(path="/books/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	 public Livre getOccupation(@PathVariable("id")int n) {
	 
			//@request INSERT (id,titre,annee,prenomAuteur,nomAuteur,editeur)
		 return getLivre().get(n);
	 }
}
