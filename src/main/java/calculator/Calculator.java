package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    private final SplitManager splitManager = new SplitManager();

    public void calculate() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try {
            Input input = new Input(Console.readLine());
            String[] splitString = splitManager.splitString(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
