package level_22.String.t2;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис"));
    }

    public static String getPartOfString(String string) {
        int firstIndex = 0, fourIndex = 0, currentIndex = -1, count = 0;

        if (string == null || (firstIndex = string.indexOf(" ")) < 0) throw new TooShortStringException();

        for (int i = 1; i <= 5; i++) {
            currentIndex = string.indexOf(" ", fourIndex + 1);
            if (currentIndex < 0) {
                fourIndex = string.length();
                break;
            }
            count = i;
            if (currentIndex > fourIndex) fourIndex = currentIndex;
        }

        if (count < 4) throw new TooShortStringException();

        return string.substring(firstIndex + 1, fourIndex);
    }

    public static class TooShortStringException extends RuntimeException {
    }
}