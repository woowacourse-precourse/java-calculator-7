package calculator.extractor;

import static calculator.util.Message.적용_가능한_구분_토큰이_없습니다;

import java.util.ArrayList;
import java.util.List;

// 복합 DelimitedNumberExtractor 전략
public class CompositeDelimitedNumberExtractor implements DelimitedNumberExtractor {
    private final List<DelimitedNumberExtractor> extractors;

    public CompositeDelimitedNumberExtractor(List<DelimitedNumberExtractor> delimitedNumberExtractors) {
        this.extractors = new ArrayList<>(delimitedNumberExtractors);
    }

    @Override
    public List<String> extract(String input) {
        for (DelimitedNumberExtractor extractor : extractors) {
            List<String> result = extractor.extract(input);
            if (result != null && !result.isEmpty()) {
                return result;
            }
        }
        throw new IllegalArgumentException(적용_가능한_구분_토큰이_없습니다);
    }

    public void addExtractor(DelimitedNumberExtractor extractor) {
        this.extractors.add(extractor);
    }

}