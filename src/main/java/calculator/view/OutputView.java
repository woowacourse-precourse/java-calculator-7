package calculator.view;

public class OutputView {
    private static final String GETOPERAND= "덧셈할 문자열을 입력해 주세요.";
    private static final String OPERATION_RESULT= "결과 : %d";

    public void printGetOperand(){
        print(GETOPERAND);
    }

    public void print(String str){
        System.out.println(str);
    }

    public void printResult(int result){
        System.out.printf((OPERATION_RESULT) + "%n", result);
    }

}
