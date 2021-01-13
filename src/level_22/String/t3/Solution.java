package level_22.String.t3;

/*
Между табулцими
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        int firstIndex = 0, twoIndex = 0, currentIndex = -1, count = 0;

        if (string == null || (firstIndex = string.indexOf("\t")) < 0) throw new TooShortStringException();

        twoIndex = string.indexOf("\t", firstIndex + 1);
        if (twoIndex < 0) throw new TooShortStringException();

        return string.substring(firstIndex + 1, twoIndex);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучени Java\t."));
    }
}