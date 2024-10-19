package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("DefaultSeparators 객체 테스트")
class DefaultSeparatorsTest {
    @ParameterizedTest(name = "{index} : {2}")
    @DisplayName("DefaultSeparators 객체가 숫자를 잘 구분하는지 확인")
    @MethodSource("generateSuccessData")
    void testCorrectSeparated(String input, List<Integer> output,String message) {
        assertThat(new DefaultSeparators().separateNumbers(input)).isEqualTo(output);
    } // testDefaultSeparator

    static Stream<Arguments> generateSuccessData() {
        return Stream.of(
                Arguments.of("1::2:3", List.of(1, 0, 2, 3), "기본 구분자를 연속 입력했을 때"),
                Arguments.of(",1,2,3,", List.of(0, 1, 2, 3), "기본 구분자를 계산 부분 앞 뒤에 입력했을 때")
        );
    } // generateSuccessData

    @Test
    @DisplayName("기본 구분자 이외의 문자가 포함되어 있을 때 예외 확인")
    void testContainsOtherCharacters() {
        assertThatThrownBy(() -> new DefaultSeparators().separateNumbers("1,2!3"))
                .isInstanceOf(IllegalArgumentException.class);
    } // testContainsOtherCharacters
} // class