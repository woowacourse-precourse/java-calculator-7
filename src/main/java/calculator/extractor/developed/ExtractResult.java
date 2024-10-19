package calculator.extractor.developed;

import java.util.List;

public class ExtractResult {
    private final boolean extracted;
    private final List<String> numbers;

    public ExtractResult(boolean extracted, List<String> numbers) {
        this.extracted = extracted;
        this.numbers = numbers;
    }

    public boolean isExtracted() {
        return extracted;
    }

    public List<String> getNumbers() {
        return numbers;
    }

}

