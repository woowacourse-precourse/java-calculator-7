package calculator.unit.extractor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StandardDelimiterNumberExtractorTest implements DelimitedNumberExtractorTest {
    private static final String STANDARD_DELIMITERS = ",|:";

    @Override
    public ExtractResultTest extract(String input) {
        if (input.isEmpty()) {
            return new ExtractResultTest(true, Arrays.asList("0"));
        }
        if (!input.contains(",") && !input.contains(":")) {
            return new ExtractResultTest(false, List.of());
        }
        List<String> numbers = Arrays.stream(input.split(STANDARD_DELIMITERS))
                .filter(this::isNumber)
                .collect(Collectors.toList());
        return new ExtractResultTest(true, numbers);
    }

    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

class test {
    @Test
    @DisplayName("extract 메서드 성공 테스트 ")
    void extract_ok() {
        String input = "1,2,3";
        // given
        StandardDelimiterNumberExtractorTest standardDelimiterNumberExtractor = new StandardDelimiterNumberExtractorTest();
        // when
        ExtractResultTest extract = standardDelimiterNumberExtractor.extract(input);

        // then
        Assertions.assertEquals(extract.isExtracted(), true);
        Assertions.assertEquals(extract.getNumbers().get(0), "1");
        Assertions.assertEquals(extract.getNumbers().get(1), "2");
        Assertions.assertEquals(extract.getNumbers().get(2), "3");

    }

//    @ParameterizedTest
//    @DisplayName("extract 메서드 성공 테스트 ")
//    @ValueSource(strings = {
//            "1,2,3",
//            "1,2;3",
//            "1;2,3",
//            "1;2;3"
//
//    })
//    void extract_fail(String input) {
//        // given
//        StandardDelimiterNumberExtractorTest standardDelimiterNumberExtractor = new StandardDelimiterNumberExtractorTest();
//
//        //  when then
//        assertThatThrownBy(() -> standardDelimiterNumberExtractor.extract(input))
//                .isInstanceOf(IllegalArgumentException.class);
//    }


}
