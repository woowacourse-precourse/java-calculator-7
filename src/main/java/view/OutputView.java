package view;

public class OutputView {
    static final String OUTPUT_MESSAGE = "결과 :";

    /**
     * 결과 출력 함수
     * **/
    public void output(int sum){
        System.out.printf("%s %d", OUTPUT_MESSAGE, sum);
    }
}
