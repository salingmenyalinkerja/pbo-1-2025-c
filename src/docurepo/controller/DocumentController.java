package docurepo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class DocumentController {
    protected static boolean IsPathExists(Path path) {
        return Files.exists(path);
    }

    protected static boolean IsValid(String path){
        return IsPathEndswithDOCX(path) || IsPathEndswithPDF(path);
    }

    protected static boolean IsPathEndswithDOCX(String path){
        return path.endsWith(".docx");
    }
    protected static boolean IsPathEndswithPDF(String path){
        return path.endsWith(".pdf");
    }

    protected static String GetStorageDirectoryPath() {
        return System.getProperty("user.dir") + "\\" + "storage";
    }

    protected static String GetMetadataPath() {
        return GetStorageDirectoryPath() + "\\" + "metadata.data";
    }

    protected static String FormatPathSafely(String filename) {
        return GetStorageDirectoryPath() + "\\" + filename;
    }

    protected static ArrayList<String> GetMetadataLines() {
        File metadataFile = new File(GetMetadataPath());
        ArrayList<String> metadataLines = new ArrayList();

        try {
            Scanner metadataReader = new Scanner(metadataFile);
            while (metadataReader.hasNextLine()) {
                String line = metadataReader.nextLine();
                metadataLines.add(line);
            }

            return metadataLines;
        } catch (IOException e) {
        }

        return metadataLines;
    }
}
