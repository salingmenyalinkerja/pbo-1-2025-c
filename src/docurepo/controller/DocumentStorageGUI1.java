import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class DocumentStorageGUI1 {

    private static Map<String, String> storage = new HashMap<>();
    private static JTextArea outputArea;

    public static void main(String[] args) {
        // Swing UI dijalankan di Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Document Storage (Create & Delete Only)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        // Area untuk menampilkan output
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Panel input dan tombol
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        // Input nama file
        JTextField fileNameInput = new JTextField();
        panel.add(fileNameInput);

        // Panel tombol Create & Delete
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));

        JButton createBtn = new JButton("Create");
        JButton deleteBtn = new JButton("Delete");

        buttonPanel.add(createBtn);
        buttonPanel.add(deleteBtn);

        panel.add(buttonPanel);

        frame.add(panel, BorderLayout.NORTH);

        // ================== EVENT HANDLER ================== //

        // CREATE
        createBtn.addActionListener(e -> {
            String file = fileNameInput.getText().trim();
            if (!file.isEmpty()) {
                storage.put(file, "File kosong dibuat: " + file);
                print("File berhasil dibuat: " + file);
            } else {
                print("Nama file tidak boleh kosong!");
            }
        });

        // DELETE
        deleteBtn.addActionListener(e -> {
            String file = fileNameInput.getText().trim();
            if (!file.isEmpty()) {
                if (storage.containsKey(file)) {
                    storage.remove(file);
                    print("File dihapus: " + file);
                } else {
                    print("File tidak ditemukan: " + file);
                }
            } else {
                print("Nama file tidak boleh kosong!");
            }
        });

        frame.setVisible(true);
    }

    private static void print(String text) {
        outputArea.append(text + "\n");
    }
}
