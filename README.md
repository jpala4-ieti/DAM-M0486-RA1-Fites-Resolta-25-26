# MP0486 RA1 Fites (curs 25-26): resolta #

[![Tests](https://github.com/jpala4-ieti/DAM-M0486-RA1-Fites-Resolta-25-26/actions/workflows/maven.yml/badge.svg)](https://github.com/jpala4-ieti/DAM-M0486-RA1-Fites-Resolta-25-26/actions/workflows/maven.yml)

Solució de referència de la fita del RA1 (gestió de fitxers). Els mètodes marcats amb
`CODI EXERCICI FITA` a `Exercici0`, `Exercici1`, `Exercici2` i `Exercici3` ja estan implementats.
Les condicions de lliurament són a [INSTRUCCIONS.md](INSTRUCCIONS.md).

## Comprovació automàtica ##

La comprovació de GitHub Actions compila el projecte i passa tots els tests a cada push.

## Requisits ##

Java 21 i Maven.

## Arrencada ràpida ##

### Windows ###
```bash
.\run.ps1 cat.iesesteveterradas.fites.FitesMain
.\run.ps1 cat.iesesteveterradas.fites.Exercici0
.\run.ps1 cat.iesesteveterradas.fites.Exercici1
.\run.ps1 cat.iesesteveterradas.fites.Exercici2
.\run.ps1 cat.iesesteveterradas.fites.Exercici3
```

### Linux / macOS ###
```bash
./run.sh cat.iesesteveterradas.fites.FitesMain
./run.sh cat.iesesteveterradas.fites.Exercici0
./run.sh cat.iesesteveterradas.fites.Exercici1
./run.sh cat.iesesteveterradas.fites.Exercici2
./run.sh cat.iesesteveterradas.fites.Exercici3
```

`FitesMain` mostra un menú per triar l'exercici. Els scripts compilen, passen els tests i
executen la classe indicada.

## Execució pas a pas ##

```bash
mvn clean compile
mvn exec:java -PrunMain "-Dexec.mainClass=cat.iesesteveterradas.fites.Exercici0"
```

## Tests ##

```bash
# Tots els tests
mvn test
# Els tests d'un exercici
mvn test -Dtest=Exercici0Test
# Un sol test
mvn test -Dtest="Exercici1Test#testGiraText"
# Diversos exercicis
mvn test -Dtest="Exercici2Test,Exercici3Test"
```

Hi ha cinc tests per a l'exercici 0, dos per a l'1 i un per al 2 i per al 3. Al repositori
base fallen tots fins que s'implementen els mètodes; en aquesta solució han de passar tots.

## Versions ##

| Component | Versió |
|---|---|
| Java | 21 |
| Jakarta JSON Processing (API) | 2.1.3 |
| Eclipse Parsson | 1.1.7 |
| org.json (només tests) | 20240303 |
| JUnit Jupiter | 6.1.3 |
