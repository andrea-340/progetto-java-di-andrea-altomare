# progetto-java-di-andrea-altomare
Perfetto! Posso aiutarti a scrivere un README completo e ben strutturato per il tuo progetto **LookBook App**, includendo tutte le sezioni richieste dall’esame e spiegazioni utili sulle risorse, Maven, Git e JAR. Ecco un esempio pronto da usare:

---

# LookBook App

**Versione:** 1.0-SNAPSHOT
**Autore:** Andrea Altomare

---

## Descrizione del progetto

LookBook App è un’applicazione Java per la gestione di un piccolo negozio di abbigliamento tramite interfaccia a riga di comando (CLI).
Il progetto consente di:

* Visualizzare tutti i capi disponibili in magazzino.
* Comprare un capo esistente tramite ID capo e ID utente.
* Restituire un capo tramite ID vendita.
* Aggiungere nuovi utenti con tutti i dati richiesti.
* Esportare un file CSV con le prenotazioni disponibili.
* Uscire dal programma in qualsiasi momento.

Il progetto utilizza **Apache Maven** per la gestione delle dipendenze e la build, e permette di generare un file **JAR eseguibile**.

---

## Struttura del progetto

```
lookbook-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── app/           # Classe principale App.java
│   │   │   ├── model/         # Classi modello: Capo.java, Utente.java, Vendita.java
│   │   │   ├── service/       # Classi di servizio: CapoService.java, UtenteService.java, VenditaService.java
│   │   │   └── util/          # Loader per file CSV: CapoDataLoader.java, UtenteDataLoader.java, VenditaDataLoader.java
│   │   └── resources/         # File CSV: utenti.csv, capi.csv, vendite.csv
├── target/                     # Cartella build Maven
└── pom.xml                     # File di configurazione Maven
```

---

## Requisiti del progetto

1. **Caricamento automatico dei file CSV**
   I file `utenti.csv`, `capi.csv` e `vendite.csv` vengono caricati automaticamente all’avvio dell’applicazione.

2. **Gestione operazioni utente**
   Il menu principale consente all’utente di selezionare le operazioni disponibili:

   | Opzione | Funzione                                  |
   | ------- | ----------------------------------------- |
   | 1       | Visualizzare tutti i capi                 |
   | 2       | Comprare un capo esistente                |
   | 3       | Restituire un capo                        |
   | 4       | Aggiungere un nuovo utente                |
   | 5       | Esportare prenotazioni disponibili in CSV |
   | 0       | Uscire dall’applicazione                  |

3. **Dettagli funzionali principali**

   * **Comprare un capo:** l’utente inserisce `ID Capo`, `ID Utente` e quantità. Lo stock del capo viene aggiornato e viene generata una nuova vendita con ID univoco.
   * **Restituire un capo:** l’utente inserisce `ID Vendita` e quantità restituita. Lo stock del capo viene aggiornato e la vendita rimossa.
   * **Aggiungere utente:** l’utente inserisce tutti i dati richiesti (`ID`, `Nome`, `Cognome`, `Data di nascita`, `Indirizzo`, `Documento ID`). L’app conferma la registrazione.
   * **Esportazione prenotazioni:** genera un file CSV con i capi ancora disponibili (`ID, Data Inserimento, Tipologia, Marca, Taglia, Prezzo, Stock`).

---

## Come avviare l’applicazione

### 1. Prerequisiti

* Java JDK 17+
* Apache Maven 3.x
* Terminale / prompt dei comandi

### 2. Build del progetto

Dalla cartella principale del progetto, eseguire:

```bash
mvn clean package
```

### 3. Eseguire il file JAR

Dalla cartella `target`:

```bash
cd target
java -jar lookbook-app-1.0-SNAPSHOT-shaded.jar
```

L’app mostrerà il menu principale direttamente a terminale.

---

## Risorse utili

### Cos’è Apache Maven

* Maven è uno strumento di gestione di progetti Java e build automation.
* Permette di gestire dipendenze, versioni di librerie e plugin tramite un file **pom.xml**.
* Consente di creare JAR eseguibili e di separare le librerie dal progetto.

### Cos’è Git

* Git è un sistema di **controllo versione distribuito**, fondamentale per sviluppatori.
* Permette di creare **branch**, tracciare modifiche e collaborare su progetti complessi.
* Strumenti utili: [Git handbook](https://git-scm.com/book/it/v2), [Git Flow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow).

### Cos’è un file JAR

* JAR (Java Archive) raggruppa file `.class` e risorse in un singolo archivio.
* Permette compressione, protezione tramite firma digitale, portabilità e gestione delle versioni.
* I JAR possono essere eseguiti con:

```bash
java -jar nomefile.jar
```

---


* Tutti i dati vengono caricati dai CSV all’avvio. Assicurarsi che i file siano nella cartella `resources`.
* La gestione degli errori include controllo dello stock e verifica degli ID inseriti.
* L’app funziona interamente da terminale, senza interfaccia grafica.


