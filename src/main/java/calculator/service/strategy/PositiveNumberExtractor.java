package calculator.service.strategy;

import static calculator.model.RegularExpression.NUMBER_LINE;

import calculator.model.PositiveNumber;
import calculator.model.delimiter.Delimiter;

public class PositiveNumberExtractor {
    private final SplitPatternGenerator splitPatternGenerator;
    private final PatternMatcher patternMatcher;

    public PositiveNumberExtractor(SplitPatternGenerator splitPatternGenerator, PatternMatcher patternMatcher) {
        this.splitPatternGenerator = splitPatternGenerator;
        this.patternMatcher = patternMatcher;
    }

    public PositiveNumber extractPositiveNumber(Delimiter delimiter, String inputString) {
        String numberLine = extractPositiveNumberLine(inputString);
        String[] positiveNumberString = numberLine.split(
                splitPatternGenerator.generateSplitPattern(delimiter));
        return createPositiveNumber(positiveNumberString);
    }

    private String extractPositiveNumberLine(String inputString) {
        return patternMatcher.findFirstGroup(NUMBER_LINE.getRegularExpression(), inputString);
    }

    private PositiveNumber createPositiveNumber(String[] positiveNumberString) {
        return PositiveNumber.createPositiveNumber(positiveNumberString);
    }
}
