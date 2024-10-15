package calculator.view;

import calculator.constant.ViewConstants;

public class OutputView {
    public static void printResult(int answer){
        System.out.println(String.format(ViewConstants.OUTPUT_STRING.getMessage() , answer));
    }
}
