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
	/**
	 * @see LivreDAO
	 */
	
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
	
	/**
	 * 
	 * @param model
	 * @return string url : http://127.0.0.1:10000/index
	 */
	@RequestMapping("/")
	public String index(Model model) {
		//mapped to hostname:/
		System.out.println("PageController.index()");
		ModelAndView mav = new ModelAndView("livres") ;
        List<Livre> livres = dao.getAllLivres();
        mav.addObject("livres", livres);  
        
		return "index";
	
	}
}
	
