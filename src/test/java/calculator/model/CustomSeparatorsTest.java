package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static calculator.constant.Message.EMPTY;
import static calculator.constant.Message.SLASH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("CustomSeparators 객체 테스트")
public class CustomSeparatorsTest {
    @ParameterizedTest(name = "{index} : {3}")
    @DisplayName("CustomSeparators 객체가 숫자를 잘 구분하는지 확인")
    @MethodSource("generateSuccessData")
    void testCorrectSeparated(String separatePart, String calculatePart, List<Integer> output, String message) {
        List<String> inputCustomSeparators = Arrays.stream(separatePart.replaceAll(SLASH, EMPTY)
                .replaceAll("\\\\n", EMPTY).split(EMPTY)).toList();
        CustomSeparators customSeparators = new CustomSeparators(inputCustomSeparators);

        assertThat(customSeparators.separateNumbers(calculatePart)).isEqualTo(output);
    } // testCorrectSeparated

    static Stream<Arguments> generateSuccessData() {
        return Stream.of(
                Arguments.of("//!!\\n", "1!23", List.of(1, 23), "중복 지정할 때"),
                Arguments.of("//:\\n", "1:2:3", List.of(1, 2, 3), "기본 구분자를 지정했을 때"),
                Arguments.of("//-\\n", "1--2", List.of(1, 0, 2), "커스텀 구분자를 연속 입력했을 때"),
                Arguments.of("//;\\n", ";1;2;", List.of(0, 1, 2), "커스텀 구분자를 계산 부분 앞 뒤에 입력했을 때")
        );
    } // generateSuccessData
//
    @ParameterizedTest(name = "{index} : {1}")
    @DisplayName("CustomSeparators 객체 생성 예외 확인")
    @MethodSource("generateExceptionData")
    void testCreateCustomSeparatorsException(String separatePart, String message) {
        List<String> inputCustomSeparators = Arrays.stream(separatePart.split(EMPTY)).toList();

        assertThatThrownBy(() -> new CustomSeparators(inputCustomSeparators))
                .isInstanceOf(IllegalArgumentException.class);
    } // testCreateCustomSeparatorsException

    static Stream<Arguments> generateExceptionData() {
        return Stream.of(
                Arguments.of("//\\n", "공백일 때"),
                Arguments.of("//\\\\n", "\\일 때"),
                Arguments.of("//0\\n", "숫자일 때"),
                Arguments.of("//!@#\\n", "커스텀 구분자의 개수가 2개 초과일 때")
                );
    } // generateExceptionData

    @Test
    @DisplayName("지정한 커스텀 구분자 이외의 문자가 포함되어 있을 때 예외 확인")
    void testContainsOtherCharacters() {
        List<String> inputCustomSeparators = Arrays.stream("//!\\n".replaceAll(SLASH, EMPTY)
                .replaceAll("\\\\n", EMPTY).split(EMPTY)).toList();
        CustomSeparators customSeparators = new CustomSeparators(inputCustomSeparators);

        assertThatThrownBy(() -> customSeparators.separateNumbers("1,2!3"))
                .isInstanceOf(IllegalArgumentException.class);
    } // testContainsOtherCharacters
} // class