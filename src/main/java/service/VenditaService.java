package service;

import model.Vendita;
import model.Capo;
import model.Utente;
import java.util.List;
import java.util.ArrayList;

public class VenditaService {
    private List<Vendita> vendite;
    private CapoService capoService;
    private UtenteService utenteService;

    public VenditaService(UtenteService utenteService, CapoService capoService) {
        this.vendite = new ArrayList<>();
        this.utenteService = utenteService;
        this.capoService = capoService;
    }

    public void setVendite(List<Vendita> vendite) { this.vendite = vendite; }
    public List<Vendita> getVendite() { return vendite; }

    public void registraVendita(String idUtente, String idCapo, int quantita) {
        Utente u = utenteService.getUtenteById(idUtente);
        Capo c = capoService.getCapoById(idCapo);
        if (u != null && c != null && capoService.controllaDisponibilita(c, quantita)) {
            String idVendita = "V" + (vendite.size() + 1);
            Vendita v = new Vendita(idVendita, idCapo, idUtente, quantita);
            v.setPrezzoTotale(c.getPrezzo() * quantita);
            capoService.aggiornaStock(c, quantita);
            vendite.add(v);
            System.out.println("Vendita registrata: " + idVendita);
        } else System.out.println("Errore: Utente o Capo non valido, oppure stock insufficiente.");
    }

    public void eliminaVendita(String idVendita, int quantitaResa) {
        Vendita v = vendite.stream().filter(x -> x.getId().equals(idVendita)).findFirst().orElse(null);
        if (v != null) {
            Capo c = capoService.getCapoById(v.getCapoId());
            if (c != null) c.setStock(c.getStock() + quantitaResa);
            vendite.remove(v);
            System.out.println("Vendita eliminata: " + idVendita);
        } else System.out.println("Vendita non trovata: " + idVendita);
    }
}
