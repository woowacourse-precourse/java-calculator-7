package calculator;

import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Calculator calculator = new Calculator();

        String input = inputView.getInput();

        int result = calculator.addNumbers(input);

        outputView.printResult(result);

//        System.out.println("1,2,3 = " + calculator.addNumbers("1,2,3"));
//        System.out.println("1:2:3 = " + calculator.addNumbers("1:2:3"));
//        System.out.println("1,2:3 = " + calculator.addNumbers("1,2:3"));
//
//
//        System.out.println("//;\n1;2;3 = " + calculator.addNumbers("//;\n1;2;3"));
//        System.out.println("//@\n2@3@4 = " + calculator.addNumbers("//@\n2@3@4"));
//
//        System.out.println("//@\n2@3@4 = " + calculator.addNumbers("//;\\n1"));
//        System.out.println("'' = " + calculator.addNumber(""));
//        System.out.println("' ' = " + calculator.addNumber(" "));


//        System.out.println("//.\n1.2.3 = " + calculator.addNumbers("//.\n1.2.3"));
//        System.out.println("//*\n1*2*3 = " + calculator.addNumbers("//*\n1*2*3"));

    }
}
