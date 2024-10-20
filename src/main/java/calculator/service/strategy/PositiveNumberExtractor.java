package calculator.service.strategy;

import static calculator.model.RegularExpression.NUMBER_LINE;

import calculator.model.CustomDelimiter;
import calculator.model.PositiveNumber;

public class PositiveNumberExtractor {
    private final SplitPatternGenerator splitStringMaker;
    private final PatternMatcherUtil patternMatcherUtil;

    public PositiveNumberExtractor(SplitPatternGenerator splitStringMaker, PatternMatcherUtil patternMatcherUtil) {
        this.splitStringMaker = splitStringMaker;
        this.patternMatcherUtil = patternMatcherUtil;
    }

    public PositiveNumber getPositiveNumberWithCustomDelimiter(CustomDelimiter customDelimiter,
                                                               String inputString) {
        String numberLine = getPositiveNumberLine(inputString);
        String[] positiveNumberString = numberLine.split(
                splitStringMaker.generateSplitPatternWithCustomDelimiter(customDelimiter));
        return createPositiveNumber(positiveNumberString);
    }

    public PositiveNumber getPositiveNumber(String inputString) {
        String numberLine = getPositiveNumberLine(inputString);
        String[] positiveNumberString = numberLine.split(splitStringMaker.generateSplitPattern());
        return createPositiveNumber(positiveNumberString);
    }

    private String getPositiveNumberLine(String inputString) {
        return patternMatcherUtil.match(NUMBER_LINE.getRegularExpression(), inputString);
    }

    private PositiveNumber createPositiveNumber(String[] positiveNumberString) {
        return PositiveNumber.createPositiveNumber(positiveNumberString);
    }
}
