package docurepo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DocumentStorageController extends DocumentController {
    public static void main(String[] args){
        System.out.println("=====DEBUGGING=====");
    }

    public static String CreateDocument(String sourcePath, String filename){
        Path source = Paths.get(sourcePath);
        Path destination = Paths.get(FormatPathSafely(filename));
        Path storageDirectory = Paths.get(GetStorageDirectory());

        try {
            if (!IsPathExists(storageDirectory))
                Files.createDirectories(storageDirectory);
            
            if (IsValid(sourcePath) && IsValid(filename)) {
                Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                DocumentVersioningController.RecordDocument(filename, Files.readAllBytes(destination));

                return "Document is successfully created or updated.";
            } else {
                return "The entered source path and/or target filename is not .docx nor .pdf. Insertion cancelled.";
            }
        } catch (IOException e) {
            return "Document is unsuccessfully created: " + e;
        }
    }

    public static String DeleteDocument(String filename) {
        String fullPath = FormatPathSafely(filename);
        File toBeDeleted = new File(fullPath);

        try {
            boolean success = toBeDeleted.delete();
            if (success) {
                return "Document is successfully deleted.";
            } else {
                return "Document is unsuccessfully deleted.";
            }
        } catch (Exception e) {
            return "Document is unsuccessfully deleted:" + e;
        }
    }
}
