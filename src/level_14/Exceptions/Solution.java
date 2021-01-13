package level_14.Exceptions;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/*
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            String s = "dsfsd";
            System.out.println(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }
        try {
            Object o = null;
            o.toString();
        } catch (NullPointerException e) {
            exceptions.add(e);
        }
        try {
            int[] arr = new int[5];
            int i = arr[6];
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        try {
            Object x = new Integer(0);
            System.out.println((String)x);
        } catch (ClassCastException e) {
            exceptions.add(e);
        }
        try {
            Object x[] = new String[3];
            x[0] = new Integer(0);
        } catch (ArrayStoreException e) {
            exceptions.add(e);
        }
        try {
            String s = "sdfsd";
            s.charAt(15);
        } catch (IndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        try {
            int[] arr = new int[-5];
        } catch (NegativeArraySizeException e) {
            exceptions.add(e);
            exceptions.add(new NoSuchMethodException());
            exceptions.add(new CloneNotSupportedException());
        }

    }
}