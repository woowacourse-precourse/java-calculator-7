package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OperationsTest {
    @ParameterizedTest
    @MethodSource("provideTestData")
    void 추출한_숫자_더하기(List<Number> numbers, String expected) {
        //given
        Operations operations = new Operations();

        //when
        String result = operations.add(numbers);

        //then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(Arguments.of(Arrays.asList(new Number("1"), new Number("2"), new Number("3")), "6"),
                Arguments.of(Arrays.asList(new Number("100"), new Number("200"), new Number("300")), "600"),
                Arguments.of(Arrays.asList(new Number("0"), new Number("0"), new Number("0")), "0"),
                Arguments.of(Arrays.asList(new Number("9999999999"), new Number("1")), "10000000000"));
    }
}
