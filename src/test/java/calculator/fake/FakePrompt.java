package calculator.fake;

import calculator.domain.prompt.Prompt;
import java.util.List;

public class FakePrompt extends Prompt {

    public FakePrompt(String inputData) {
        super(inputData);
    }

    @Override
    protected List<String> parseInput(String inputData) {
        if (inputData == null || inputData.isEmpty()) {
            return List.of();
        }
        if (inputData.equals("custom")) {
            return separate("any", '+');
        }
        return separate("any");
    }

    @Override
    protected List<String> separate(String inputData) {
        return List.of("1","2","3");
    }

    @Override
    protected List<String> separate(String inputData, char customDelimiter) {
        return List.of("1","2","3","4");
    }

}
