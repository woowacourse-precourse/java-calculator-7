package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private String inputString;

    Application(String inputString) {
        this.inputString = inputString;
        initialize();
    }

    public Integer calculate() {
        return 0;
    }

    private void initialize() {

    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Application calculator = new Application(Console.readLine());
        System.out.println(calculator.calculate());
    }
}
