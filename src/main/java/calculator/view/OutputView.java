package calculator.view;

public class OutputView {
    private static final String GETOPERAND= "덧셈할 문자열을 입력해 주세요.";
    private static final String OPERATION_RESULT= "결과 : %d";
    //나는 왜 관습적으로 함수의 맨 앞에를 소문자로 했을까?
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
