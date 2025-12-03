import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class SearchDocumentViewer extends JFrame {

    private JTextArea textArea;
    private JTextField txtSearch;
    private JButton btnOpen, btnSearch;

    public SearchDocumentViewer() {
        setTitle("Search Document Viewer");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // AREA TAMPILAN DOKUMEN
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        // PANEL ATAS (OPEN FILE + SEARCH)
        JPanel topPanel = new JPanel();
        txtSearch = new JTextField(20);
        btnOpen = new JButton("Open Document");
        btnSearch = new JButton("Search");

        topPanel.add(btnOpen);
        topPanel.add(new JLabel("Cari:"));
        topPanel.add(txtSearch);
        topPanel.add(btnSearch);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // AKSI OPEN FILE
        btnOpen.addActionListener(e -> openFile());

        // AKSI SEARCH
        btnSearch.addActionListener(e -> searchText());
    }

    // BUKA FILE DOKUMEN
    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);

        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String fileName = file.getName().toLowerCase();

            try {
                if (fileName.endsWith(".txt")) {
                    loadTxt(file);
                } else if (fileName.endsWith(".pdf")) {
                    loadPdf(file);
                } else {
                    JOptionPane.showMessageDialog(this, "Format tidak didukung (hanya TXT & PDF)");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error membuka file: " + ex.getMessage());
            }
        }
    }

    // LOAD TXT FILE
    private void loadTxt(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        textArea.read(reader, null);
        reader.close();
    }

    // LOAD PDF FILE
    private void loadPdf(File file) throws IOException {
        PDDocument document = PDDocument.load(file);
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String text = pdfStripper.getText(document);
        textArea.setText(text);
        document.close();
    }

    // FUNGSI SEARCH
    private void searchText() {
        String search = txtSearch.getText().toLowerCase();
        String content = textArea.getText().toLowerCase();

        if (search.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan kata yang ingin dicari!");
            return;
        }

        if (content.contains(search)) {
            JOptionPane.showMessageDialog(this, "Kata ditemukan!");
        } else {
            JOptionPane.showMessageDialog(this, "Kata TIDAK ditemukan.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SearchDocumentViewer().setVisible(true);
        });
    }
}
