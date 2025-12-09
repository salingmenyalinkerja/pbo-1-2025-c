package docurepo.model;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OldDocument {

    protected String name;
    protected int version;

    public OldDocument(String name){
        SetName(name);
        SetVersion(1);
    }

    public void SetName(String name){
        this.name = name;
    }

    public void SetVersion(int version){
        this.version = version;
    }

    // menyimpan history
    protected ArrayList<String> history = new ArrayList<>();

    // format tanggal & waktu
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // block initializer (jalan setelah konstruktor)
    {
        String time = LocalDateTime.now().format(formatter);
        history.add("Version 1 created at " + time);
    }

    // update versi
    public void updateVersion() {
        this.version++;
        String time = LocalDateTime.now().format(formatter);
        history.add("Version " + this.version + " updated at " + time);
    }

    // ambil history
    public ArrayList<String> getHistory() {
        return history;
    }

    // simpan ke TXT
    public void saveHistoryToTxt(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (String h : history) writer.write(h + "\n");
            writer.close();
        } catch (Exception e) {
            System.out.println("Error TXT: " + e.getMessage());
        }
    }

    // simpan ke CSV
    public void saveHistoryToCSV(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write("History\n");
            for (String h : history) writer.write("\"" + h + "\"\n");
            writer.close();
        } catch (Exception e) {
            System.out.println("Error CSV: " + e.getMessage());
        }
    }

    // simpan ke HTML (bisa dibuka di browser & print PDF)
    public void saveHistoryToHTML(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write("<html><body>");
            writer.write("<h2>Document History</h2>");

            for (String h : history) {
                writer.write("<p>" + h + "</p>");
            }

            writer.write("</body></html>");
            writer.close();
        } catch (Exception e) {
            System.out.println("Error HTML: " + e.getMessage());
        }
    }

}
