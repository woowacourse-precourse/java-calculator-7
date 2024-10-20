package calculator;

import view.Input;
import view.Output;
import domain.StringCalculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Input.getInput();
        StringCalculator calculator = new StringCalculator();

        try{
            int result = calculator.add(input);
            Output.printResult(result);
        } catch(IllegalArgumentException e){
            throw e;
        }
    }
}
