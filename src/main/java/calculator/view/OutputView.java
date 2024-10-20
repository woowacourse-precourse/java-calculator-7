package calculator.view;

public class OutputView {

    static final String OUTPUT_MESSAGE = "결과 :";

    public void output(int sum){
        System.out.printf("%s %d", OUTPUT_MESSAGE, sum);
    }
}
