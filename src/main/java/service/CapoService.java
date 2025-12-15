package service;

import model.Capo;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CapoService {
    private List<Capo> capi;

    public CapoService() { capi = new ArrayList<>(); }
    public void setCapi(List<Capo> capi) { this.capi = capi; }
    public List<Capo> getCapi() { return capi; }

    public void visualizzaTuttiICapi() {
        if (capi.isEmpty()) {
            System.out.println("Nessun capo disponibile.");
            return;
        }
        System.out.println("ID | Data | Tipologia | Marca | Taglia | Prezzo | Stock");
        for (Capo c : capi) {
            System.out.printf("%s | %s | %s | %s | %s | %.2f | %d\n",
                    c.getId(), c.getDataInserimento(), c.getTipologia(),
                    c.getMarca(), c.getTaglia(), c.getPrezzo(), c.getStock());
        }
    }

    public Capo getCapoById(String id) {
        for (Capo c : capi) {
            if (c.getId().equals(id)) return c;
        }
        return null;
    }

    public boolean controllaDisponibilita(Capo capo, int quantita) {
        return capo != null && capo.getStock() >= quantita;
    }

    public void aggiornaStock(Capo capo, int quantita) {
        if (capo != null) capo.setStock(capo.getStock() - quantita);
    }

    public void esportaCapiDisponibili(String fileName) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            pw.println("ID;Data_Inserimento;Tipologia;Marca;Taglia;Prezzo;Stock");
            for (Capo c : capi) {
                if (c.getStock() > 0) {
                    pw.printf("%s;%s;%s;%s;%s;%.2f;%d\n",
                            c.getId(), c.getDataInserimento(), c.getTipologia(),
                            c.getMarca(), c.getTaglia(), c.getPrezzo(), c.getStock());
                }
            }
            System.out.println("File esportato: " + fileName);
        } catch (IOException e) {
            System.err.println("Errore esportazione CSV: " + e.getMessage());
        }
    }
}
