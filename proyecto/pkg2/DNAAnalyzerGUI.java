/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2;

/**
 *
 * @author JAVIER MENDEZ
 */


import javax.swing.*;
import java.awt.*;
/**
 * Interfaz gráfica principal del analizador de ADN.
 */
public class DNAAnalyzerGUI extends JFrame {
    /**
     * Constructor que inicializa todos los componentes de la GUI.
     */
    private DNAProcessor processor;
    private JLabel fileLabel;
    private JTextArea displayArea;

    public DNAAnalyzerGUI() {
    /**
     * Muestra los patrones ordenados por frecuencia en el area de resultados.
     */
        super("🧬 Analizador de ADN - Proyecto Bioinformática");
        this.processor = new DNAProcessor();

        // 🧱 Configuración general
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 📂 Panel superior con botón de carga y etiqueta de archivo
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton loadBtn = new JButton("📂 Cargar archivo");
        fileLabel = new JLabel("Archivo no cargado");
        topPanel.add(loadBtn);
        topPanel.add(fileLabel);
        add(topPanel, BorderLayout.NORTH);

        // 🧭 Panel central con pestañas de funcionalidad
        JTabbedPane tabs = new JTabbedPane();

        // 📋 Tab: listar patrones
        JButton listBtn = new JButton("Mostrar patrones por frecuencia");
        listBtn.addActionListener(e -> showPatterns());
        tabs.addTab("📋 Lista", listBtn);

        // 🔍 Tab: búsqueda
        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Tripleta:"));
        JTextField searchField = new JTextField(6);
        JButton searchBtn = new JButton("Buscar");
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);
        searchBtn.addActionListener(e -> searchTriplet(searchField.getText()));
        tabs.addTab("🔎 Buscar", searchPanel);

        // ⭐ Tab: más / menos frecuente
        JButton freqBtn = new JButton("Mostrar extremos de frecuencia");
        freqBtn.addActionListener(e -> showFrequencies());
        tabs.addTab("⭐ Frecuencia", freqBtn);

        // 🧪 Tab: aminoácidos
        JButton aminoBtn = new JButton("Mostrar mapa aminoácido");
        aminoBtn.addActionListener(e -> showAminoMap());
        tabs.addTab("🧪 Aminoácidos", aminoBtn);

        add(tabs, BorderLayout.CENTER);

        // 📤 Área inferior para mostrar resultados
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scroll = new JScrollPane(displayArea);
        scroll.setPreferredSize(new Dimension(680, 180));
        add(scroll, BorderLayout.SOUTH);

        // Evento carga de archivo
        loadBtn.addActionListener(e -> {
            String name = processor.loadDNAFromFile(this);
            fileLabel.setText("Archivo: " + name);
        });

        setVisible(true);
    }

    private void showPatterns() {
    /**
     * Busca y muestra informacion de una tripleta específica.
     * @param triplet cadena de tres letras introducida por el usuario
     */
        StringBuilder sb = new StringBuilder();
        for (Pattern p : processor.getBST().inOrder()) {
            sb.append(String.format("%s (%d): %s%n", p.getTriplet(), p.getFrequency(), p.getPositions()));
        }
        displayArea.setText(sb.toString());
    }

    private void searchTriplet(String triplet) {
    /**
     * Muestra las tripletas mas y menos frecuentes.
     */
        if (triplet == null || triplet.length() != 3) {
            displayArea.setText("🔺 Ingrese una tripleta de exactamente 3 letras.");
            return;
        }
        Pattern p = processor.getHashTable().search(triplet.toUpperCase());
        if (p == null) {
            displayArea.setText("🔍 Tripleta no encontrada.");
        } else {
            displayArea.setText("🧬 Tripleta: " + p.getTriplet() +
                    "\nFrecuencia: " + p.getFrequency() +
                    "\nPosiciones: " + p.getPositions());
        }
    }

    private void showFrequencies() {
    /**
     * Genera y muestra el informe de aminoacidos.
     */

        Pattern max = processor.getBST().getMostFrequent();
        Pattern min = processor.getBST().getLeastFrequent();
        if (max != null && min != null) {
            displayArea.setText("📈 Más frecuente: " + max.getTriplet() + " (" + max.getFrequency() + " veces)\n" +
                    "📉 Menos frecuente: " + min.getTriplet() + " (" + min.getFrequency() + " veces)");
        } else {
            displayArea.setText("⚠️ Aún no se ha cargado una secuencia válida.");
        }
    }

    private void showAminoMap() {
    /**
     * Metodo principal que lanza la aplicacion.
     * @param args argumentos de línea de comando (no utilizados)
     */

        AminoAcidReporter reporter = new AminoAcidReporter(processor.getHashTable());
        displayArea.setText(reporter.generateReport());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DNAAnalyzerGUI::new);
    }
}

    

