package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Calculator {

    private String input;
    private List<String> delimiter;
    private CustomDelimiterParser customDelimiterParser;
    private String analyzingTarget;
    private DelimiterChecker delimiterChecker;

    public Calculator() {
        printStartMessage();
        this.delimiter = new ArrayList<>(List.of(",", ":"));
        this.customDelimiterParser = new CustomDelimiterParser(input);
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
        delimiterChecker = new DelimiterChecker(analyzingTarget, delimiter);
        return delimiterChecker.splitByDelimiter();
    }

    private void parsingCustomDelimiter() {
        Optional<String> customDelimiter = customDelimiterParser.getCustomDelimiter();
        customDelimiter.ifPresent(s -> delimiter.add(s));
        this.analyzingTarget = customDelimiterParser.getRemainingInput();
    }

    private void printStartMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        this.input = Console.readLine();
    }

}
