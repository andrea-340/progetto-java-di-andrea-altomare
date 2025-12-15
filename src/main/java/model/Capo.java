package model;

public class Capo {
    private String id;
    private String dataInserimento;
    private String tipologia;
    private String marca;
    private String taglia;
    private double prezzo;
    private int stock;

    public Capo() {}

    
    public String getId() { return id; }
    public String getDataInserimento() { return dataInserimento; }
    public String getTipologia() { return tipologia; }
    public String getMarca() { return marca; }
    public String getTaglia() { return taglia; }
    public double getPrezzo() { return prezzo; }
    public int getStock() { return stock; }

   
    public void setId(String id) { this.id = id; }
    public void setDataInserimento(String dataInserimento) { this.dataInserimento = dataInserimento; }
    public void setTipologia(String tipologia) { this.tipologia = tipologia; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setTaglia(String taglia) { this.taglia = taglia; }
    public void setPrezzo(double prezzo) { this.prezzo = prezzo; }
    public void setStock(int stock) { this.stock = stock; }
}
