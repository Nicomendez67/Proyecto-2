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
 * Representa una tripleta de ADN con frecuencia de aparicion y posiciones en la secuencia.
 */
public class Pattern {
    /**
     * Constructor que inicializa una nueva tripleta con frecuencia 0.
     * @param triplet tripleta de ADN
     */
    private String triplet;
    private int frequency;
    private List<Integer> positions;

    public Pattern(String triplet) {

    /**
     * Registra una nueva aparición del patron en la posicion dada.
     * @param position indice de aparicion en la cadena principal
     */
        this.triplet = triplet;
        this.frequency = 0;
        this.positions = new ArrayList<>();
    }

    public void addOccurrence(int position) {
    /**
     * Devuelve la tripleta de ADN.
     * @return cadena de tres caracteres que representa la tripleta
     */
        frequency++;
        positions.add(position);
    }

    public String getTriplet() { return triplet; }
    /**
     * Devuelve la cantidad de veces que aparecio el patron.
     * @return frecuencia de ocurrencias
     */
    public int getFrequency() { return frequency; }
    /**
     * Devuelve la lista de posiciones donde se encontro la tripleta.
     * @return lista de índices
     */
    public List<Integer> getPositions() { return positions; }
}

    

