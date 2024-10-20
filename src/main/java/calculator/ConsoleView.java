package calculator;

public class ConsoleView {

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

    public void printResult(int result) {
        System.out.println("결과: " + result);
    }

    public void printError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }
}
