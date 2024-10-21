package calculator.dto;

import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ExpressionDTOTests {

    private String input;
    private String expectedDelimiter, expectedExpression;

    @ParameterizedTest
    @DisplayName("기본 구분자 사용")
    @MethodSource("provideStringForExpression")
    public void whenUseDefaultDelimiter(String inputExp, String expected) {
        input = inputExp;
        expectedDelimiter = "[:,]";
        expectedExpression = expected;
    }
    private static Stream<Arguments> provideStringForExpression() {
        return Stream.of(
                Arguments.of("1:2:3", "1:2:3"),
                Arguments.of("1:2,3", "1:2,3")
        );
    }

    @Test
    @DisplayName("커스텀 구분자 사용 시 구분자와 표현식 변경")
    public void whenUseCustomDelimiter() {
        input = "//;\\n1;2;3";
        expectedDelimiter = "[;]";
        expectedExpression = "1;2;3";
    }

    @Test
    @DisplayName("여러 개의 커스텀 구분자 사용 가능")
    public void whenUseMultipleCustomDelimiter() {
        input = "//abc\\n1a2a3";
        expectedDelimiter = "[abc]";
        expectedExpression = "1a2a3";
    }

    @AfterEach
    public void testSettingCustomDelimiter() {
        ExpressionDTO sample = new ExpressionDTO(input);
        Assertions.assertEquals(expectedDelimiter, sample.getDelimiter());
        Assertions.assertEquals(expectedExpression, sample.getExpression());
    }
}