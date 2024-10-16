package calculator.fake;

import calculator.domain.prompt.Prompt;
import java.util.List;

public class FakePrompt extends Prompt {

    public FakePrompt(String inputData) {
        super(inputData);
    }

    public FakePrompt(String inputData, char customDelimiter) {
        super(inputData, customDelimiter);
    }

    @Override
    protected List<String> separate(String inputData) {
        if (inputData == null || inputData.isEmpty()) {
            return List.of();
        }
        return List.of("1","2","3");
    }

    @Override
    protected List<String> separate(String inputData, char customDelimiter) {
        if (inputData == null || inputData.isEmpty()) {
            return List.of();
        }
        return List.of("1","2","3","4");
    }

}
