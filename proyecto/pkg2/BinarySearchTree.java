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
 * Arbol binario de busqueda para ordenar tripletas por frecuencia.
 */
public class BinarySearchTree {
    private class Node {
        Pattern pattern;
        Node left, right;

        Node(Pattern p) { this.pattern = p; }
    }

    private Node root;
    
    /**
     * Inserta un patron en el arbol ordenado por frecuencia.
     * @param pattern patron a insertar
     */
    public void insert(Pattern pattern) {
        root = insertRec(root, pattern);
    }
    
    /**
     * Inserta recursivamente un patron en el arbol binario de busqueda,
     * ordenando los nodos segun su frecuencia de aparicion.
     * Si el nodo actual es null, se crea un nuevo nodo con el patron dado.
     * Si la frecuencia del nuevo patron es menor que la del nodo actual,
     * se inserta en el subarbol izquierdo; de lo contrario, en el derecho.
     * @param node el nodo actual del arbol (puede ser null)
     * @param pattern el patron que se desea insertar
     * @return el nodo actualizado que representa el arbol luego de la insercion
     */
    private Node insertRec(Node node, Pattern pattern) {
        if (node == null) return new Node(pattern);
        if (pattern.getFrequency() < node.pattern.getFrequency())
            node.left = insertRec(node.left, pattern);
        else
            node.right = insertRec(node.right, pattern);
        return node;
    }
    
    /**
     * Realiza recorrido in-order del arbol y devuelve los patrones ordenados.
     * @return lista ordenada de patrones
     */
    public List<Pattern> inOrder() {
        List<Pattern> list = new ArrayList<>();
        inOrderRec(root, list);
        return list;
    }
    
    /**
     * Realiza un recorrido in-order (izquierda, raiz, derecha) en el arbol binario,
     * y almacena cada patron visitado en la lista proporcionada.
     * Este recorrido genera una lista ordenada por frecuencia de aparicion,
     * ya que el arbol esta construido con esa logica comparativa.
     * @param node nodo actual del arbol a visitar
     * @param list lista acumuladora donde se agregan los patrones en orden
     */
    private void inOrderRec(Node node, List<Pattern> list) {
        if (node != null) {
            inOrderRec(node.left, list);
            list.add(node.pattern);
            inOrderRec(node.right, list);
        }
    }
    /**
     * Obtiene el patron con mayor frecuencia.
     * @return patron mas frecuente
     */
    public Pattern getMostFrequent() {
        Node current = root;
        while (current.right != null) current = current.right;
        return current.pattern;
    }
     /**
     * Obtiene el patron con menor frecuencia.
     * @return patron menos frecuente
     */
    public Pattern getLeastFrequent() {
        Node current = root;
        while (current.left != null) current = current.left;
        return current.pattern;
    }
}

    

