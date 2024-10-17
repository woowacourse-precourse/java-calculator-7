package calculator.separator.service;

import calculator.separator.domain.RegexPattern;

public class ExtractProcess implements SeparatorExtractService, NumberExtractService {
    @Override
    public String extractorSeparator(String sentence) {
        return RegexPattern.extractCustomSeparatorProcess(sentence);
    }

    @Override
    public String extractorNumber(String sentence) {
        return RegexPattern.extractNumberProcess(sentence);
    }
}
