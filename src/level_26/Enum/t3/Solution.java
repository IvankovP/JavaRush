package level_26.Enum.t3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            if (loadWheelNamesFromDB().length != 4) throw new NullPointerException();
            wheels = new ArrayList<>();
            for (String wheel : loadWheelNamesFromDB()) {
                try{
                    wheels.add(Wheel.valueOf(wheel));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT2"};
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        for (Wheel wheel : car.wheels) System.out.println(wheel);

    }
}

