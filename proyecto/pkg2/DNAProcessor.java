/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2;

/**
 *
 * @author JAVIER MENDEZ
 */

import java.io.*;
import javax.swing.*;

public class DNAProcessor {
    private HashTable hashTable;
    private BinarySearchTree bst;

    public DNAProcessor() {
        this.hashTable = new HashTable(199);
        this.bst = new BinarySearchTree();
    }

    public String loadDNAFromFile(JFrame frame) {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                StringBuilder sequence = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) sequence.append(line.trim().toUpperCase());

                for (int i = 0; i <= sequence.length() - 3; i += 3) {
                    String triplet = sequence.substring(i, i + 3);
                    hashTable.insert(triplet, i);
                }

                for (Pattern p : hashTable.getAllPatterns()) {
                    bst.insert(p);
                }

                return file.getName();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, "Error al leer el archivo.");
            }
        }
        return "Archivo no cargado";
    }

    public HashTable getHashTable() { return hashTable; }
    public BinarySearchTree getBST() { return bst; }
}

    

