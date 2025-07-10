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
 * Genera reportes organizados por aminoacidos con frecuencias de aparicion.
 */
public class AminoAcidReporter {
    /**
     * Genera un reporte textual con tripletas agrupadas por aminoacido.
     * @return cadena de texto con el informe
     */
    private final CodonMapper mapper;
    private final HashTable hashTable;

    public AminoAcidReporter(HashTable hashTable) {
        this.mapper = new CodonMapper();
        this.hashTable = hashTable;
    }

    public String generateReport() {
        Map<String, Integer> freqMap = new HashMap<>();
        Map<String, List<String>> aminoToTriplets = mapper.getGroupedTriplets();

        StringBuilder sb = new StringBuilder("📋 Reporte por Aminoácido\n");
        for (Map.Entry<String, List<String>> entry : aminoToTriplets.entrySet()) {
            String amino = entry.getKey();
            List<String> triplets = entry.getValue();
            int total = 0;
            List<String> withFreq = new ArrayList<>();

            for (String t : triplets) {
                Pattern p = hashTable.search(t);
                if (p != null) {
                    int f = p.getFrequency();
                    total += f;
                    withFreq.add(t + " (" + f + ")");
                }
            }

            if (!withFreq.isEmpty()) {
                sb.append("\n🔹 ").append(amino).append(" (").append(total).append("): ");
                sb.append(String.join(", ", withFreq));
            }
        }
        return sb.toString();
    }
}

    

