package calculator.view;

public class OutputView {
    private static final String RESULT_MESSAGE="결과 : ";

    public void printSum(int sum){
        System.out.print(RESULT_MESSAGE);
        System.out.println(sum);
    }
}
