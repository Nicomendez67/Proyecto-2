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

public class CodonMapper {
    private final Map<String, String> dnaToAminoAcid;

    public CodonMapper() {
        dnaToAminoAcid = new HashMap<>();
        loadCodons();
    }

    private void loadCodons() {
        dnaToAminoAcid.put("TTT", "Fenilalanina");
        dnaToAminoAcid.put("TTC", "Fenilalanina");
        dnaToAminoAcid.put("TTA", "Leucina");
        dnaToAminoAcid.put("TTG", "Leucina");
        dnaToAminoAcid.put("ATG", "Metionina (Inicio)");
        dnaToAminoAcid.put("TAA", "STOP");
        dnaToAminoAcid.put("TAG", "STOP");
        dnaToAminoAcid.put("TGA", "STOP");
        // ⚠️ Agrega aquí todas las demás tripletas del enunciado si lo deseas
    }

    public String getAminoAcid(String triplet) {
        return dnaToAminoAcid.getOrDefault(triplet, "Tripleta no válida");
    }

    public Set<String> getAllValidTriplets() {
        return dnaToAminoAcid.keySet();
    }

    public Map<String, List<String>> getGroupedTriplets() {
        Map<String, List<String>> grouped = new HashMap<>();
        for (Map.Entry<String, String> entry : dnaToAminoAcid.entrySet()) {
            grouped.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        return grouped;
    }
}

    

