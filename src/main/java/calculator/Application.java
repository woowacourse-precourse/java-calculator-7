package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public Application() {
    }

    public void run() {
        String input = getInput();
        System.out.println("결과 : " + input);
    }

    private String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        Console.close();
        return input;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        application.run();
    }
}
