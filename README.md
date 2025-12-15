

---

# LookBook - Gestione Negozio di Abbigliamento

**Autore:** Andrea Altomare
**Versione:** 1.0-SNAPSHOT
**Data:** 2025-12-15

---

## **📄 Descrizione del progetto
LookBook è un’applicazione Java per la gestione di un negozio di abbigliamento usato, sviluppata come progetto didattico. L’app permette di gestire facilmente gli utenti, il magazzino e le vendite di capi di seconda mano, fornendo strumenti sia per la gestione interna sia per le transazioni tra utenti.
Le funzionalità principali corrispondono al menu dell’app:
Visualizza tutti i capi: permette di vedere tutti i capi disponibili in magazzino, con dettagli su ID capo, tipologia, marca, taglia, prezzo e stock disponibile.
Comprare un capo: registra un acquisto inserendo ID utente, ID capo e quantità. L’app verifica lo stock e aggiorna automaticamente la disponibilità.
Restituire un capo: consente di restituire un capo precedentemente acquistato inserendo ID vendita e quantità restituita. Lo stock viene aggiornato di conseguenza.
Aggiungi nuovo utente: registra un nuovo utente fornendo ID, nome, cognome, data di nascita, indirizzo e documento ID. Al termine, appare il messaggio “Utente registrato correttamente”.
Esporta prenotazioni disponibili: genera un file CSV con i capi disponibili, includendo ID, data inserimento, tipologia, marca, taglia e prezzo.
Esci: chiude l’applicazione in modo sicuro.
L’applicazione è stata sviluppata utilizzando:
Java 17+, per sfruttare le funzionalità moderne del linguaggio.
Maven, per la gestione delle dipendenze e la build del progetto.
Programmazione ad oggetti, con separazione chiara tra modelli, servizi e logica applicativa.
Gestione delle eccezioni e validazione dell’input utente, per garantire robustezza del programma.
Lettura e scrittura di file CSV, per importare ed esportare dati in modo semplice e compatibile.
LookBook nasce con l’idea di facilitare la compravendita di abbigliamento usato, promuovendo un modello di consumo sostenibile e dando una seconda vita a capi di qualità dimenticati nell’armadio.

---

## **📂 Struttura del progetto**

```
progetto-java-di-andrea-altomare-main/
│
├─ pom.xml                       # Configurazione Maven
├─ README.md                      # Questo file
├─ src/
│   ├─ main/
│   │   ├─ java/
│   │   │   ├─ app/
│   │   │   │   └─ App.java
│   │   │   ├─ model/            # Classi Utente, Capo, Vendita
│   │   │   └─ service/          # Service per Utente, Capo, Vendita
│   │   └─ resources/            # File CSV
│   │       ├─ utenti.csv
│   │       ├─ capi.csv
│   │       └─ vendite.csv
```

---

## **⚙️ Compilazione ed esecuzione con Maven**

1. Apri il terminale nella cartella principale del progetto (dove si trova `pom.xml`).
2. Pulisci e compila il progetto:

```bash
mvn clean package
```

3. Se tutto è corretto, il JAR eseguibile sarà generato in:

```
cd target
```

4. Avvia il programma con:

```bash
java -jar lookbook-app-1.0-SNAPSHOT.jar
```

L’applicazione mostrerà il **menu principale**.

---

### Menu principale:

```
1. visualizza tutti i capi
2. comprare un capo
3. Restituire un capo
4. aggiungi nuovo utente
5. esporta prenotazioni disponibili
0. Esci
```

## **Guida all’utilizzo dell’applicazione LookBook**

---

### **Menu principale**

All’avvio dell’app, viene mostrato il menu principale:

```
1. visualizza tutti i capi
2. comprare un capo
3. Restituire un capo
4. aggiungi nuovo utente
5. esporta prenotazioni disponibili
0. Esci
```

---

### **1)Visualizza tutti i capi**

* Se selezioni **1**, puoi visualizzare tutti i capi presenti in magazzino.
* Verranno mostrati tutti i dettagli disponibili: ID capo, tipologia, marca, taglia, prezzo, stock disponibile.
* **Scopo:** sapere quali capi sono disponibili prima di registrarne la vendita.

---

### **2)comprare un capo**

1. Scegli l’opzione **2 comprare un capo** nel menu vendite.
2. L’app chiederà:

```
ID Utente: 
ID Capo: 
Quantità: 
```

* Esempio:

```
ID Utente: U001
ID Capo: C001
Quantità: 2
```

* L’app verificherà lo stock e registrerà la vendita, mostrando un messaggio tipo:

```
Vendita di 2x Maglietta completata. ID vendita: V1
```


#### **Restituire un capo acquistato**

* Scegli l’opzione **3** nel menu vendite.
* L’app chiederà:

```
ID Vendita : 
Quantità restituita: 
```

* **Come funziona:** devi inserire **l’ID della vendita precedentemente registrata**.
* Esempio: se in precedenza hai comprato 2 capi con ID vendita `V1`:

```
ID Vendita : V1
Quantità restituita: 2
```

* L’app aggiornerà lo stock e confermerà:

```
Vendita ID V1 eliminata. Stock aggiornato per C001.
```

---

### **4 aggiungi nuovo utente**

* Permette di aggiungere nuovi utenti all’app.
* L’app chiederà tutti i dati dell’utente:

```
ID Utente: 
Nome: 
Cognome: 
Data Nascita: 
Indirizzo: 
Documento ID: 
```

* Alla fine apparirà il messaggio:

```
Utente registrato correttamente.
```

---

### **5 esporta le prenotazioni disponibili**



---

* L’app risponde: nome file d'esportazione: file.csv (esempio)
* è in automatico ti esporta le prenotazioni disponibili.




---

## **💾 File CSV di esempio**

* **utenti.csv**

```
id;nome;cognome;dataNascita;indirizzo;documentoId
U1;Mario;Rossi;1990-01-01;Via Roma 1;AA123456
```

* **capi.csv**

```
id;dataInserimento;tipologia;prezzo;stock;colore;taglia;marca;materiale
C1;2025-01-01;Maglietta;25.0;10;Rosso;M;Nike;Cotone
```

* **vendite.csv**

```
idVendita;idUtente;idCapo;quantita;prezzoTotale
V1;U1;C1;2;50.0
```

---

## **📌 Note importanti**

* Tutti i file CSV devono essere nella cartella `src/main/resources/`.
* Il JAR generato con **Maven Shade Plugin** include tutte le dipendenze, quindi può essere eseguito su qualsiasi computer con Java 17+.
* Per modifiche al codice, ricompilare sempre con Maven:

```bash
mvn clean package
```

---

## **📖 Risorse utili**

* [Java JDK](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* [Apache Maven](https://maven.apache.org/)
* [Git Handbook](https://git-scm.com/book/en/v2)
* [Documentazione Shade Plugin Maven](https://maven.apache.org/plugins/maven-shade-plugin/)

---

## **🔗 Collegamento GitHub**

Il repository ufficiale con tutto il codice sorgente e le istruzioni è disponibile qui:

```
https://github.com/andrea-340/progetto-java-di-andrea-altomare.git
```

---


