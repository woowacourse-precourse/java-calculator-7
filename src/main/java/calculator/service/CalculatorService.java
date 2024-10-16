package calculator.service;

import java.util.List;
import java.util.Optional;

public class CalculatorService {

    private final List<String> separators;

    public CalculatorService() {
        separators = SeparatorType.getDefaults();
    }

    public void calculate(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
        addCustomSeparatorIfPresent(input);
    }

    private void addCustomSeparatorIfPresent(String input) {
        Optional<String> customSeparator = new CustomSeparatorManager(input).extract();
        customSeparator.ifPresent(separators::add);
    }
}
