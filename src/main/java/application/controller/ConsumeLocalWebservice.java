package application.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import application.models.Livre;

@Controller
public class ConsumeLocalWebservice {

	@Value("${webservice.gas.allbooks}")
	public String url2;

	@RequestMapping(path = "/sam/test")
	public List<Livre> getBooks() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Livre[]> responseEntity = restTemplate.getForEntity(url2, Livre[].class);
		Livre[] objects = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
		System.out.println(url2);
		// for (Livre l : objects) {
		// System.out.println(l.getTitre());
		// }

		return Arrays.asList(objects);
	}

	@RequestMapping(path = "/sam/index")
	public String index(ModelMap model) {
		List<Livre> livres = getBooks();
		model.addAttribute("livres", livres);
		return "index2";
	}

}
