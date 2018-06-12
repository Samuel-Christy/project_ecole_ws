package application.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import application.LivresTest;
import application.models.Livre;

public class LivreDAOTest {
	
	 @Autowired
	    private Livre livreDAO;
	     
	 @Test
	    @Transactional

	    public void testAddLivres()
	    {
//		 livreDAO livres= newlivreDAO();
//	     LivreDAO.addlivres(livres);
}
}
 