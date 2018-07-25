package com.ags.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/* @Controller --> Identifica la classe come una classe di
 * tipo Controller, quindi adibita alla gestione delle chiamate
 * del browser */
@Controller
/* Per far apparire sempre la pagina di benvenuto,
 * anche se non appare il path sull'url */
@RequestMapping("/")
public class IndexController
{
	
	/* Metodo che gestirà le chiamate della pagina index,
	 * al quale passeremo il parametro Model, sul quale
	 * attribuiremo 2 variabili String */
	
	/* Eliminiamo "/index" dal RequestMapping */
	@RequestMapping
	public String getWelcome(Model model)
	{
		model.addAttribute("intestazione", "Benvenuti nel sito Alpha Shop");
		model.addAttribute("saluti", "Accedi o registrati per acquistare i tuoi prodotti");
		
		/* Restiuiamo il modello chiamato "index", che rappresenterà
		 * il nome della pagina JSP che assemblerà quanto abbiamo
		 * passato in un formato compatibile compatibile con il 
		 * browser di chiamata */
		return "index";
	}
	
}
