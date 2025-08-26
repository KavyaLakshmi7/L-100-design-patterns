package components;

public class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a button in macOS style. (🔘)");
    }
    @Override
    public void onClick() {
        System.out.println("macOS button click event!");
    }
}