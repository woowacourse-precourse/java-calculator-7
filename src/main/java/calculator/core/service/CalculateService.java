package calculator.core.service;

import calculator.converter.StringToBigIntegerConverter;
import calculator.extractor.StringDelimiterExtractor;
import calculator.extractor.result.StringDelimiterResult;
import calculator.splitter.TextDelimiterSplitter;

import java.math.BigInteger;
import java.util.List;

import static calculator.util.StringUtils.hasText;
import static java.math.BigInteger.ZERO;

public class CalculateService {

    private final TextDelimiterSplitter splitter;
    private final StringDelimiterExtractor extractor;
    private final StringToBigIntegerConverter converter;

    public CalculateService() {
        this.splitter = new TextDelimiterSplitter();
        this.extractor = new StringDelimiterExtractor();
        this.converter = new StringToBigIntegerConverter();
    }

    public BigInteger calculate(String input) {
        if (!hasText(input)) {
            return ZERO;
        }

        StringDelimiterResult extractedResult = extractor.extract(input);
        List<String> list = splitter.split(extractedResult.text(), extractedResult.getDelimiters());

        return sum(list);
    }

    private BigInteger sum(List<String> list) {
        return list.stream().map(converter::convert).reduce(ZERO, BigInteger::add);
    }
}
