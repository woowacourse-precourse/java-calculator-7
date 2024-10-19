package calculator.view;

public class OutputView {
    private final static String RESULT = "결과 : %d";
    private final static int ZERO = 0;
    public OutputView(){
    }
    public void printResult(int sum){
        System.out.printf(RESULT, sum);
    }
    public void printZero(){
        System.out.println(ZERO);
    }
}
