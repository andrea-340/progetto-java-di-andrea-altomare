package app;

import model.Utente;
import service.UtenteService;
import service.CapoService;
import service.VenditaService;
import util.UtenteDataLoader;
import util.CapoDataLoader;
import util.VenditaDataLoader;

import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static UtenteService utenteService;
    private static CapoService capoService;
    private static VenditaService venditaService;

    public static void main(String[] args) {
        utenteService = new UtenteService();
        capoService = new CapoService();
        venditaService = new VenditaService(utenteService, capoService);

        try {
            utenteService.setUtenti(new UtenteDataLoader().caricaUtenti("utenti.csv"));
            capoService.setCapi(new CapoDataLoader().caricaCapi("capi.csv"));
            venditaService.setVendite(new VenditaDataLoader().caricaVendite("vendite.csv"));

            System.out.println("*** Dati caricati con successo ***");
            mostraMenuPrincipale();

        } catch (Exception e) {
            System.err.println("Errore fatale nel caricamento dei dati: " + e.getMessage());
        }
    }

    private static void mostraMenuPrincipale() {
        int scelta;
        do {
            System.out.println("\n## GESTIONE NEGOZIO LOOKBOOK");
            System.out.println("1. Visualizza tutti i capi");
            System.out.println("2. Comprare un capo");
            System.out.println("3. Restituire un capo");
            System.out.println("4. Aggiungi nuovo utente");
            System.out.println("5. Esporta prenotazioni disponibili");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Input non valido. Inserisci un numero.");
                scanner.nextLine();
            }
            scelta = scanner.nextInt();
            scanner.nextLine(); 

            switch (scelta) {
                case 1:
                    capoService.visualizzaTuttiICapi();
                    break;
                case 2:
                    System.out.print("ID Utente: ");
                    String idU = scanner.nextLine();
                    System.out.print("ID Capo: ");
                    String idC = scanner.nextLine();
                    System.out.print("Quantità: ");
                    int q = scanner.nextInt();
                    scanner.nextLine();
                    venditaService.registraVendita(idU, idC, q);
                    break;
                case 3:
                    System.out.print("ID Vendita: ");
                    String idV = scanner.nextLine();
                    System.out.print("Quantità restituita: ");
                    int qR = scanner.nextInt();
                    scanner.nextLine();
                    venditaService.eliminaVendita(idV, qR);
                    break;
                case 4:
                    System.out.print("ID Utente: "); String id = scanner.nextLine();
                    System.out.print("Nome: "); String nome = scanner.nextLine();
                    System.out.print("Cognome: "); String cognome = scanner.nextLine();
                    System.out.print("Data Nascita: "); String dn = scanner.nextLine();
                    System.out.print("Indirizzo: "); String indirizzo = scanner.nextLine();
                    System.out.print("Documento ID: "); String doc = scanner.nextLine();
                    utenteService.aggiungiUtente(new Utente(id, nome, cognome, dn, indirizzo, doc));
                    break;
                case 5:
                    System.out.print("Nome file esportazione: "); 
                    String f = scanner.nextLine();
                    capoService.esportaCapiDisponibili(f);
                    break;
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }

        } while (scelta != 0);
    }
}
