package calculator.calculatorApplication.domain.extractor.impl;

import calculator.calculatorApplication.domain.calculation.NumberExtractor;
import calculator.calculatorApplication.domain.extractor.vo.ExtractResult;
import java.util.ArrayList;
import java.util.List;

public class NumberExtractorChain implements NumberExtractor {
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


}

