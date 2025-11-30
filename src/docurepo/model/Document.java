package docurepo.model;

public class Document {
    public static void main(String[] args){
        System.out.println("=====DEBUGGING=====");
    }
    
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
}
