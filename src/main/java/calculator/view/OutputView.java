package calculator.view;

import calculator.constant.ViewConstants;

public class OutputView {

    public static void printStart(){
        System.out.println(ViewConstants.INPUT_STRING.getMessage());
    }
    public static void printResult(String answer){
        System.out.println(String.format(ViewConstants.OUTPUT_STRING.getMessage() , answer));
    }
}
