package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IntegersExtractorTest {
    private final IntegersExtractor integersExtractor = new IntegersExtractor();

    @Nested
    class 성공_테스트 {
        @Test
        @DisplayName("성공 - 기본 구분자인 경우")
        void IntegersExtractorTest() {
            // given
            String inputValue = "1,2:3";
            // when
            List<Integer> integers = integersExtractor.extractIntegers(inputValue);
            // then
            assertThat(integers).containsExactly(1, 2, 3);
        }

        @Test
        @DisplayName("성공 - 커스텀 구분자가 한 문자 인 경우")
        void singleCustomDelimiterTest() {
            // given
            String inputValue = "//;\\n1;2;3";
            // when
            List<Integer> integers = integersExtractor.extractIntegers(inputValue);
            // then
            assertThat(integers).containsExactly(1, 2, 3);
        }

        @Test
        @DisplayName("성공 - 커스텀 구분자가 여러 문자 인 경우")
        void multiCustomDelimiterTest() {
            // given
            String inputValue = "//;*\\n1;*2;*3";
            // when
            List<Integer> integers = integersExtractor.extractIntegers(inputValue);
            // then
            assertThat(integers).containsExactly(1, 2, 3);
        }

        @Test
        @DisplayName("성공 - 커스텀 구분자와 기본 구분자가 같이 있는 경우")
        void normalAndCustomDelimiterTest() {
            // given
            String inputValue = "//;\\n1;2,3";
            // when
            List<Integer> integers = integersExtractor.extractIntegers(inputValue);
            // then
            assertThat(integers).containsExactly(1, 2, 3);
        }

        @Test
        @DisplayName("성공 - 커스텀 구분자가 n인 경우")
        void customDelimiterCase1Test() {
            // given
            String inputValue = "//n\\n1n2n3";
            // when
            List<Integer> integers = integersExtractor.extractIntegers(inputValue);
            // then
            assertThat(integers).containsExactly(1, 2, 3);
        }

        @Test
        @DisplayName("성공 - 커스텀 구분자가 //인 경우")
        void customDelimiterCase2Test() {
            // given
            String inputValue = "////\\n1//2//3";
            // when
            List<Integer> integers = integersExtractor.extractIntegers(inputValue);
            // then
            assertThat(integers).containsExactly(1, 2, 3);
        }

        @Test
        @DisplayName("성공 - 커스텀 구분자가 백슬레시 1개 인 경우")
        void customDelimiterCase3Test() {
            // given
            String inputValue = "//\\\\n1\\2\\3";
            // when
            List<Integer> integers = integersExtractor.extractIntegers(inputValue);
            // then
            assertThat(integers).containsExactly(1, 2, 3);
        }

        @Test
        @DisplayName("성공 - 커스텀 구분자가 백슬레시 2개인 경우")
        void customDelimiterCase4Test() {
            // given
            String inputValue = "//\\\\\\n1\\\\2\\\\3";
            // when
            List<Integer> integers = integersExtractor.extractIntegers(inputValue);
            // then
            assertThat(integers).containsExactly(1, 2, 3);
        }
    }

    @Nested
    class 예외_테스트 {
        @Test
        @DisplayName("예외 - 커스텀 구분자가 잘못된 위치에 있는 경우")
        void wrongCustomDelimiterPositionTest() {
            // given
            String inputValue = "\\n;//1;2;3";
            // when // then
            assertThatThrownBy(() -> integersExtractor.extractIntegers(inputValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("잘못된 입력입니다. 커스텀 구분자는 //와 \\n 사이에 위치해야 합니다.");
        }

        @Test
        @DisplayName("예외 - 구분자 사이에 문자가 있는 경우")
        void delimiterInMiddleCharTest() {
            // given
            String inputValue = "1,a:3";
            // when // then
            assertThatThrownBy(() -> integersExtractor.extractIntegers(inputValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("잘못된 입력입니다. 구분자 사이에는 숫자만 입력되어야 합니다.");
        }

        @Test
        @DisplayName("예외 - 구분자 사이에 숫자가 음수인 경우")
        void delimiterInMiddleNegativeIntegerTest() {
            // given
            String inputValue = "1,-1:3";
            // when // then
            assertThatThrownBy(() -> integersExtractor.extractIntegers(inputValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("잘못된 입력입니다. 구분자 사이에 숫자는 양수여야 합니다.");
        }

        @Test
        @DisplayName("예외 - 구분자 사이에 숫자가 0인 경우")
        void delimiterInMiddleZeroTest() {
            // given
            String inputValue = "1,0:3";
            // when // then
            assertThatThrownBy(() -> integersExtractor.extractIntegers(inputValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("잘못된 입력입니다. 구분자 사이에 숫자는 양수여야 합니다.");
        }

    }


}