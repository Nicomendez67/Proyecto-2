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
     * @param position índice en la secuencia principal
     */
    private LinkedList<Pattern>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable(int size) {
        this.size = size;
        this.table = new LinkedList[size];
        for (int i = 0; i < size; i++) table[i] = new LinkedList<>();
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % size;
    }

    public void insert(String triplet, int position) {
    /**
     * Busca una tripleta en la tabla.
     * @param triplet cadena a buscar
     * @return patrón encontrado o null
     */
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

    public Pattern search(String triplet) {
    /**
     * Obtiene todas las tripletas almacenadas en la tabla.
     * @return lista de patrones
     */
        int index = hash(triplet);
        for (Pattern p : table[index]) {
            if (p.getTriplet().equals(triplet)) return p;
        }
        return null;
    }

    public List<Pattern> getAllPatterns() {
        List<Pattern> all = new ArrayList<>();
        for (LinkedList<Pattern> bucket : table) all.addAll(bucket);
        return all;
    }
}

    

