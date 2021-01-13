package level_24.InterfaceMarker.t1;

/*
Создание своего интерфейса-маркера
*/
public class Solution {
    public static void main(String[] args) throws UnsupportedInterfaceMarkerException {
        SelfInterfaceMarkerImpl obj = new SelfInterfaceMarkerImpl();
        Util.testClass(obj);
    }

}