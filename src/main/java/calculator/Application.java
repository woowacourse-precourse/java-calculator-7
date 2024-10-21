package calculator;

import calculator.input.Input;
import calculator.stringCalculator.StringCalculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input.printInputMessage();
        String userInput = Input.getUserMessage();

        try{
            StringCalculator stringCalculator = new StringCalculator();
            int result = stringCalculator.add(userInput);
            System.out.println("결과 : " + result);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
