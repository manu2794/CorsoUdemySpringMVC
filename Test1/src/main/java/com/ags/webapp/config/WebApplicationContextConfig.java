package com.ags.webapp.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/*Questa classe conterrà tutte le config necessarie a far funzionare il nostro
 * DispatcherServlet
 * 1) Implementare il WebMvcConfigurer 
 * 2) Inserimento di 3 importanti notazioni:
 * 	- @Configuration --> Identifica questa classe all'interno del framework come una classe di configurazione
 * 	- @EnableWebMvc --> Abilita le funzionalità dello SpringMvc
 * 	- @ComponentScan --> In cui abbiamo impostato come package di riferimento il com.ags.webapp
 * 
 *  Il compito del DispatcherServlet è quello di identificare i controller che dovranno gestire le chiamate.
 *  Per fare ciò il Dispatcher deve sapere dove cercare le classi controller, in questo caso abbiamo detto
 *  che saranno nel package com.ags.webapp*/
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.xantrix.webapp")
public class WebApplicationContextConfig implements WebMvcConfigurer
{
	
	/* Il ViewResolver è l'elemento che trasforma i dati grezzi ottenuti dal controller in pagine
	 * col formato HTML, CSS e JS che verranno restituiti al browser client*/
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		
		/*L'elemento più importante di questa clase di config è rappresentato
		 * dall'identificazione del prefisso e suffisso dei file che poi creeranno
		 * le pagine HTML 
		 * 
		 * WEB-INF/view --> cartelle in cui saranno i file*/ 
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");

		return resolver;
	}
	
	
//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry)
//	{
//		TilesViewResolver viewResolver = new TilesViewResolver();
//		registry.viewResolver(viewResolver);
//	}
	
	
	/* Gestione elementi statici del progetto che avverrà tramite la classe 
	 * configureDefaultServletHandling */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
	{
		configurer.enable();
	}
}
