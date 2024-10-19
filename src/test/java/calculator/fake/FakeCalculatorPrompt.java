package calculator.fake;

import calculator.domain.CalculatorPrompt;
import java.util.List;

public class FakeCalculatorPrompt extends CalculatorPrompt {

    public FakeCalculatorPrompt(String inputData) {
        super(inputData);
    }

    @Override
    protected List<String> parseInput(String command) {
        if (command == null || command.isEmpty()) {
            return List.of();
        }
        if (command.equals("custom")) {
            return List.of("1","2","3","4");
        }
        return List.of("1","2","3");
    }

    @Override
    protected List<String> separate(String inputData) {
        return List.of();
    }

}
