package level_30.bobrRestaurant.kitchen;

import level_30.bobrRestaurant.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private final String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable observable, Object arg) {
        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %dmin", arg.toString(), ((Order) arg).getTotalCookingTime()));
        setChanged();
        notifyObservers(arg);
    }
}
