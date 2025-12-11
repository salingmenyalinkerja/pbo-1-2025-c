package docurepo.controller;

import docurepo.model.DOCXDocument;
import docurepo.model.Document;
import docurepo.model.PDFDocument;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

public class DocumentVersioningController extends DocumentController {
    public static void main(String[] args){
        System.out.println("=====DEBUGGING=====");
    }

    private static ArrayList<String> metadataLines;

    public static boolean Init() {
        String storagePath = GetStorageDirectoryPath();
        String metadataPath = GetMetadataPath();
        File storageDirectory = new File(storagePath);
        File metadataFile = new File(metadataPath);

        try {
            if (!storageDirectory.exists())
                storageDirectory.mkdir();
            
            if (!metadataFile.exists()) {
                boolean success = metadataFile.createNewFile();
                if (success)
                    return true;
            } else {
                metadataLines = GetMetadataLines();
                return true;
            }
        } catch (IOException e) {
            System.out.println(e);
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

    public static Document GetDocumentOfAVersion(String filename, String version) {
        for(String line : metadataLines) {
            if (line.contains(filename)) {
                String[] parts = line.split("\\|");
                String foundFilename = parts[1];
                String foundVersion = parts[2];

                if (
                    foundFilename.equals(filename) &&
                    foundVersion.equals(version)
                ) {
                    String encodedContent = parts[3];
                    return new Document(
                        foundFilename,
                        foundVersion,
                        Base64.getDecoder().decode(encodedContent)
                    );
                }
            }
        }
        return null;
    }
}