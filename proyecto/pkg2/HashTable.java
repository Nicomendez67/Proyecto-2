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

public class HashTable {
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

    

