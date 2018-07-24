package com.ags.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/* @Controller --> Identifica la classe come una classe di
 * tipo Controller, quindi adibita alla gestione delle chiamate
 * del browser */
@Controller
@RequestMapping("/")
public class IndexController
{
	
	/* Metodo che gestirā le chiamate della pagina index,
	 * al quale passeremo il parametro Model, sul quale
	 * attribuiremo 2 variabili String */
	
	/* @RequestMapping --> Gestirā la chiamata che riguarda il path "index"
	 *  ovvero, dove nell'indirizzo di chiamata del browser avremo "index"
	 *  come richiesta di risorsa interverrā l'IndexController, attribuendo
	 *  le due variabili al modello e restituendo la vista "index" */
	@RequestMapping(value = "/index")
	public String getWelcome(Model model)
	{
		model.addAttribute("intestazione", "Benvenuti nel sito Alpha Shop");
		model.addAttribute("saluti", "Accedi o registrati per acquistare i tuoi prodotti");
		
		/* Restiuiamo il modello chiamato "index", che rappresenterā
		 * il nome della pagina JSP che assemblerā quanto abbiamo
		 * passato in un formato compatibile compatibile con il 
		 * browser di chiamata */
		return "index";
	}
	
}
