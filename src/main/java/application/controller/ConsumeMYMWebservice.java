package application.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import application.dao.LivreDAO;
import application.models.Livre;
import application.models.RemoteLivre;

@Controller

public class ConsumeMYMWebservice {

	@Value("${webservice.mym.allbooks}")
	private String url;
	@Value("${webservice.gas.allbooks}")
	private String url2;

	@Autowired
	LivreDAO livreDAO;

	public LivreDAO getLivreDAO() {
		return livreDAO;
	}

	public void setLivreDAO(LivreDAO livreDAO) {
		this.livreDAO = livreDAO;
	}

	private static List<RemoteLivre> lastRequest;

	private List<RemoteLivre> getRemoteBooks() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<RemoteLivre[]> responseEntity = restTemplate.getForEntity(url, RemoteLivre[].class);
		RemoteLivre[] objects = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		// System.out.println(url);
		// for (Livre l : objects) {
		// System.out.println(l.getTitre());
		// }

		lastRequest = Arrays.asList(objects);
		return lastRequest;
	}

	public List<Livre> getLocalBooks() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Livre[]> responseEntity = restTemplate.getForEntity(url2, Livre[].class);
		Livre[] objects = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		// System.out.println(url2);
		// for (Livre l : objects) {
		// System.out.println(l.getTitre());
		// }

		return Arrays.asList(objects);
	}

	private RemoteLivre getBook(int id) {
		if (lastRequest != null)
			for (RemoteLivre remoteLivre : lastRequest) {
				if (remoteLivre.getRef_livre() == id)
					return remoteLivre;
			}
		return null;
	}

	@RequestMapping(path = "/mym")
	public String index(ModelMap model) {
		List<RemoteLivre> remoteLivres = getRemoteBooks();
		List<Livre> localLivres = getLocalBooks();

		model.addAttribute("remote_livres", remoteLivres);
		model.addAttribute("local_livres", localLivres);
		return "index_remote";
	}

	@RequestMapping(path = "/mym/{id}")
	public String index2(@PathVariable(name = "id") int id) {
		System.out.println(id);
		RemoteLivre remote = getBook(id);
		// System.out.println("ConsumeMYMWebservice.index2()");
		if (remote != null) {
			// System.out.println("ConsumeMYMWebservice.index2()remote != null");
			try {
				Livre local = new Livre();
				local.setTitre(remote.getTitre_livre());
				local.setEditeur(remote.getEditeur_livre());

				// special cases, publication date is not always an integer :

				try {
					local.setAnnee(Integer.parseInt(remote.getAnnee_livre()));

				} catch (Exception e) {
					// TODO: handle exception
					local.setAnnee(-1);
				}
				// System.out.println("ConsumeMYMWebservice.index2()remote != null ->
				// parseInt");
				// author's firstname and lastname are mixed in one field

				if (remote.getNom_auteur() != null) {
					String[] noms = remote.getNom_auteur().split(" ");
					if (noms.length > 0) {
						local.setNom_auteur("");
						for (int i = 0; i < noms.length; i++) {
							if (i == 0)
								local.setPrenom_auteur(noms[i]);
							else
								local.setNom_auteur(local.getNom_auteur() + " " + noms[i]);
						}
					}
				}

				// todo : delete remote
				livreDAO.insertBook(local);
				RestTemplate restTemplate = new RestTemplate();
				restTemplate.delete(url + "/" + id);

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		return "redirect:/mym";
	}

}
