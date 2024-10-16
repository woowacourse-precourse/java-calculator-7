package calculator.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputTest {
    InputView inputView = new InputView();

    @Nested
    @DisplayName("문자열 입력 성공 테스트")
    class Input_string_test {
        @ParameterizedTest
        @DisplayName("문자열을 입력받을 수 있다")
        @ValueSource(strings = {"1,2:3", "///\n1/2/3", "//\\n1\2\3", "//n\n1n2n3", "// \n1 2 3"})
        void when_input_string_then_return_string(String input) {
            //when - then
            assertThat(inputView.inputString()).isEqualTo(input);
        }
    }

    @Nested
    @DisplayName("문자열 입력 검증 테스트")
    class Input_string_validation_test {

        @Test
        @DisplayName("구분자가 연속해서 나오는 경우에는 예외가 발생한다")
        void when_input_consecutive_delimiter_then_throw_exception() {
            //given
            String input = "1,,2";

            //when - then
            assertThatThrownBy(() -> inputView.validateString(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("양수가 아닌 숫자가 나오는 경우에는 예외가 발생한다")
        void when_input_non_positive_number_then_throw_exception() {
            //given
            String input = "-1,2,3";

            //when - then
            assertThatThrownBy(() -> inputView.validateString(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("숫자가 아닌 문자가 나오는 경우에는 예외가 발생한다")
        void when_input_character_then_throw_exception() {
            //given
            String input = "1,2,a";

            //when - then
            assertThatThrownBy(() -> inputView.validateString(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("지정하지 않은 커스텀 구분자를 사용하는 경우에는 예외가 발생한다")
        void when_use_unspecified_custom_separator_then_throw_exception() {
            //given
            String input = "1[2[3";

            //when - then
            assertThatThrownBy(() -> inputView.validateString(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("커스텀 구분자를 지정할 때 형식이 다른 경우에는 예외가 발생한다")
        void when_use_different_format_of_custom_separator_then_throw_exception() {
            //given
            String input = "/\n1";

            //when - then
            assertThatThrownBy(() -> inputView.validateString(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("구분자 지정 형식 사이에 2개 이상의 문자가 들어가는 경우에는 예외가 발생한다")
        void when_input_more_than_one_custom_separator_then_throw_exception() {
            //given
            String input = "//]]\n1";

            //when - then
            assertThatThrownBy(() -> inputView.validateString(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("구분자로 문자열이 끝나는 경우에는 예외가 발생한다")
        void when_string_ends_with_separator_then_throw_exception() {
            //given
            String input = "1,2,3,";

            //when - then
            assertThatThrownBy(() -> inputView.validateString(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("구분자로 문자열이 시작하는 경우에는 예외가 발생한다")
        void when_string_starts_with_separator_then_throw_exception() {
            //given
            String input = ",1,2,3";

            //when - then
            assertThatThrownBy(() -> inputView.validateString(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("기본 구분자를 커스텀 구분자로 지정하려는 경우에는 예외가 발생한다")
        void when_specify_default_separator_as_custom_separator_then_throw_exception() {
            //given
            String input = "//,\n1,2,3";

            //when - then
            assertThatThrownBy(() -> inputView.validateString(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

}
