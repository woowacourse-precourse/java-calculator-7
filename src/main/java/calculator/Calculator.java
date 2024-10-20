package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Calculator {

    private String input;
    private List<String> delimiter;
    private CustomDelimterParser customDelimterParser;
    private String analyzingTarget;
    private int sum;

    public Calculator() {
        printStartMessage();
        this.delimiter = new ArrayList<>(List.of(",", ":"));
        this.sum = 0;
        this.customDelimterParser = new CustomDelimterParser(input);
        this.analyzingTarget = "";
    }

    public int start() {
        parsingCustomDelimiter();
        System.out.println(analyzingTarget);
        return 0;
    }

    private void parsingCustomDelimiter() {
        Optional<String> customDelimiter = customDelimterParser.getCustomDelimiter();
        customDelimiter.ifPresent(s -> delimiter.add(s));
        this.analyzingTarget = customDelimterParser.getRemainingInput();
    }

    private void printStartMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        this.input = Console.readLine();
    }

}
