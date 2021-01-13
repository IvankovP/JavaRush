package level_23.AnonimClass.t2;

/*
Напрги извилины!
*/
public class Solution {
    private String name;

    Solution(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    private void sout() {
        new Solution("The Darkside Hacker") {
            void printName() {
                System.out.println(getName());
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Solution("Риша").sout();
    }
}
