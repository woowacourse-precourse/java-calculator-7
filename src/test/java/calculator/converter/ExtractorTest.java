package calculator.converter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.utils.CalculatorConstants.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ExtractorTest {

    @ParameterizedTest
    @CsvSource({
            "'//+\\n1,2,3', '[,:+]'",
            "'//_\\n1_2,3', '[,:_]'",
            "'//;\\n1;2;3', '[,:;]'"
    })
    void 구분자_추출_테스트(String value, String expectedDelimiter) {
        String delimiter = Extractor.extractDelimiter(value, DELIMITER_REGEX, CUSTOM_DELIMITER_PREFIX, CUSTOM_DELIMITER_SUFFIX);

        assertThat(delimiter).isEqualTo(expectedDelimiter);
    }

    @ParameterizedTest
    @CsvSource({
            "'//+\\n1,2,3', '1,2,3'",
            "'//_\\n1', '1'",
            "'//;\\n1;2;3', '1;2;3'"
    })
    void 숫자_추출_테스트(String value, String expectedNumberPart) {
        String numberPart = Extractor.extractNumberPart(value, CUSTOM_DELIMITER_PREFIX, CUSTOM_DELIMITER_SUFFIX);

        assertThat(numberPart).isEqualTo(expectedNumberPart);
    }


}
