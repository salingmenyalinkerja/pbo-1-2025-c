package docurepo.model;

public class DOCXDocument extends Document {
    public static void main(String[] args){
        System.out.println("=====DEBUGGING=====");
    }
    
    public DOCXDocument(String name, byte[] content){
        super(name, content);
    }

    public DOCXDocument(String name, int version, byte[] content){
        super(name, version, content);
    }

    @Override
    public String GetSaveString() {
        return "1|"
            + name + "|"
            + version + "|"
            + GetEncodedContent();
    }
}
