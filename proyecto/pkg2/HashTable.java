/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2;

/**
 *
 * @author JAVIER MENDEZ
 */

import java.util.*;
/**
 * Tabla de dispersion con encadenamiento para almacenar tripletas de ADN.
 */
public class HashTable {
    /**
     * Inserta una tripleta en la tabla, registrando su posicion.
     * @param triplet cadena de tres letras
     * @param position indice en la secuencia principal
     */
    private LinkedList<Pattern>[] table;
    private int size;
    
    /**
     * Constructor que inicializa una nueva tabla de dispersion de tamaño especifico.
     * Crea un arreglo de listas enlazadas para manejar colisiones por encadenamiento.
     * @param size tamaño deseado de la tabla hash (numero de cubetas disponibles)
     */
    public HashTable(int size) {
        this.size = size;
        this.table = new LinkedList[size];
        for (int i = 0; i < size; i++) table[i] = new LinkedList<>();
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % size;
    }
     /**
     * Inserta una tripleta en la tabla, registrando su posicion.
     * @param triplet cadena de tres letras
     * @param position indice en la secuencia principal
     */
    public void insert(String triplet, int position) {
        int index = hash(triplet);
        for (Pattern p : table[index]) {
            if (p.getTriplet().equals(triplet)) {
                p.addOccurrence(position);
                return;
            }
        }
        Pattern pattern = new Pattern(triplet);
        pattern.addOccurrence(position);
        table[index].add(pattern);
    }
    /**
     * Busca una tripleta en la tabla.
     * @param triplet cadena a buscar
     * @return patron encontrado o null
     */
    public Pattern search(String triplet) {
        int index = hash(triplet);
        for (Pattern p : table[index]) {
            if (p.getTriplet().equals(triplet)) return p;
        }
        return null;
    }
    /**
     * Obtiene todas las tripletas almacenadas en la tabla.
     * @return lista de patrones
     */
    public List<Pattern> getAllPatterns() {
        List<Pattern> all = new ArrayList<>();
        for (LinkedList<Pattern> bucket : table) all.addAll(bucket);
        return all;
    }
}

    

