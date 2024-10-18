package calculator.extractor;

import static calculator.util.Message.적용_가능한_구분_토큰이_없습니다;

import java.util.ArrayList;
import java.util.List;

// 복합 TokenExtractor 전략
public class CompositeTokenExtractor implements TokenExtractor {
    private final List<TokenExtractor> extractors;

    public CompositeTokenExtractor(List<TokenExtractor> tokenExtractors) {
        this.extractors = new ArrayList<>(tokenExtractors);
    }

    @Override
    public List<String> extract(String input) {
        for (TokenExtractor extractor : extractors) {
            List<String> result = extractor.extract(input);
            if (result != null && !result.isEmpty()) {
                return result;
            }
        }
        throw new IllegalArgumentException(적용_가능한_구분_토큰이_없습니다);
    }

    public void addExtractor(TokenExtractor extractor) {
        this.extractors.add(extractor);
    }

}