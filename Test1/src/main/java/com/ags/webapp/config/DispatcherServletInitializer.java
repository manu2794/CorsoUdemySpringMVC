package com.ags.webapp.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/* Gestisce l'inizializzazione del nostro DispatcherServlet*/
public class DispatcherServletInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer
{
	/* Identifica le classi che configureranno l'applicazione a livello
	 * di root; quindi che riguardano l'applicazione nel suo insieme */
	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		 return null;
	}

	/* Identifica quelle classi java nei quali saranno previste
	 * le configurazioni a livello di semplice contesto*/
	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		return new Class[]
		{ 
			WebApplicationContextConfig.class //creiamola
		};
	}

	/* Abbiamo impostato la mappatura delle chiamate che il DispatcherServlet gestirà;
	 * in questo caso qualunque chiamata provenga dall'esterno */
	@Override
	protected String[] getServletMappings()
	{
		return new String[]
		{ "/" };
	}
}

