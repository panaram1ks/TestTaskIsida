package nocompany.JSFprimefaces.entity;

public class TagA {

    private String href;
    private String name;

    public TagA(String url, String name){
        this.href = url;
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
