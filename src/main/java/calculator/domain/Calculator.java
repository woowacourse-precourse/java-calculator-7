package calculator.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Calculator {

    private String input;
    private List<Delimiter> delimiters;
    private SingleCustomDelimiterParser singleCustomDelimiterParser;
    private String analyzingTarget;
    private Adder adder;
    private DelimiterSplitter delimiterSplitter;

    public Calculator(Adder adder) {
        printStartMessage();
        this.delimiters = new ArrayList<>(List.of(new Delimiter(","), new Delimiter(":")));
        this.singleCustomDelimiterParser = new SingleCustomDelimiterParser(input);
        this.adder = adder;
        this.analyzingTarget = "";
    }

    public void start() {
        parsingCustomDelimiter();
        List<Number> sumTargets = getSumTargets();
        int sum = adder.calculateSum(sumTargets);
        System.out.println("결과 : " + sum);
    }

    private List<Number> getSumTargets() {
        delimiterSplitter = new DelimiterSplitter(analyzingTarget, delimiters);
        return delimiterSplitter.splitByDelimiter();
    }

    private void parsingCustomDelimiter() {
        Optional<Delimiter> customDelimiter = singleCustomDelimiterParser.getCustomDelimiter();
        customDelimiter.ifPresent(s -> delimiters.add(s));
        this.analyzingTarget = singleCustomDelimiterParser.getRemainingInput();
    }

    private void printStartMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        this.input = Console.readLine();
    }

}
