package com.ags.webapp.repository;

import java.util.List;

import com.ags.webapp.domain.Articoli;

/* Contiene i metodi di base che ci permetteranno di
 * selezionare gli articoli dal DB */
public interface ArticoliRepository {
	
	// Selezione articoli
	List <Articoli> SelArticoli();
	
	// Selezione articoli secondo un certo filtro
	List <Articoli> SelArticoliByFilter(String filtro);
	
	// Selezione articolo in base al codice
	Articoli SelArticoliByCodArt(String CodArt);
	
	// Inserimento articolo
	void InsArticolo(Articoli articolo);
	
	// Delete articolo
	void DelArticolo(String CodArt);
}
;