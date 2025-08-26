public class Manager {
    private String name;

    public Manager(String name) {
        this.name = name;
    }

    public void approve(String document) {
        System.out.println(name + " approved document: " + document);
    }

    public void reject(String document) {
        System.out.println(name + " rejected document: " + document);
    }

    public void requestChanges(String document) {
        System.out.println(name + " requested changes for document: " + document);
    }
}
