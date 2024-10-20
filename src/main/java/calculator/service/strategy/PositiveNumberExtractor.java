package calculator.service.strategy;

import static calculator.model.RegularExpression.NUMBER_LINE;

import calculator.model.CustomDelimiter;
import calculator.model.PositiveNumber;
import calculator.validator.ValidationUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PositiveNumberExtractor {
    private final SplitPatternGenerator splitStringMaker;

    public PositiveNumberExtractor(SplitPatternGenerator splitStringMaker) {
        this.splitStringMaker = splitStringMaker;
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
        Pattern pattern = Pattern.compile(NUMBER_LINE.getRegularExpression());
        Matcher numberLineMatcher = pattern.matcher(inputString);
        ValidationUtils.validateNumberLineExist(numberLineMatcher);
        return numberLineMatcher.group(2);
    }

    private PositiveNumber createPositiveNumber(String[] positiveNumberString) {
        return PositiveNumber.createPositiveNumber(positiveNumberString);
    }
}
