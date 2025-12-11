package docurepo.controller;

import java.util.ArrayList;

public class DocumentListingController extends DocumentController {
    public static void main(String[] args){
        System.out.println("=====DEBUGGING=====");
    }

    public static void ListFiles() {
        ArrayList<String> metadataLines = GetMetadataLines();
        ArrayList<String> filenames = new ArrayList();
        for(String line : metadataLines) {
            String[] parts = line.split("\\|");
            String filename = parts[1];
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
