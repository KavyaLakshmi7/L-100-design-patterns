interface FoodItem {
    void prepare();
}

class Pizza implements FoodItem {
    @Override
    public void prepare() {
        System.out.println("Preparing a delicious Pizza with cheese and toppings.");
    }
}

class Burger implements FoodItem {
    @Override
    public void prepare() {
        System.out.println("Grilling a juicy Burger with lettuce and tomato.");
    }
}

abstract class Restaurant {
    
    public abstract FoodItem createFood();

    public void orderFood() {
        System.out.println("A new order has been received.");
        FoodItem item = createFood(); 
        item.prepare();
        System.out.println("The order is ready to be served!");
    }
}

class Pizzeria extends Restaurant {
    @Override
    public FoodItem createFood() {
        return new Pizza();
    }
}

class BurgerJoint extends Restaurant {
    @Override
    public FoodItem createFood() {
        return new Burger();
    }
}

public class FoodOrder {
    public static void main(String[] args) {
        System.out.println("--- Factory Method Pattern ---");
        Restaurant myPizzeria = new Pizzeria();
        myPizzeria.orderFood();

        System.out.println("\n-----------------------------------\n");
        Restaurant myBurgerJoint = new BurgerJoint();
        myBurgerJoint.orderFood();
    }
}