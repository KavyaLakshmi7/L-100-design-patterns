package components;

public class MacOSCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a checkbox in macOS style. (☑︎)");
    }
    @Override
    public void onCheck() {
        System.out.println("macOS checkbox check event!");
    }
}