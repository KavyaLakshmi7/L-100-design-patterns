package components;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a checkbox in Windows style. [✓]");
    }
    @Override
    public void onCheck() {
        System.out.println("Windows checkbox check event!");
    }
}