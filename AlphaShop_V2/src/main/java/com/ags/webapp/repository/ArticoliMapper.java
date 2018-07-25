package com.ags.webapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ags.webapp.domain.Articoli;

/* Classe che mapperà quanto ottenuto dalle query
 * con la classe di dominio che abbiamo predisposto
 * (Articoli) */
public class ArticoliMapper implements RowMapper<Articoli>{
	
	/* Inseriamo il metodo che ci permette di mappare quanto ottenuto
	 * dalle query con la classe Articoli 
	 * 
	 * Parametri: RecordSet e NumeroRiga*/
	public Articoli mapRow(ResultSet row, int rowNum) throws SQLException
	{
		Articoli articoli = new Articoli();
		
		 try
		 {
			articoli.setRiga(row.getInt("RIGA"));  
			articoli.setCodArt(row.getString("CODART").trim());
			articoli.setDescrizione(row.getString("DESCRIZIONE").trim());
			articoli.setPrezzo(row.getDouble("PREZZO"));
			articoli.setUm(row.getString("UM"));
			articoli.setCodStat(row.getString("CODSTAT").trim()); 
			articoli.setPzCart(row.getInt("PZCART"));
			articoli.setPesoNetto(row.getDouble("PESONETTO"));
			articoli.setIdIva(row.getInt("IDIVA"));
			articoli.setQtaMag(row.getFloat("QTAMAG"));  
			articoli.setIdStatoArt(row.getString("IDSTATOART").trim());
			articoli.setIdFamAss(row.getInt("IDFAMASS"));
			articoli.setDesFamAss(row.getString("FAMASS").trim());
			articoli.setDataCreaz(row.getDate("DATACREAZIONE"));
			articoli.setPrezzoKg(row.getDouble("PRZKG"));
			
		 }
		 catch (Exception ex)
		 {
			 System.out.println("Errore in ArticoliMapper.mapRow: " + ex);
		 }
		
 
		return articoli;
	}
}