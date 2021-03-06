package level_30.autoboxingCharacter.t6;

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    public void info(String message) {
        System.out.println("Logging to console: " + message);
    }
}
