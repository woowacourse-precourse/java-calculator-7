package calculator;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        InputManager input = new InputManager();
        NumberExtractor number = new NumberExtractor();
        Calculator calculator = new Calculator();

        String str = input.getString();

        if(str.equals("Empty")){
            return;
        }

        ArrayList<Integer> extractedNumbers = number.getArray(str);

        calculator.getResult(extractedNumbers);
    }
}
