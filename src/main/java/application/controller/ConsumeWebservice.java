package application.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import application.models.Livre;

@Controller
public class ConsumeWebservice {

	private static final String URL = "http://127.0.0.1:10000/ws/books";

	@RequestMapping(path = "/sam/test")
	public List<Livre> getCampaigns() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Livre[]> responseEntity = restTemplate.getForEntity(URL, Livre[].class);
		Livre[] objects = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();

		// for (Livre l : objects) {
		// System.out.println(l.getTitre());
		// }

		return Arrays.asList(objects);
	}

	@RequestMapping(path = "/sam/index")
	public String index(ModelMap model) {
		List<Livre> livres = getCampaigns();
		model.addAttribute("livres", livres);
		return "index2";
	}

}
