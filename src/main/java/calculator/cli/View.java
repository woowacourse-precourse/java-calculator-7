package calculator.cli;

import camp.nextstep.edu.missionutils.Console;

public class View {
    private final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private final String OUTPUT_MESSAGE = "결과 : ";

    //초기 메세지를 출력하고, 사용자로부터 값을 입력받음.
    public String getString() {
        System.out.println(INPUT_MESSAGE);

        return Console.readLine();
    }

    public void printResult(int number) {
        System.out.println(OUTPUT_MESSAGE + number);
    }
}
