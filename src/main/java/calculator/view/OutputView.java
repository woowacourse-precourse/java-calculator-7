package calculator.view;

import static calculator.constant.ViewConstant.*;

public class OutputView {

    public static void startCalculator(){
        System.out.println(START_OUT_VIEW);
    }

    public static void printResult(Number calculatorResult){
        String calculatorOutPut = RESULT_OUT_VIEW + calculatorResult;
        System.out.println(calculatorOutPut);
    }
}
