package calculator;

import camp.nextstep.edu.missionutils.Console;
import calculator.inputData.InputData;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = InputData.getInput();
        System.out.println("결과: " + input);
    }
}
