package app;

import components.Button;
import components.Checkbox;
import factories.UIFactory;

public class Application {
    private final Button button;
    private final Checkbox checkbox;

    public Application(UIFactory factory) {
        System.out.println("Configuring application with a UI factory...");
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void run() {
        System.out.println("Application is running. Rendering UI elements...");
        button.render();
        checkbox.render();
    }
}