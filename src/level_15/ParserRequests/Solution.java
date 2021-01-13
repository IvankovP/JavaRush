package level_15.ParserRequests;

/*
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//http://proglang.su?ggggg=234&ddddd&ssss=FFFFF&obj=3.14&obj=50&obj=sdfsdfsfsdf

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String URL = reader.readLine();
        reader.close();

        URL = URL.substring(URL.indexOf("?")+1);
        String[] subString = URL.split("&");
        String[] subString2;
        ArrayList<String> arrayValues = new ArrayList<>();
        StringBuilder parameters = new StringBuilder();

        for(String s : subString) {
            if (s.contains("=")) {
                subString2 = s.split("=");
                parameters.append(subString2[0]);
                parameters.append(" ");
                if (subString2[0].equals("obj")) arrayValues.add(subString2[1]);
            }
            else {
                parameters.append(s);
                parameters.append(" ");
            }
        }
        System.out.println(parameters);
        for (String s : arrayValues) {
            try {
                alert(Double.parseDouble(s));
            } catch (Exception e) {
                alert(s);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}

