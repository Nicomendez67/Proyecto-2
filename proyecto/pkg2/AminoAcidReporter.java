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
    private final CodonMapper mapper;
    private final HashTable hashTable;

    /**
     * Genera un reporte textual con tripletas agrupadas por aminoacido.
     * @return cadena de texto con el informe
     */
    public AminoAcidReporter(HashTable hashTable) {
        this.mapper = new CodonMapper();
        this.hashTable = hashTable;
    }
    /**
     * Genera un reporte agrupado por aminoacido, mostrando las tripletas del ADN
     * que lo sintetizan junto con su frecuencia de aparicion en la secuencia principal.
     * El reporte incluye:
     * - El nombre del aminoacido.
     * - El total de apariciones de todas las tripletas que lo sintetizan.
     * - Cada tripleta seguida por su frecuencia individual, en el formato: "TTA (3), TTG (2)..."
     * Solo se muestran los aminoacidos cuyas tripletas fueron encontradas en la tabla hash.
     * @return una cadena de texto con el informe completo, lista para mostrar en la interfaz
     */

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

    

