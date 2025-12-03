package docurepo.model;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

// Tambahan untuk PDF
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

public class Document {

    protected String name;
    protected int version;

    public Document(String name){
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

    // constructor tambahan setelah versi diset
    {
        // block initializer 
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

    // simpan ke PDF
    public void saveHistoryToPDF(String filename) {
        try {
            PDDocument pdf = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            pdf.addPage(page);

            PDPageContentStream content = new PDPageContentStream(pdf, page);
            content.setFont(PDType1Font.HELVETICA, 12);

            float y = 770;

            for (String h : history) {
                if (y < 50) {
                    content.close();
                    page = new PDPage(PDRectangle.A4);
                    pdf.addPage(page);
                    content = new PDPageContentStream(pdf, page);
                    content.setFont(PDType1Font.HELVETICA, 12);
                    y = 770;
                }
                content.beginText();
                content.newLineAtOffset(50, y);
                content.showText(h);
                content.endText();
                y -= 20;
            }

            content.close();
            pdf.save(filename);
            pdf.close();

        } catch (Exception e) {
            System.out.println("Error PDF: " + e.getMessage());
        }
    }

}
