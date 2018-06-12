package application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@SpringBootApplication
@Configuration
@ImportResource("classpath:spring.xml")
public class Application {

	@Value("${views:'erreur'}") // key:'defaultValue'
	private String viewsPrefix;
	
	@Value("${suffix}")//value:.jsp
	private String suffix;

	public static void main(String[] args) {
		AbstractApplicationContext ctxt = new FileSystemXmlApplicationContext("classpath:spring.xml");
		SpringApplication.run(Application.class, args);

	}

	@Bean
	public UrlBasedViewResolver getViewResolver() {
		System.err.println("...");
		// System.out.println(viewsPrefix);
		UrlBasedViewResolver v = new InternalResourceViewResolver();
		v.setPrefix(viewsPrefix);
		v.setSuffix(suffix);
		v.setViewClass(JstlView.class);
		return v;
	}

}
