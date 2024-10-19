package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView ip = new InputView();

        String input = ip.getInput();
        System.out.println(input);
    }
}
