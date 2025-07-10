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

public class BinarySearchTree {
    private class Node {
        Pattern pattern;
        Node left, right;

        Node(Pattern p) { this.pattern = p; }
    }

    private Node root;

    public void insert(Pattern pattern) {
        root = insertRec(root, pattern);
    }

    private Node insertRec(Node node, Pattern pattern) {
        if (node == null) return new Node(pattern);
        if (pattern.getFrequency() < node.pattern.getFrequency())
            node.left = insertRec(node.left, pattern);
        else
            node.right = insertRec(node.right, pattern);
        return node;
    }

    public List<Pattern> inOrder() {
        List<Pattern> list = new ArrayList<>();
        inOrderRec(root, list);
        return list;
    }

    private void inOrderRec(Node node, List<Pattern> list) {
        if (node != null) {
            inOrderRec(node.left, list);
            list.add(node.pattern);
            inOrderRec(node.right, list);
        }
    }

    public Pattern getMostFrequent() {
        Node current = root;
        while (current.right != null) current = current.right;
        return current.pattern;
    }

    public Pattern getLeastFrequent() {
        Node current = root;
        while (current.left != null) current = current.left;
        return current.pattern;
    }
}

    

