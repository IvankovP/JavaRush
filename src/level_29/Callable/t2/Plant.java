package level_29.Callable.t2;

import java.util.concurrent.atomic.AtomicInteger;

public class Plant extends Character {
    private final static AtomicInteger idSequence = new AtomicInteger();
    private final int id = idSequence.incrementAndGet();

    protected int getId() {
        return id;
    }
}
