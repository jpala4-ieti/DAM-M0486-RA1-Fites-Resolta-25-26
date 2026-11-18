package cat.iesesteveterradas.fites;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import cat.iesesteveterradas.fites.objectes.Exercici2nau;

/**
 * Implementa el codi que realitzi el següent:
 * 
 * - Serialitza aquesta llista en un fitxer binari anomenat 'Exercici2.dat' al directori de treball especificat.
 * - Després d'una pausa d'1 segon, deserialitza la llista del fitxer binari i la imprimeix per pantalla amb el format "Nom, País Any".
 * - Gestió d'errors: si hi ha algun problema en escriure o llegir el fitxer (ex. fitxer no trobat), mostra l'excepció a la consola amb e.printStackTrace()
 */
public class Exercici2 {
    private String filePath;

    public static void main(String[] args) {
        String basePath = System.getProperty("user.dir") + "/data/exercici2/";
        String filePath = basePath + "Exercici2.dat";

        Exercici2 exercici = new Exercici2();
        exercici.configurarRutaFitxerSortida(filePath);
        exercici.executa();
    }

    // Mètode que executa la lògica de la classe
    public void executa() {
        ArrayList<Exercici2nau> llista0 = new ArrayList<>();
        llista0.add(new Exercici2nau("Vostok", "USSR", 1961));
        llista0.add(new Exercici2nau("Mercury", "US", 1961));
        llista0.add(new Exercici2nau("Gemini", "US", 1965));
        llista0.add(new Exercici2nau("Soyuz", "Russia", 1967));
        llista0.add(new Exercici2nau("Apollo", "US", 1968));
        llista0.add(new Exercici2nau("Shuttle", "US", 1981));
        llista0.add(new Exercici2nau("Shenzhou", "China", 2003));
        llista0.add(new Exercici2nau("Crew Dragon", "US", 2020));

        serialitzaLlista(filePath, llista0);

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        }

        ArrayList<Exercici2nau> llista1 = deserialitzaLlista(filePath);
        imprimeixLlista(llista1);
    }

    // Mètode per serialitzar la llista a un fitxer
    public void serialitzaLlista(String filePath, ArrayList<Exercici2nau> llista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            // ArrayList és serialitzable i Exercici2nau també: es desa tota la llista d'un cop
            oos.writeObject(llista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Mètode per deserialitzar la llista del fitxer
    public ArrayList<Exercici2nau> deserialitzaLlista(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            @SuppressWarnings("unchecked")
            ArrayList<Exercici2nau> llista = (ArrayList<Exercici2nau>) ois.readObject();
            return llista;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Mètode per imprimir la llista
    public void imprimeixLlista(ArrayList<Exercici2nau> llista) {
        if (llista == null) {
            return;
        }
        for (Exercici2nau nau : llista) {
            // toString() de Exercici2nau ja retorna "Nom, País Any"
            System.out.println(nau);
        }
    }

    /****************************************************************************/
    /*                          NO CAL MODIFICAR                                */
    /****************************************************************************/       
    // Setter per definir el path
    public void configurarRutaFitxerSortida(String filePath) {
        this.filePath = filePath;
    }

    // Getter per obtenir el path
    public String obtenirRutaFitxerSortida() {
        return this.filePath;
    }
}
