package calculator.view;

public class OutputView {
    private static final String START_COMMAND="덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_COMMAND="결과 : %d";
    //시작을 출력한다
    public static void printCommand(){
        System.out.println(START_COMMAND);
    }

    public static void printResult(int result) {
        System.out.printf(RESULT_COMMAND,result);
    }
}
