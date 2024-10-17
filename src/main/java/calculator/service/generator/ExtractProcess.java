package calculator.service.generator;

import calculator.separator.domain.RegexPattern;
import calculator.number.service.NumberExtractService;
import calculator.separator.service.SeparatorExtractService;

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
