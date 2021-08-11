package level_30.autoboxingCharacter.t6;

public class PhoneLogger extends AbstractLogger {

    public PhoneLogger(int level) {
        this.level = level;
    }

    @Override
    public void info(String message) {
        System.out.println("Call to director: " + message);
    }
}
