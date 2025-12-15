package model;

import java.time.LocalDate;

public class Vendita {
    private String idVendita;
    private String idCapo;
    private String idUtente;
    private int quantita;
    private double prezzoTotale;
    private String dataVendita;

    public Vendita(String idVendita, String idCapo, String idUtente, int quantita) {
        this.idVendita = idVendita;
        this.idCapo = idCapo;
        this.idUtente = idUtente;
        this.quantita = quantita;
        this.prezzoTotale = 0.0;
        this.dataVendita = LocalDate.now().toString();
    }

    public String getId() { return idVendita; }
    public String getCapoId() { return idCapo; }
    public String getUtenteId() { return idUtente; }
    public int getQuantita() { return quantita; }
    public double getPrezzoTotale() { return prezzoTotale; }
    public String getDataVendita() { return dataVendita; }

    public void setPrezzoTotale(double prezzoTotale) { this.prezzoTotale = prezzoTotale; }
}
