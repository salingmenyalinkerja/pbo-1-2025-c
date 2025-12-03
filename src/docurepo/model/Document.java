package docurepo.model;

public class Document {
    protected String name;
    protected int version;

    public Document(String name){
        setName(name);
        setVersion(1);
    }

    public String getName() {
        return name;
    }

    public int getVersion() {
        return version;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setVersion(int version){
        this.version = version;
    }

    public void printInfo() {
        System.out.println("Document Name : " + name);
        System.out.println("Version       : " + version);
    }
}
