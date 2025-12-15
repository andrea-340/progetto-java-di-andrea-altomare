package util;

import model.Capo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CapoDataLoader {
    public List<Capo> caricaCapi(String nomeFile) throws Exception {
        List<Capo> capi = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(nomeFile)))) {
            String linea = br.readLine(); 
            while ((linea = br.readLine()) != null) {
                String[] campi = linea.split(";");
                if (campi.length >= 7) {
                    Capo c = new Capo();
                    c.setId(campi[0].trim());
                    c.setDataInserimento(campi[1].trim());
                    c.setTipologia(campi[2].trim());
                    c.setPrezzo(Double.parseDouble(campi[3].trim()));
                    c.setStock(Integer.parseInt(campi[4].trim()));
                    c.setTaglia(campi[5].trim());
                    c.setMarca(campi[6].trim());
                    capi.add(c);
                }
            }
        } catch (Exception e) {
            throw new Exception("Errore caricamento file " + nomeFile, e);
        }
        return capi;
    }
}

