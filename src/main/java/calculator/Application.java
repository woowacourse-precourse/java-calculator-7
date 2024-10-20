package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // Declare Strategy Context Class, Calculator
        Calculator addCalculator = new Calculator(new Add());
    }

}
