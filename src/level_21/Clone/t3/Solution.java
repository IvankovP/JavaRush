package level_21.Clone.t3;

/*
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
        
        public B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B implements Cloneable {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        public C clone() throws CloneNotSupportedException {
            C c = new C(getI(), getJ(), getName());
            return c;
        }
    }

    public static void main(String[] args) {
        C c = new C(1, 2, "111");
        B b = new B(1, 2, "222");
        C cloneC = null;
        B cloneB = null;
        try {
            cloneC = c.clone();
            cloneB = b.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(c);
        System.out.println(cloneC);
        System.out.println(c.equals(cloneC));
        System.out.println(c == cloneC);
    }
}