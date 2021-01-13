package level_24.LocalClass.t2;

import java.util.List;

/*
Реализаци интерфейса использу локальный класс
*/
public class Solution {
    public static void main(String[] args) {
        List<Pet> pet = Util.getPets();
        List<Sayable> pets = Util.convertPetToSayable(pet);
        Util.printDialog(pets);
    }
}
