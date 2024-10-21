package calculator.view;

public class OutputView{

    private static final String OUTPUT_MESSAGE = "결과 : ";

    public void print(int result) {
        System.out.println(OUTPUT_MESSAGE + result);
    }
}
