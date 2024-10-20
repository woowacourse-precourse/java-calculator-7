package calculator.calculatorApplication.domain.extractor.impl.delimitedNumberExtractorImpl;

import calculator.calculatorApplication.domain.extractor.impl.DelimitedNumberExtractor;
import calculator.calculatorApplication.domain.extractor.vo.ExtractResult;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StandardDelimiterNumberExtractor implements DelimitedNumberExtractor {
    private static final String STANDARD_DELIMITERS = ",|:";
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String ZERO = "0";
    private static final boolean EXTRACTION_SUCCESS = true;
    private static final boolean EXTRACTION_FAILURE = false;

    @Override
    public ExtractResult extract(String input) {
        if (isEmptyInput(input)) {
            return createZeroResult();
        }
        if (!containsStandardDelimiters(input)) {
            return createFailureResult();
        }
        List<String> numbers = extractNumbers(input);
        return createSuccessResult(numbers);
    }

    private boolean isEmptyInput(String input) {
        return input.isEmpty();
    }

    private ExtractResult createZeroResult() {
        return new ExtractResult(EXTRACTION_SUCCESS, Arrays.asList(ZERO));
    }

    private boolean containsStandardDelimiters(String input) {
        return input.contains(COMMA) || input.contains(COLON);
    }

    private ExtractResult createFailureResult() {
        return new ExtractResult(EXTRACTION_FAILURE, List.of());
    }

    private List<String> extractNumbers(String input) {
        return Arrays.stream(input.split(STANDARD_DELIMITERS))
                .filter(this::isNumber)
                .collect(Collectors.toList());
    }

    private ExtractResult createSuccessResult(List<String> numbers) {
        return new ExtractResult(EXTRACTION_SUCCESS, numbers);
    }

    private boolean isNumber(String str) {
        return str.matches("^-?\\d+$");
    }
}