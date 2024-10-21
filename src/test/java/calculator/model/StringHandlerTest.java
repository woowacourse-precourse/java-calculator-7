package calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringHandlerTest {

    @Nested
    @DisplayName("커스텀 구분자 추출 검증 테스트")
    class Custom_delimiter_validation_test {

        @Test
        @DisplayName("커스텀 구분자로 숫자를 사용하는 경우에는 예외가 발생한다")
        void when_use_number_as_custom_delimiter_then_throw_exception() {
            //given
            StringHandler stringHandler = StringHandler.createStringHandler("//1\\n1,2,3");

            //when - then
            assertThatThrownBy(stringHandler::extractDelimiter)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("구분자 지정 형식 사이에 2개 이상의 문자가 들어가는 경우에는 예외가 발생한다")
        void when_input_more_than_one_custom_separator_then_throw_exception() {
            //given
            StringHandler stringHandler = StringHandler.createStringHandler("//]]\\n1");

            //when - then
            assertThatThrownBy(stringHandler::extractDelimiter)
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("숫자 추출 검증 테스트")
    class Numbers_validation_test {

        @ParameterizedTest
        @DisplayName("지정하지 않은 형식을 사용하는 경우에는 예외가 발생한다")
        @ValueSource(strings = {"HelloWorld!", "/\n1"})
        void when_use_different_format_then_throw_exception() {
            //given
            StringHandler stringHandler = StringHandler.createStringHandler("//]\\n1[2[3");
            stringHandler.extractDelimiter();

            //when - then
            assertThatThrownBy(stringHandler::extractNumbers)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("지정하지 않은 커스텀 구분자를 사용하는 경우에는 예외가 발생한다")
        void when_use_unspecified_custom_separator_then_throw_exception() {
            //given
            StringHandler stringHandler = StringHandler.createStringHandler("//]\\n1[2[3");
            stringHandler.extractDelimiter();

            //when - then
            assertThatThrownBy(stringHandler::extractNumbers)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("구분자로 문자열이 끝나는 경우에는 예외가 발생한다")
        void when_string_ends_with_separator_then_throw_exception() {
            //given
            StringHandler stringHandler = StringHandler.createStringHandler("1,2,3,");
            stringHandler.extractDelimiter();

            //when - then
            assertThatThrownBy(stringHandler::extractNumbers)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("숫자가 아닌 문자가 나오는 경우에는 예외가 발생한다")
        void when_input_character_then_throw_exception() {
            //given
            StringHandler stringHandler = StringHandler.createStringHandler("1,2,a");
            stringHandler.extractDelimiter();

            //when - then
            assertThatThrownBy(stringHandler::extractNumbers)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("양수가 아닌 숫자가 나오는 경우에는 예외가 발생한다")
        void when_input_non_positive_number_then_throw_exception() {
            //given
            StringHandler stringHandler = StringHandler.createStringHandler("-1,2,3");
            stringHandler.extractDelimiter();

            //when - then
            assertThatThrownBy(stringHandler::extractNumbers)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("구분자로 문자열이 시작하는 경우에는 예외가 발생한다")
        void when_string_starts_with_separator_then_throw_exception() {
            //given
            StringHandler stringHandler = StringHandler.createStringHandler(",1,2,3");
            stringHandler.extractDelimiter();

            //when - then
            assertThatThrownBy(stringHandler::extractNumbers)
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("구분자가 연속해서 나오는 경우에는 예외가 발생한다")
        void when_input_consecutive_delimiter_then_throw_exception() {
            //given
            StringHandler stringHandler = StringHandler.createStringHandler("1,,2");
            stringHandler.extractDelimiter();

            //when - then
            assertThatThrownBy(stringHandler::extractNumbers)
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
