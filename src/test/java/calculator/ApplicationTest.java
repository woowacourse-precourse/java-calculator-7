package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        @DisplayName("기본 구분자로 덧셈 결과를 올바르게 출력한다")
        void testValidDefaultDelimiter() {
            // given
            String input = "1,2:3";

            // when & then
            assertSimpleTest(() -> {
                run(input);
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        @DisplayName("커스텀 구분자로 덧셈 결과를 올바르게 출력한다")
        void testValidCustomDelimiter() {
            // given
            String input = "//;\\n11;22;33";

            // when & then
            assertSimpleTest(() -> {
                run(input);
                assertThat(output()).contains("결과 : 66");
            });
        }

        @Test
        @DisplayName("입력이 빈 문자열인 경우 0을 반환한다")
        void testEmptyInput() {
            // given
            String input = " ";

            // when & then
            assertSimpleTest(() -> {
                run(input);
                assertThat(output()).contains("결과 : 0");
            });
        }

        @Test
        @DisplayName("입력에 공백이 포함되어도 올바르게 처리된다")
        void testWhitespaceInput() {
            // given
            String input = " 1 , 2 : 3 ";

            // when & then
            assertSimpleTest(() -> {
                run(input);
                assertThat(output()).contains("결과 : 6");
            });
        }

        @Test
        @DisplayName("입력에 숫자가 하나만 있는 경우 올바르게 처리된다")
        void testSingleNumberInput() {
            // given
            String input = "5";

            // when & then
            assertSimpleTest(() -> {
                run(input);
                assertThat(output()).contains("결과 : 5");
            });
        }
    }

    @Nested
    @DisplayName("유효하지 않은 경우")
    class InvalidCases {

        @Test
        @DisplayName("입력이 null이면 IllegalArgumentException을 발생시킨다")
        void testNullInput() {
            // given
            String input = null;

            // when & then
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @ParameterizedTest
        @DisplayName("입력에 0이나 음수가 포함되면 IllegalArgumentException을 발생시킨다")
        @ValueSource(ints = {0, -1, -5, -10})
        void testZeroOrNegativeInput(int invalidNumber) {
            // given
            String input = invalidNumber + ",2,3";

            // when & then
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("입력이 잘못된 구분자 양식이면 IllegalArgumentException을 발생시킨다")
        void testInvalidFormatInput() {
            // given
            String input = "&&;\\n1;2;3";

            // when & then
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("입력에 숫자가 아닌 문자열이 포함된 경우 IllegalArgumentException을 발생시킨다")
        void testNonNumericInput() {
            // given
            String input = "1,2,ABC";

            // when & then
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("입력에 구분자가 연속으로 사용된 경우 IllegalArgumentException을 발생시킨다")
        void testInvalidDelimiterInput() {
            // given
            String input = "1,,2::3";

            // when & then
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
