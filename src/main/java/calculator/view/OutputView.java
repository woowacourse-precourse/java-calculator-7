package calculator.view;

import calculator.model.Calculator;

public class OutputView {
    private final static String OUTPUT_MESSAGE = "결과 : ";
    private final Integer result;

    public OutputView(Integer result){
        this.result = result;
    }

    /**
     * 계산 결과를 출력합니다.
     */
    public void printResult(){
        System.out.println(OUTPUT_MESSAGE + result);
    }
}
