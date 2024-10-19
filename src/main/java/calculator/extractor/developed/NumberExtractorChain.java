package calculator.extractor.developed;

import java.util.ArrayList;
import java.util.List;

public class NumberExtractorChain {
    private final List<DelimitedNumberExtractor> extractors;

    public NumberExtractorChain(List<DelimitedNumberExtractor> extractors) {
        this.extractors = new ArrayList<>(extractors);
    }

    public List<String> extract(String input) {
        for (DelimitedNumberExtractor extractor : extractors) {
            ExtractResult result = extractor.extract(input);
            if (result.isExtracted()) {
                return result.getNumbers();
            }
        }
        throw new IllegalArgumentException("적용 가능한 구분자가 없습니다");
    }

    public void addExtractor(DelimitedNumberExtractor extractor) {
        extractors.add(extractor);
    }

    public void removeExtractor(DelimitedNumberExtractor extractor) {
        extractors.remove(extractor);
    }
}

