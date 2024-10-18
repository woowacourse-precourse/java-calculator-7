package calculator.generator.separator.impl;

import calculator.separator.domain.RegexPattern;
import calculator.generator.separator.SeparatorExtractService;

public class SeparatorExtractProcess implements SeparatorExtractService {
    @Override
    public String extractorSeparator(String sentence) {
        return RegexPattern.extractCustomSeparatorProcess(sentence);
    }
}
