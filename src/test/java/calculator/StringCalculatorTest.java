package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

@DisplayName("[유닛 테스트] - 문자열 계산기")
class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @MethodSource("provideFailCase")
    @DisplayName("문자열에 음수 포함 - 문자열에 음수 포함시 예외 발생")
    void containsNegativeInteger_throwException(String[] numbers) {
        //given & when
        Throwable throwable = catchThrowable(() -> stringCalculator.calculate(numbers));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage("계산할 값에 음수가 포함 되어있습니다.");
    }

    @ParameterizedTest
    @MethodSource("provideSuccessCase")
    @DisplayName("문자열 계산 - 올바른 형식의 문자열 양수 전달 시 양수의 합 반환")
    void properFormatPositiveInteger_returnSum(String[] numbers, int sum) {
        //given & when
        int result = stringCalculator.calculate(numbers);

        //then
        assertThat(result).isEqualTo(sum);
    }

    static Stream<Arguments> provideFailCase() {
        return Stream.of(
                Arguments.arguments((Object) new String[] {"-1", "2", "3"}),
                Arguments.arguments((Object) new String[] {"1", "-2", "3"}),
                Arguments.arguments((Object) new String[] {"1", "2", "-3"})
        );
    }

    static Stream<Arguments> provideSuccessCase() {
        return Stream.of(
                Arguments.arguments(new String[] {"1", "2", "3"}, 6),
                Arguments.arguments(new String[] {"4", "5", "6"}, 15),
                Arguments.arguments(new String[] {"12", "34", "56"}, 102)
        );
    }
}