package docurepo.controller;

import java.util.ArrayList;

public class DocumentSearchController extends DocumentController{
    public static void main(String[] args){
        System.out.println("=====DEBUGGING=====");
    }

    public static void SearchFiles(String keyword) {
        ArrayList<String> metadataLines = GetMetadataLines();
        ArrayList<String> filenames = new ArrayList();
        for(String line : metadataLines) {
            String[] parts = line.split("\\|");
            String filename = parts[1];

            if (!filename.contains(keyword))
                continue;
                
            boolean exists = false;

            for(String f : filenames) {
                if (f.equals(filename)) {
                    exists = true;
                    break;
                }
            }

            if(!exists)
                filenames.add(filename);
        }

        for(String filename : filenames) {
            System.out.println(filename);
        }
    }
}
