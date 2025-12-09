package docurepo.model;

import java.util.Base64;

public class Document {

    protected String name;
    protected int version;
    protected byte[] content;

    public Document(String name, byte[] content){
        SetName(name);
        SetVersion(1);
        SetContent(content);
    }

    public Document(String name, int version, byte[] content){
        SetName(name);
        SetVersion(version);
        SetContent(content);
    }

    public void SetName(String name){
        this.name = name;
    }

    public void SetVersion(int version){
        this.version = version;
    }

    public void SetContent(byte[] content){
        this.content = content;
    }

    public String GetName(){
        return name;
    }

    public String GetEncodedContent() {
        String encodedContent = Base64.getEncoder().encodeToString(content);
        return encodedContent;
    }

    public String GetSaveString() {
        return "0|"
            + name + "|"
            + version + "|"
            + GetEncodedContent();
    }
}
