package calculator.generator.number.impl;

import calculator.generator.number.NumberExtractService;
import calculator.separator.domain.RegexPattern;

public class NumberExtractProcess implements NumberExtractService {
    @Override
    public String extractorNumber(String sentence) {
        return RegexPattern.extractNumberProcess(sentence);
    }
}
