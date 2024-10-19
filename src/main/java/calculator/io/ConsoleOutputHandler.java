package calculator.io;

public class ConsoleOutputHandler {

    public void showInputComments(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void showFinalOutput(int sum) {
        System.out.println("결과 : " + sum);
    }
}
