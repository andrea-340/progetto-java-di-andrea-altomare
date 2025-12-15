package util;

import model.Utente;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class UtenteDataLoader {
    
    public List<Utente> caricaUtenti(String nomeFile) throws Exception {
        
        List<Utente> utenti = new ArrayList<>();
        
        
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(nomeFile);
        
        if (is == null) {
           
            is = getClass().getResourceAsStream("/" + nomeFile);
            if (is == null) {
                 throw new Exception("Impossibile caricare il file " + nomeFile);
            }
        }
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            
            String riga;
            br.readLine(); 
            
            while ((riga = br.readLine()) != null) {
                
                String[] campi = riga.split(";");
                
                if (campi.length >= 6) {
                    Utente nuovoUtente = new Utente(
                        campi[0].trim(),  
                        campi[1].trim(),  
                        campi[2].trim(),  
                        campi[3].trim(),  
                        campi[4].trim(),  
                        campi[5].trim()  
                    );
                    utenti.add(nuovoUtente);
                }
            }
        } catch (IOException e) {
            throw new Exception("Errore durante la lettura del CSV degli utenti: " + e.getMessage());
        }
        
        return utenti;
    }
}