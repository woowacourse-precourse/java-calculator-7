package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO : input, process, output
    }
}


class Input {
    private static final String INPUT_INSTRUCTION = "덧셈할 문자열을 입력해 주세요.";

    public static String read(){
        System.out.println(INPUT_INSTRUCTION);
        return Console.readLine();
    }
}

