package level_24.InterfaceMarker.t1;

import java.lang.reflect.Method;

public class Util {
    // Пример того, как можно использовать интерфейс-маркер
    // Этот метод подходит только дл классов, реализующих SelfInterfaceMarker
    public static void testClass(SelfInterfaceMarker interfaceMarker) throws UnsupportedInterfaceMarkerException {
        if (interfaceMarker == null) throw new UnsupportedInterfaceMarkerException();
        for (Method method : interfaceMarker.getClass().getDeclaredMethods()) {
            System.out.println(method);
        }
    }
}

