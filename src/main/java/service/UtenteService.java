package service;

import model.Utente;
import java.util.List;

public class UtenteService {
    private List<Utente> utenti;

    public void setUtenti(List<Utente> utenti) {
        this.utenti = utenti;
    }

    public Utente getUtenteById(String idUtente) {
        return utenti.stream()
                     .filter(u -> u.getId().equals(idUtente))
                     .findFirst()
                     .orElse(null);
    }
    
    public void aggiungiUtente(Utente utente) { 
        this.utenti.add(utente);
        System.out.println("✅ Utente registrato correttamente: " + utente.getNome() + " " + utente.getCognome());
    }
}
