package calculator;

import java.util.ArrayList;

public class Application {
    public static boolean flag = false;
    public static void main(String[] args) {
        InputManager input = new InputManager();
        NumberExtractor number = new NumberExtractor();
        Calculator calculator = new Calculator();

        String str = input.getString();

        if(flag){return;}
        ArrayList<Integer> extractedNumbers = number.getArray(str);

        if(flag){return;}

        calculator.getResult(extractedNumbers);
    }
}
