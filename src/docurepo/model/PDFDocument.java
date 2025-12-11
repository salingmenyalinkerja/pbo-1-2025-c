package docurepo.model;

public class PDFDocument extends Document {
    public static void main(String[] args){
        System.out.println("=====DEBUGGING=====");
    }
    
    public PDFDocument(String name, byte[] content){
        super(name, content);
    }

    public PDFDocument(String name, int version, byte[] content){
        super(name, version, content);
    }

    public PDFDocument(String name, String version, byte[] content){
        super(name, version, content);
    }

    @Override
    public String GetSaveString() {
        return "2|"
            + name + "|"
            + version + "|"
            + GetEncodedContent();
    }
}
