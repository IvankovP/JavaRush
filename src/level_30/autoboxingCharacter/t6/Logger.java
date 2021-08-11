package level_30.autoboxingCharacter.t6;

public interface Logger {
    void inform(String message, int level);

    void setNext(Logger next);

    void info(String message);
}
