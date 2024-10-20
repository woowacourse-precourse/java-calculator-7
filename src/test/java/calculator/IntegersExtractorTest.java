package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.domain.SplitNumbers;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class IntegersExtractorTest {

    private static final List<Integer> EXPECTED_LIST = List.of(1, 2, 3);

    @Nested
    @DisplayName("성공 테스트")
    class 성공_테스트 {

        @Test
        @DisplayName("성공 - 빈 문자열이 들어올 경우 빈 리스트를 반환한다.")
        void emptyStringTest() {
            runSuccessTest("", List.of());
        }

        @Test
        @DisplayName("성공 - 기본 구분자인 경우")
        void basicDelimiterTest() {
            runSuccessTest("1,2:3", EXPECTED_LIST);
        }

        @Test
        @DisplayName("성공 - 커스텀 구분자가 한 문자 인 경우")
        void singleCustomDelimiterTest() {
            runSuccessTest("//;\\n1;2;3", EXPECTED_LIST);
        }

        @Test
        @DisplayName("성공 - 커스텀 구분자가 여러 문자 인 경우")
        void multiCustomDelimiterTest() {
            runSuccessTest("//;*\\n1;*2;*3", EXPECTED_LIST);
        }

        @Test
        @DisplayName("성공 - 커스텀 구분자와 기본 구분자가 같이 있는 경우")
        void normalAndCustomDelimiterTest() {
            runSuccessTest("//;\\n1;2,3", EXPECTED_LIST);
        }

        @Test
        @DisplayName("성공 - 커스텀 구분자가 n인 경우")
        void customDelimiterNTest() {
            runSuccessTest("//n\\n1n2n3", EXPECTED_LIST);
        }

        @Test
        @DisplayName("성공 - 커스텀 구분자가 //인 경우")
        void customDelimiterDoubleSlashTest() {
            runSuccessTest("////\\n1//2//3", EXPECTED_LIST);
        }

        @Test
        @DisplayName("성공 - 커스텀 구분자가 백슬레시 1개 인 경우")
        void customDelimiterBackslashTest() {
            runSuccessTest("//\\\\n1\\2\\3", EXPECTED_LIST);
        }

        @Test
        @DisplayName("성공 - 커스텀 구분자가 백슬레시 2개인 경우")
        void customDelimiterDoubleBackslashTest() {
            runSuccessTest("//\\\\\\n1\\\\2\\\\3", EXPECTED_LIST);
        }

        private void runSuccessTest(String inputValue, List<Integer> expected) {
            // when
            SplitNumbers numbers = SplitNumbers.from(inputValue);
            // then
            assertThat(numbers.getNumbers()).containsExactlyElementsOf(expected);
        }
    }

    @Nested
    @DisplayName("예외 테스트")
    class 예외_테스트 {

        @Test
        @DisplayName("예외 - 커스텀 구분자가 잘못된 위치에 있는 경우")
        void wrongCustomDelimiterPositionTest() {
            runExceptionTest("\\n;//1;2;3", "잘못된 입력입니다. 커스텀 구분자는 //와 \\n 사이에 위치해야 합니다.");
        }

        @Test
        @DisplayName("예외 - 구분자 사이에 문자가 있는 경우")
        void delimiterInMiddleCharTest() {
            runExceptionTest("1,a:3", "잘못된 입력입니다. 구분자 사이에는 숫자만 입력되어야 합니다.");
        }

        @Test
        @DisplayName("예외 - 구분자 사이에 숫자가 음수인 경우")
        void delimiterInMiddleNegativeIntegerTest() {
            runExceptionTest("1,-1:3", "잘못된 입력입니다. 구분자 사이에 숫자는 양수여야 합니다.");
        }

        @Test
        @DisplayName("예외 - 구분자 사이에 숫자가 0인 경우")
        void delimiterInMiddleZeroTest() {
            runExceptionTest("1,0:3", "잘못된 입력입니다. 구분자 사이에 숫자는 양수여야 합니다.");
        }

        private void runExceptionTest(String inputValue, String expectedMessage) {
            // when // then
            assertThatThrownBy(() -> SplitNumbers.from(inputValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(expectedMessage);
        }
    }
}