package calculator.parsing;

import calculator.calculator.model.InputString;
import calculator.calculator.model.Numbers;
import calculator.calculator.model.PositiveNumber;
import calculator.extractor.DelimiterExtractor;
import calculator.extractor.NumberExtractor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputParser {

    private final DelimiterExtractor delimiterExtractor;
    private final NumberExtractor numberExtractor;
    private final StringNumberParser stringNumberParser;

    public UserInputParser(DelimiterExtractor delimiterExtractor, NumberExtractor numberExtractor, StringNumberParser stringNumberParser) {
        this.delimiterExtractor = delimiterExtractor;
        this.numberExtractor = numberExtractor;
        this.stringNumberParser = stringNumberParser;
    }

    public Numbers parseInput(InputString input) {
        if (input.value().length() > 50) {
            throw new IllegalArgumentException("입력 길이 제한을 초과했습니다.");
        }

        String delimiter = delimiterExtractor.extractDelimiter(input.value());
        String numbersPart = numberExtractor.extractNumbersPart(input.value());

        String[] parts = numbersPart.split(delimiter, -1);
        List<PositiveNumber> positiveNumbers = Arrays.stream(parts)
                .map(stringNumberParser::parseNumber)
                .map(PositiveNumber::new)
                .collect(Collectors.toList());

        return new Numbers(positiveNumbers);
    }
}
