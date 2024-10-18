package calculator.numberExtractor;

import calculator.delimiterExtractor.CustomDelimiterExtractor;
import calculator.dto.NumberDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberExtractorTest {


    CustomNumberExtractor customNumberExtractor;
    DefaultNumberExtractor defaultNumberExtractor;

    @BeforeEach
    @Test
    void beforeEach() {

        customNumberExtractor = new CustomNumberExtractor();
        defaultNumberExtractor = new DefaultNumberExtractor();
    }


    @Test
    void 기본구분자_숫자추출() {
        NumberDto numberDTO = defaultNumberExtractor.extractNumbers("1,2:3", ",|:");
        ArrayList<Integer> extractNumbers = numberDTO.getNumberRepository();
        ArrayList<Integer> expectedNumbers = new ArrayList<Integer>(List.of(1, 2, 3));
        Assertions.assertEquals(expectedNumbers, extractNumbers);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4", "1:2:3:4", "1,2,3:4"})
    void 기본구분자_숫자추출_여러케이스(String input) {
        NumberDto numberDTO = defaultNumberExtractor.extractNumbers(input, ",|:");
        ArrayList<Integer> extractNumbers = numberDTO.getNumberRepository();
        ArrayList<Integer> expectedNumbers = new ArrayList<Integer>(List.of(1, 2, 3, 4));
        Assertions.assertEquals(expectedNumbers, extractNumbers);
    }


    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1;2;37", "//;as\\\\\\n1;as\\\\2;as\\\\37"})
    void 커스텀구분자_숫자추출(String input) {
        CustomDelimiterExtractor customDelimiterExtractor = new CustomDelimiterExtractor();
        String extractDelimiter = customDelimiterExtractor.extractDelimiter(input);
        NumberDto numberDTO = customNumberExtractor.extractNumbers(input, extractDelimiter);
        ArrayList<Integer> extractNumbers = numberDTO.getNumberRepository();
        ArrayList<Integer> expectedNumbers = new ArrayList<Integer>(List.of(1, 2, 37));

        Assertions.assertEquals(expectedNumbers, extractNumbers);
    }

}
