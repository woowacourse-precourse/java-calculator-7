package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Application {
    private final CustomParser customParser;

    public Application() {
        this.customParser = new CustomParser();
    }

    public void run() {
        String input = getInput();
        int[] numbers = this.customParser.parse(input);
        System.out.println("결과 : " + Arrays.toString(numbers));
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
