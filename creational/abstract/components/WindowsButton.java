package components;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a button in Windows style. [□]");
    }
    @Override
    public void onClick() {
        System.out.println("Windows button click event!");
    }
}