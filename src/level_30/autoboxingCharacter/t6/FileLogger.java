package level_30.autoboxingCharacter.t6;

public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    public void info(String message) {
        System.out.println("Logging to file: " + message);
    }
}
