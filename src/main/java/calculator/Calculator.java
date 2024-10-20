package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Calculator {

    private String input;
    private List<Delimiter> delimiters;
    private SingleCustomDelimiterParser singleCustomDelimiterParser;
    private String analyzingTarget;
    private DelimiterChecker delimiterChecker;

    public Calculator() {
        printStartMessage();
        this.delimiters = new ArrayList<>(List.of(new Delimiter(","), new Delimiter(":")));
        this.singleCustomDelimiterParser = new SingleCustomDelimiterParser(input);
        this.analyzingTarget = "";
    }

    public void start() {
        parsingCustomDelimiter();
        List<Integer> sumTarget = getSumTarget();
        int sum = calculateSum(sumTarget);
        System.out.println("결과 : " + sum);
    }

    private int calculateSum(List<Integer> sumTarget) {
        return sumTarget.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private List<Integer> getSumTarget() {
        delimiterChecker = new DelimiterChecker(analyzingTarget, delimiters);
        return delimiterChecker.splitByDelimiter();
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
