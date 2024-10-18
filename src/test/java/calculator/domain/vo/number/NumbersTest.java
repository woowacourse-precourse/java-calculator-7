package calculator.domain.vo.number;

import static org.assertj.core.api.Assertions.*;

import calculator.domain.vo.delimiter.Delimiters;
import calculator.infrastructure.exception.ErrorCode;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Numbers 테스트")
class NumbersTest {

    @Test
    void Numbers_객체가_정상적으로_생성() {
        // given
        List<Number> input = List.of(Number.from("1"), Number.from("2"), Number.from("3"));

        // when
        Numbers numbers = Numbers.from(input);

        // then
        assertThat(numbers).isNotNull();
    }

    @Test
    void Numbers_객체가_비었다면_예외를_발생() {
        // when & then
        assertThatThrownBy(() -> Numbers.from(new ArrayList<>()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorCode.INVALID_COLLECTION.getMessage());
    }

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
        "1,2,3; 6",
        "1,2:3,4; 10"
    })
    void 기본_Delimiters가_포함된_입력에서_총합을_반환(String input, BigInteger expectedSum) {
        // when
        Delimiters delimiters = Delimiters.from(input);
        Numbers numbers = Numbers.extractFrom(input, delimiters);

        // then
        assertThat(numbers.reduce()).isEqualTo(expectedSum);
    }

    @ParameterizedTest
    @MethodSource("customDelimiterTestCases")
    void Custom_Delimiter가_포함된_입력에서_총합을_반환(String input, BigInteger expectedSum) {
        // when
        Delimiters delimiters = Delimiters.from(input);
        Numbers numbers = Numbers.extractFrom(input, delimiters);

        // then
        assertThat(numbers.reduce()).isEqualTo(expectedSum);
    }

    private static Stream<Arguments> customDelimiterTestCases() {
        return Stream.of(
            Arguments.of("//*\n1*2*3", BigInteger.valueOf(6)),
            Arguments.of("//A\n1A2A3A4", BigInteger.valueOf(10)),
            Arguments.of("//;\n1;2;10", BigInteger.valueOf(13))
        );
    }


}