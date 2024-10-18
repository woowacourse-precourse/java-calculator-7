package calculator.generator.number.impl;

import calculator.generator.number.NumberExtractService;
import calculator.separator.domain.RegexPattern;

import java.util.List;

public class NumberExtractProcess implements NumberExtractService {
    @Override
    public List<String> extractorNumber(String sentence) {
        return RegexPattern.extractNumberProcess(sentence);
    }
}
