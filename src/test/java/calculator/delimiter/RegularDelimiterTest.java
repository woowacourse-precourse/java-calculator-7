package calculator.delimiter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class RegularDelimiterTest {

    private final RegularDelimiter regularDelimiter = new RegularDelimiter();

    @ParameterizedTest
    @MethodSource("provideExtractStringTestCases")
    @DisplayName("쉼표와 콜론 구분자로 숫자를 분리하여 리턴한다.")
    void testExtractString(String input, List<String> expectedNumbers) {
        List<String> result = regularDelimiter.extractString(input);
        assertThat(result).isEqualTo(expectedNumbers);
    }

    private static Stream<Arguments> provideExtractStringTestCases() {
        return Stream.of(
                arguments("1,2,3", List.of("1", "2", "3")),   // 쉼표 구분자
                arguments("4:5:6", List.of("4", "5", "6")),   // 콜론 구분자
                arguments("7,8:9", List.of("7", "8", "9"))    // 쉼표와 콜론 혼합
        );
    }

    @ParameterizedTest
    @CsvSource(delimiter = '=', value = {
            "1,2,3= true",    // 쉼표 포함
            "4:5:6= true",    // 콜론 포함
            "7,8:9= true",    // 쉼표와 콜론 혼합
            "12345= false"    // 구분자 없음
    })
    @DisplayName("입력에 쉼표나 콜론이 포함되어 있는지 확인한다.")
    void testApplicable(String input, boolean expected) {
        boolean result = regularDelimiter.applicable(input);

        assertThat(result).isEqualTo(expected);
    }
}
