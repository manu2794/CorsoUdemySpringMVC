package com.ags.webapp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ags.webapp.domain.Articoli;

/* Per far intendere a Spring che si tratta di una
 * classe Repository --> classe adibita ad interfacciarsi
 * con il DB centrale per la restituzione o la
 * manipolazione dei dati */
@Repository
public class ArticoliRepositoryImpl implements ArticoliRepository {

	/* Per gestire questi elementi con i metodi usiamo il JDBC
	 * che abbiamo configurato, autoistanziando il JDBC con
	 * Autowired */
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Articoli> SelArticoli() {
		String Sql = "SELECT * FROM ARTICOLI";
		
		List<Articoli> articoli = jdbcTemplate.query(Sql, new ArticoliMapper());
		
		return articoli;
	}

	@Override
	public List<Articoli> SelArticoliByFilter(String filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articoli SelArticoliByCodArt(String CodArt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void InsArticolo(Articoli articolo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DelArticolo(String CodArt) {
		// TODO Auto-generated method stub
		
	}
}
