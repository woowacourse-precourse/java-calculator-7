package calculator;


import calculator.calculator.CalculatorService;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String s= Console.readLine();
        Config config= new Config(s);
        CalculatorService calculatorService=config.calculatorService();
        System.out.println(calculatorService.calculate());



    }
}
