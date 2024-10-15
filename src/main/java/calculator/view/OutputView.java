package calculator.view;

import calculator.model.Calculator;

public class OutputView {
    private final static String OUTPUT_MESSAGE = "결과 : ";
    private Integer result;

    public OutputView(Integer result){
        this.result = result;
    }

    public void printResult(){
        System.out.println(OUTPUT_MESSAGE + result);
    }
}
