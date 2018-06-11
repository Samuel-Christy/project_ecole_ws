package application.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import application.dao.LivreDAO;
import application.models.Livre;

@Controller
public class PageController {
	@Autowired
	LivreDAO dao;
	/**
	 * @return the dao
	 */
	public LivreDAO getDao() {
		return dao;
	}
	/**
	 * @param dao the dao to set
	 */
	public void setDao(LivreDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		
		System.out.println("PageController.index()");
		ModelAndView mav = new ModelAndView("livres") ;
        List<Livre> livres = dao.getAllLivres();
        mav.addObject("livres", livres);  
        
		
		for (int i = 0; i < getDao().getAllLivres().size(); i++) {
		model.addAttribute("id",getDao().getAllLivres().get(i).getId() );
		model.addAttribute("titre", getDao().getAllLivres().get(i).getTitre());
		model.addAttribute("annee", getDao().getAllLivres().get(i).getAnnee());
		model.addAttribute("nom_auteur",getDao().getAllLivres().get(i).getNom_auteur());
		model.addAttribute("prenom_auteur", getDao().getAllLivres().get(i).getPrenom_auteur());
		model.addAttribute("editeur", getDao().getAllLivres().get(i).getEditeur());
		}
		
		return "index";
	
	}
}
	
