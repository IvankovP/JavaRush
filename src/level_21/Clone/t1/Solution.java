package level_21.Clone.t1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/*
Глубокое клонирование карты
*/
public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }

        System.out.println(solution.users.equals(clone.users));
        System.out.println(solution.users == clone.users);
        System.out.println(solution.equals(clone));
        System.out.println(solution == clone);
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public User clone() throws CloneNotSupportedException {
            User user = new User(age, name);
            return user;
        }

        public boolean equals(Object o) {
            if (o == null) return false;
            if (o == this) return true;
            if (!(o instanceof User)) return false;

            User u = (User) o;
            return Objects.equals(u.age, age) && Objects.equals(u.name, name);
        }

        public int hashCode() {
            return Objects.hash(age, name);
        }
    }

    public Solution clone() throws CloneNotSupportedException {
        Solution solution = new Solution();
        for (Map.Entry<String, User> user : users.entrySet()) solution.users.put(user.getKey(), user.getValue().clone());
        return solution;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution n = (Solution) o;

        for (Map.Entry<String, User> user : users.entrySet()) {
            if (user != null ? !user.getValue().equals(n.users.get(user.getKey())) : n.users.get(user.getKey()) != null) return false;
        }

        return true;
    }

    public int hashCode() {
        return Objects.hash(users);
    }
}