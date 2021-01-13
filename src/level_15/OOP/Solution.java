package level_15.OOP;

/*
Статики и котики
*/

public class Solution {
    public static Cat cat;

    static {
        cat = new Cat();
        cat.name = "asdasd";
        System.out.println(cat.name);
    }

    public static void main(String[] args) {

    }

    public static class Cat {
        public String name;
    }
}

