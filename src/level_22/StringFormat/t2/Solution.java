package level_22.StringFormat.t2;

/*
МНЕ нравитс курс JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(String.format(getFormattedString(), "JavaRush", "курс", "мне", "нравится"));
        //должен быть вывод
        //"МНЕ нравитс курс JavaRush"
    }

    public static String getFormattedString() {
        return "%3$S %4$s %2$s %1$s";
    }
}
