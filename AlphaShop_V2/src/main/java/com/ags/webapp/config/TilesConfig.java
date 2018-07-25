package com.ags.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

/* Identifica la classe come una classe di configurazione */
@Configuration
public class TilesConfig
{
	/* il bean ci permette di attivare la configurazione per tiles */
	@Bean
	public TilesConfigurer tilesConfigurer()
	{
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		//specifichiamo il file di config tiles.xml
		tilesConfigurer.setDefinitions("/WEB-INF/layouts/definitions/tiles.xml");
		tilesConfigurer.setCheckRefresh(true);

		return tilesConfigurer;
	}
}
