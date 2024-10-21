package calculator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DelimiterParserTest {
    DelimiterParser parser = new DelimiterParser();

    static Stream<Arguments> successfulInputs() {
        return Stream.of(
                Arguments.of("1,2:3", new String[]{"1", "2", "3"}),
                Arguments.of("//;\\n1;2;3", new String[]{"1", "2", "3"}),
                Arguments.of("//;\\n1;2,3:4;5", new String[]{"1", "2", "3", "4", "5"})
        );
    }

    @ParameterizedTest
    @MethodSource("successfulInputs")
    @DisplayName("기본 구분자, 커스텀 구분자, 혼합 구분자를 사용하여 숫자 추출에 성공한다.")
    void 숫자_추출_성공_기본_및_커스텀_구분자(String input, String[] expected) {
        //when
        String[] result = parser.parseNumbers(input);

        //then
        assertArrayEquals(expected, result);
    }

}
