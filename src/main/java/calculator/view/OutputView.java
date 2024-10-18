package calculator.view;

public class OutputView {

    private static final String OUTPUT_MESSAGE = "결과 : ";

    public void printResult(Object value){
        System.out.println(OUTPUT_MESSAGE + value);
    }

}
