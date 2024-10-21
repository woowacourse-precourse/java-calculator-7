package calculator;

import view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Calculator calculator = new Calculator();
        String input = inputView.getInput();
        System.out.println("test =" + calculator.addNumbers(input));

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
