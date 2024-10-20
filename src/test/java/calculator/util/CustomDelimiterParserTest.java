package calculator.util;

import calculator.constant.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CustomDelimiterParserTest {
    @DisplayName("커스텀 구분자 파싱이 성공적으로 이루어지는지 테스트합니다.")
    @ParameterizedTest
    @MethodSource("parseData")
    void parse(String inputStr, String[] expectedResult) {
        String delimiter = ",|:";
        String[] result = CustomDelimiterParser.parse(inputStr, delimiter);
        assertThat(result).isEqualTo(expectedResult);
    }

    static Stream<Arguments> parseData() {
        return Stream.of(
                Arguments.of("1,2,3", new String[]{"1,2,3", ",|:"}),
                Arguments.of("1:2:3", new String[]{"1:2:3", ",|:"}),
                Arguments.of("//;\\n1;2;3", new String[]{"1;2;3", ",|:|;"}),
                Arguments.of("//\\.\\n1;2;3", new String[]{"1;2;3", ",|:|\\."})
        );
    }

    @DisplayName("커스텀 구분자가 올바르지 않은 형식일 때 예외를 던지는지 테스트합니다.")
    @ParameterizedTest
    @MethodSource("invalidCustomDelimiterFormatData")
    void validateInvalidNumberFormat(String inputStr) {
        String delimiter = ",|:";
        assertThatIllegalArgumentException().isThrownBy(() -> CustomDelimiterParser.parse(inputStr,delimiter))
                .withMessage(ExceptionMessage.INVALID_CUSTOM_DELIMITER_FORMAT);
    }

    static Stream<Arguments> invalidCustomDelimiterFormatData() {
        return Stream.of(
                Arguments.of("//n1;2;3"),
                Arguments.of("//n1|2|3"),
                Arguments.of("//5|5|5\n")
        );
    }

}