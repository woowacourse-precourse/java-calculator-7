package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Processor processor = new Processor();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        processor.extractCustomDelimiter(input);
    }
}
