package calculator.service.generator.number.impl;

import calculator.service.generator.number.NumberExtractService;
import calculator.regex.domain.RegexPattern;

import java.util.List;

public class NumberExtractProcess implements NumberExtractService {
    @Override
    public List<String> extractorNumber(String sentence) {
        return RegexPattern.extractNumberProcess(sentence);
    }
}
