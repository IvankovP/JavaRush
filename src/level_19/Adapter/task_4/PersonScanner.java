package level_19.Adapter.task_4;

import java.io.IOException;
import java.text.ParseException;

public interface PersonScanner {
    Person read() throws IOException;

    void close() throws IOException;
}
