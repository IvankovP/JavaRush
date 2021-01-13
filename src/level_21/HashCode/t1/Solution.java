package level_21.HashCode.t1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (n == null) return false;
        if (this == n) return true;
        if (!(n instanceof Solution)) return false;

        Solution o = (Solution) n;
        if (first != null ? !o.first.equals(first) : o.first != null) return false;
        if (last != null ? !o.last.equals(last) : o.last != null) return false;

        return true;
    }

    public int hashCode() {
        return Objects.hash(first, last);
    }

    public static void main(String[] args) {
        System.out.println(new Solution("Donald", "Duck").equals(new Solution("Donald", "Duck")));

        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}