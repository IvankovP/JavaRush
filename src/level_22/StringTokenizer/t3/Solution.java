package level_22.StringTokenizer.t3;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.isEmpty()) return false;
        int length = telNumber.replaceAll("\\D", "").length();
        if (length != 10 && length != 12) return false;
        return telNumber.matches("(^\\+\\d{2})?(\\(\\d{3}\\)|\\d{3})(\\d{7}|\\d*\\-?\\d+\\-?\\d+)");
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+00(120)1378229"));
    }
}

