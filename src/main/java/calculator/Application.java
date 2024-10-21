package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        String input = application.getInputString();
        application.printResult(1);
    }

    private String getInputString() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        return Console.readLine();
    }

    private void printResult(int result) {
        System.out.print("결과 : " + result);
    }
}