package calculator.util;

import calculator.constant.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberExtractorTest {
    @DisplayName("숫자 추출이 성공적으로 이루어지는지 테스트합니다.")
    @ParameterizedTest
    @MethodSource("extractData")
    void extract(String inputStr, List<Integer> expectedResult) {
        String delimiter = ",|:|;|\\.";
        List<Integer> result = NumberExtractor.extractNums(inputStr, delimiter);
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("음수 또는 0이 포함된 숫자일 경우 예외를 던지는지 테스트합니다.")
    @ParameterizedTest
    @MethodSource("underZeroData")
    void validateNegativeOrZeroNumber(String inputStr) {
        String delimiter = ",|:";
        assertThatIllegalArgumentException().isThrownBy(() -> NumberExtractor.extractNums(inputStr,delimiter))
                .withMessage(ExceptionMessage.UNDER_ZERO_NOT_ALLOW);
    }

    @DisplayName("잘못된 형식의 숫자일 경우 예외를 던지는지 테스트합니다.")
    @ParameterizedTest
    @MethodSource("invalidNumberFormatData")
    void validateInvalidNumberFormat(String inputStr) {
        String delimiter = ",|:";
        assertThatIllegalArgumentException().isThrownBy(() -> NumberExtractor.extractNums(inputStr,delimiter))
                .withMessage(ExceptionMessage.INVALID_NUMBER_FORMAT);
    }

    static Stream<Arguments> extractData() {
        return Stream.of(
                Arguments.of("1,2,3", List.of(1,2,3)),
                Arguments.of("1:2:3", List.of(1,2,3)),
                Arguments.of("1;2;3", List.of(1,2,3)),
                Arguments.of("1.2.3", List.of(1,2,3)),
                Arguments.of("5.10;15", List.of(5,10,15))
        );
    }

    static Stream<Arguments> underZeroData() {
        return Stream.of(
                Arguments.of("-1,2,3"),
                Arguments.of("0,2,3"),
                Arguments.of("1,2,0")
        );
    }

    static Stream<Arguments> invalidNumberFormatData() {
        return Stream.of(
                Arguments.of("1,2,abc"),
                Arguments.of("1,1.5,3")
        );
    }
}