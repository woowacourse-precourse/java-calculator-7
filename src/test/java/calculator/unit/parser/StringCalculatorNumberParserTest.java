package calculator.unit.parser;

import static calculator.unit.parser.PositiveNumberExceptionMessageTest.NO_NEGATIVE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StringCalculatorNumberParserTest implements NumberParserTest {
    @Override
    public PositiveNumbersTest parseNumbers(List<String> numberStrings) {
        List<Integer> parsedNumbers = numberStrings.stream()
                .filter(StringProcessorTest::isNotEmpty)
                .map(StringProcessorTest::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new PositiveNumbersTest(parsedNumbers);
    }
}


class StringCalculatorNumberParserMethodTest {
    @Nested
    @DisplayName("parseNumbers 테스트 ")
    class parseNumbersTest {

        @Test
        @DisplayName("문자 숫자 리스트 입력시 객체 생성 성공")
        void constructor_ok_1() {
            List<String> numberStrings = List.of("1", "2", "3");
            StringCalculatorNumberParserTest parser = new StringCalculatorNumberParserTest();
            assertThatCode(() -> parser.parseNumbers(numberStrings))
                    .doesNotThrowAnyException();

        }

        @Test
        @DisplayName("양수 입력 시 객체 생성 성공")
        void parseNumbers_ok_1() {
            // given
            List<String> numberStrings = List.of("1", "2", "3");
            StringCalculatorNumberParserTest parser = new StringCalculatorNumberParserTest();
            // when
            PositiveNumbersTest result = parser.parseNumbers(numberStrings);
            // then
            assertThat(result.getValues()).hasSize(3).containsExactly(1, 2, 3);
        }

        @Test
        @DisplayName("음수 입력 시 객체 생성 실패 - 예외 반환")
        void parseNumbers_fail_1() {
            List<String> numberStrings = List.of("-1", "2", "3");
            StringCalculatorNumberParserTest parser = new StringCalculatorNumberParserTest();
            assertThatThrownBy(() -> parser.parseNumbers(numberStrings))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NO_NEGATIVE.getMessage());

        }

        @Test
        @DisplayName("공백 문자열 입력 시 해당 요소 무시")
        void parseNumber_ok_2() {
            // given
            List<String> numberStrings = List.of("1", " ", "3");
            StringCalculatorNumberParserTest parser = new StringCalculatorNumberParserTest();
            // when
            PositiveNumbersTest result = parser.parseNumbers(numberStrings);

            assertThat(result.getValues())
                    .hasSize(2)
                    .containsExactly(1, 3);
        }

        @Test
        @DisplayName("숫자가 아닌 문자열 입력 시 예외 발생")
        void parseNumbers_fail_2() {
            // given
            List<String> numberStrings = List.of("1", "a", "3");
            StringCalculatorNumberParserTest parser = new StringCalculatorNumberParserTest();

            // when.then
            assertThatThrownBy(() -> parser.parseNumbers(numberStrings))
                    .isInstanceOf(NumberFormatException.class);
        }


    }

}