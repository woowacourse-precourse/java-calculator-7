package calculator.core.service;

import calculator.converter.StringToPositiveBigIntegerConverter;
import calculator.extractor.TextCustomDelimiterExtractor;
import calculator.splitter.TextDelimiterSplitter;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import static calculator.delimiter.BasicDelimiter.getBasicDelimiters;
import static calculator.delimiter.CustomDelimiter.getCustomDelimiters;
import static calculator.delimiter.CustomDelimiter.hasCustomDelimiter;
import static calculator.util.StringUtils.hasText;
import static java.math.BigInteger.ZERO;

public class CalculateService {

    private final TextDelimiterSplitter textDelimiterSplitter;
    private final TextCustomDelimiterExtractor textCustomDelimiterExtractor;
    private final StringToPositiveBigIntegerConverter stringToPositiveBigIntegerConverter;

    public CalculateService() {
        this.textDelimiterSplitter = new TextDelimiterSplitter();
        this.textCustomDelimiterExtractor = new TextCustomDelimiterExtractor();
        this.stringToPositiveBigIntegerConverter = new StringToPositiveBigIntegerConverter();
    }

    public BigInteger calculate(String input) {
        if (!hasText(input)) {
            return ZERO;
        }

        if (!hasCustomDelimiter(input)) {
            return sum(textDelimiterSplitter.split(input, getBasicDelimiters()));
        }

        Set<String> delimiters = getCustomDelimiters(textCustomDelimiterExtractor.extractCustomDelimiter(input));
        String text = textCustomDelimiterExtractor.extractText(input);

        List<String> list = textDelimiterSplitter.split(text, delimiters);

        return sum(list);
    }

    private BigInteger sum(List<String> list) {
        return list.stream()
                .map(stringToPositiveBigIntegerConverter::convert)
                .reduce(ZERO, BigInteger::add);
    }
}
