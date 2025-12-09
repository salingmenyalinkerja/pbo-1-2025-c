package docurepo.controller;

import java.nio.file.Files;
import java.nio.file.Path;

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

    protected static String GetStorageDirectory() {
        return System.getProperty("user.dir") + "\\" + "storage";
    }

    protected static String GetMetadataPath() {
        return GetStorageDirectory() + "\\" + "metadata.data";
    }

    protected static String FormatPathSafely(String filename) {
        return GetStorageDirectory() + "\\" + filename;
    }
}
