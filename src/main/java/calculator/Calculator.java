package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private String input;
    private List<String> delimiter;
    private int sum;

    public Calculator() {
        printStartMessage();
        this.delimiter = new ArrayList<>(List.of(",", ":"));
        this.sum = 0;
    }

    private void printStartMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        this.input = Console.readLine();
    }
}
