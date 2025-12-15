package util;

import model.Vendita;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class VenditaDataLoader {

    public List<Vendita> caricaVendite(String nomeFile) throws Exception {
        List<Vendita> vendite = new ArrayList<>();

       
        InputStream is = getClass().getClassLoader().getResourceAsStream(nomeFile);
        if (is == null) {
            throw new Exception("File non trovato: " + nomeFile);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String linea;
            br.readLine(); 

            while ((linea = br.readLine()) != null) {
                String[] campi = linea.split(";");
                if (campi.length >= 4) { 
                    String idVendita = campi[0].trim();
                    String idCapo = campi[1].trim();
                    String idUtente = campi[2].trim();
                    int quantitaVenduta;

                    try {
                        quantitaVenduta = Integer.parseInt(campi[3].trim());
                    } catch (NumberFormatException e) {
                        System.err.println("Errore di formato nella quantità (" + campi[3] + ") riga: " + linea);
                        continue;
                    }

                    Vendita vendita = new Vendita(idVendita, idCapo, idUtente, quantitaVenduta);

                   
                    if (campi.length > 4) {
                        try {
                            vendita.setPrezzoTotale(Double.parseDouble(campi[4].trim()));
                        } catch (NumberFormatException e) {
                            vendita.setPrezzoTotale(0.0);
                        }
                    }

                    vendite.add(vendita);
                } else {
                    System.err.println("Riga malformata nel file vendite.csv: " + linea);
                }
            }

        } catch (Exception e) {
            throw new Exception("Errore durante la lettura del file " + nomeFile, e);
        }

        return vendite;
    }
}
