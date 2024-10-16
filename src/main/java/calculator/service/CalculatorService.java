package calculator.service;

import java.util.List;
import java.util.Optional;

public class CalculatorService {

    private final List<String> separators;
    private String input;

    public CalculatorService(String input) {
        separators = SeparatorType.getDefaults();
        this.input = input;
    }

    public void calculate() {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
        addCustomSeparatorIfPresent();
        String[] separatedValues = split();
    }

    private void addCustomSeparatorIfPresent() {
        Optional<String> customSeparator = new CustomSeparatorManager(input).extract();
        customSeparator.ifPresent(separators::add);
        this.input = input.replaceAll("//.*\\\\n", "");
    }

    private String[] split() {
        return new SeparatorSplitter(separators, input).split();
    }
}
