package docurepo.controller;

import docurepo.model.DOCXDocument;
import docurepo.model.Document;
import docurepo.model.PDFDocument;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class DocumentVersioningController extends DocumentController {
    public static void main(String[] args){
        System.out.println("=====DEBUGGING=====");
    }

    private static ArrayList<String> metadataLines;

    public static boolean Init() {
        String metadataPath = GetMetadataPath();
        File metadataFile = new File(metadataPath);
        metadataLines =  new ArrayList();

        try {
            Path metadata = Paths.get(metadataPath);
            if(!IsPathExists(metadata)) {
                
                boolean success = metadataFile.createNewFile();
                if (success)
                    return true;
            } else {
                Scanner metadataReader = new Scanner(metadataFile);
                while (metadataReader.hasNextLine()) {
                    String line = metadataReader.nextLine();
                    metadataLines.add(line);
                }
                return true;
            }
        } catch (IOException e) {
            
        }
        return false;
    }

    public static void RecordDocument(String filename, byte[] content) {
        int oldVersion = 0;
        for(String line : metadataLines) {
            if (line.contains(filename)) {
                String[] parts = line.split("\\|");
                int version = Integer.parseInt(parts[2]);
                if (oldVersion < version)
                    oldVersion = version;
            }
        }

        boolean isCreatingNewDocument = oldVersion < 1;
        Document newDocument = null;
        if (isCreatingNewDocument) {
            if (IsPathEndswithDOCX(filename))
                newDocument = new DOCXDocument(filename, content);
            if (IsPathEndswithPDF(filename))
                newDocument = new PDFDocument(filename, content);
        } else {
            if (IsPathEndswithDOCX(filename))
                newDocument = new DOCXDocument(filename, oldVersion+1, content);
            if (IsPathEndswithPDF(filename))
                newDocument = new PDFDocument(filename, oldVersion+1, content);
        }

        if (newDocument != null)
            AddNewFileRecord(newDocument);
    }

    public static void AddNewFileRecord(Document document) {
        String newLine = document.GetSaveString();
        metadataLines.add(newLine);
        WriteToMetadata();
    }

    public static void WriteToMetadata() {
        try {
            FileWriter writer = new FileWriter( GetMetadataPath() );
            for (String line : metadataLines)
                writer.write(String.format("%s\n", line));
        } catch (IOException e) {
        }
    }
}