package level_27;

public class Dom {
    public static void main(String[] args) {
        getFirst();
        getTwo();
    }

    static void getFirst() {
        double height = 2.8;
        double length = 8.63+8.63+4.38+4.49+0.2+4.49+1.77+3.15+0.73+0.29+1+1.45+0.2+3+2.98+2.94+2.07+2.94+2.07+1.4+1.4+2.3+2.3;
        double oknaDveriPloshad = 1.4*(1.4+1.8+1.8) + 2.09*(0.8+0.9+0.8+0.8+1+1+1) + 0.62*1.22;
        double dveriShirina = 0.8-0.9-0.8-1-1-1;

        double allPloshad = height*length - oknaDveriPloshad;
        System.out.println("Площадь стен 1 эт - " + allPloshad);

        double dlinaShvov = 48*2.5 + 36*0.3 + length - dveriShirina + 0.68+0.6+0.6+0.49+0.49+0.6+0.6+0.49+0.49+1.28+1.52+1.8+0.69+1.8+
                0.6+0.49+1.97+1.97+0.7+0.7+0.68+0.68+0.68;
        System.out.println("Длина швов 1 эт - " + dlinaShvov);
    }

    static void getTwo() {
        double height = 2.8;
        double length = 2.95*2+2.07*2+4.21+1.78+3.06+1.18+1.16+2.96+1.3+1.19+2.9+4.37+4.2+3.18+4.23+4.38+4.22+4.37+1.25+2.08+5.46+4.04+
                4.21+1.97;
        double oknaDveriPloshad = 2.1*(0.8*2+0.9*6) + 1.4*(0.9*2+1.8*2+1.4*2) + 2;
        double dveriShirina = 0.8*2+0.9*6;

        double allPloshad = height*length + 2.07+1.18+4.37+4.38+4.04 - oknaDveriPloshad;
        System.out.println("Площадь стен 2 эт - " + allPloshad);

        double dlinaShvov = 71*2.5 + 47*0.3 + 5*0.5+0.7+1+1+2.1+1.75+1.2*2+2*3+0.5+3.03+1.3+0.7+1.29+1.19+2.9+3.8+1+1.81+0.89*2+3.18+
                4.37*2+1.81+0.7+3.43+3.85+4.38*2+3+4.22+0.7*4+1.81+2.3+5.46+4.04*2+6+3.6+1.97;
        System.out.println("Длина швов 2 эт - " + dlinaShvov);
    }
}
