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

public class Pattern {
    private String triplet;
    private int frequency;
    private List<Integer> positions;

    public Pattern(String triplet) {
        this.triplet = triplet;
        this.frequency = 0;
        this.positions = new ArrayList<>();
    }

    public void addOccurrence(int position) {
        frequency++;
        positions.add(position);
    }

    public String getTriplet() { return triplet; }
    public int getFrequency() { return frequency; }
    public List<Integer> getPositions() { return positions; }
}

    

