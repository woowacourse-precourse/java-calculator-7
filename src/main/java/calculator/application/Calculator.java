package calculator.application;

import calculator.application.util.CustomSeparatorUtil;
import calculator.application.util.NumberInputUtil;
import calculator.application.util.io.print.CommandPrinter;
import calculator.application.util.io.print.ResultPrinter;
import calculator.application.util.io.read.InputReader;

import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;


public class Calculator{

    private static final String SEPARATOR_COMMA = ",";
    private static final String SEPARATOR_COLON = ":";

    private final Set<String> separators;
    private final List<Long> numbers;

    public Calculator() {
        this.separators = new HashSet<>();
        this.numbers = new ArrayList<>();
        separators.add(SEPARATOR_COMMA);
        separators.add(SEPARATOR_COLON);
    }

    public void execute() {
        init();
        long result = calculate();
        close(result);
    }

    private void init() {
        CommandPrinter.printStartCommand();
        String input = InputReader.read();

        applyCustomSeparator(input);
        applyInputNumbers(input);
    }

    private void applyCustomSeparator(String input) {
        if (CustomSeparatorUtil.hasCustomSeparator(input)){
            String customSeparator = CustomSeparatorUtil.extractCustomSeparator(input);
            this.separators.add(customSeparator);
        }
    }

    private void applyInputNumbers(String input) {
        if (CustomSeparatorUtil.hasCustomSeparator(input)) {
            input = CustomSeparatorUtil.extractExcludeCustomSeparator(input);
        }
        if (NumberInputUtil.hasInvalidSymbol(input, this.separators)) {
            throw new IllegalArgumentException();
        }
        List<Long> inputNumbers = NumberInputUtil.extractNumbers(input, this.separators);
        this.numbers.addAll(inputNumbers);
    }

    private long calculate() {
        long result = 0L;
        for (long number : numbers) {
            result += number;
        }
        return result;
    }

    private void close(long result) {
        ResultPrinter.printResult(result);
    }

}
