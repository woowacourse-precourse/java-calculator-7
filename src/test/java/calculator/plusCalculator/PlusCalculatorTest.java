package calculator.plusCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PlusCalculatorTest {

    PlusCalculator plusCalculator = new PlusCalculator(Arrays.asList(",", ":"));

    @Nested
    class findCustomSeparator {
        @Test
        @DisplayName("커스텀 구분자가 1개")
        void Separator1() {
            String input = "//;\\n1,2;3";
            String result = plusCalculator.findCustomSeparator(input);
            assertThat(result).isEqualTo("1,2;3");
        }

        @Test
        @DisplayName("커스텀 구분자가 2개")
        void Separator2() {
            String input = "//;\\n//?\\n1?2;3";
            String result = plusCalculator.findCustomSeparator(input);
            assertThat(result).isEqualTo("1?2;3");
        }

    }

    @Nested
    class hasCustomSeparator {
        @Test
        @DisplayName("커스텀 구분자가 있을때")
        void ExistCustomSeparator() {
            String input = "//;\\n1;2";
            boolean result = plusCalculator.hasCustomSeparator(input);
            assertThat(result).isEqualTo(true);
        }

        @Test
        @DisplayName("커스텀 구분자가 없을때")
        void notExistCustomSeparator() {
            String input = "1;2";
            boolean result = plusCalculator.hasCustomSeparator(input);
            assertThat(result).isEqualTo(false);
        }

        @Test
        @DisplayName("// 만 있을때")
        void onlyStart() {
            String input = "//1;2";
            assertThatThrownBy(() -> plusCalculator.hasCustomSeparator(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("//가 처음이 아닌 중간에 있을때")
        void startNotFirst() {
            String input = "3//1;2";
            assertThatThrownBy(() -> plusCalculator.hasCustomSeparator(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }


    @Nested
    class extractCustomSeparator {

        @Test
        @DisplayName("커스텀 구분자가 있을때")
        void success() {
            String input = "//;\\n1;2";
            String result = plusCalculator.extractCustomSeparator(input);
            assertThat(result).isEqualTo("1;2");
        }
    }

    @Nested
    class checkCustomSeparator {
        @Test
        @DisplayName("커스텀 구분자가 // 일 경우")
        void customSeparatorException1() {
            String input = "////\\n1//2";
            assertThatThrownBy(() -> plusCalculator.extractCustomSeparator(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class checkCustomSeparatorNumber {
        @Test
        @DisplayName("커스텀 구분자에 숫자가 있을 경우")
        void existNumber() {
            char input = '1';
            assertThatThrownBy(() -> plusCalculator.checkCustomSeparatorNumber(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class extractNumbers {
        @Test
        @DisplayName("공백일 경우 0 반환")
        void blank() {
            String input = "";
            List<Integer> integerNumbers = List.of(0);
            List<Integer> result = plusCalculator.extractNumbers(input);
            assertThat(result).isEqualTo(integerNumbers);
        }

        @Test
        @DisplayName("구분자와 숫자가 정상적으로 있을 경우")
        void success() {
            String input = "1,2:3";
            List<Integer> integerNumbers = List.of(1, 2, 3);
            List<Integer> result = plusCalculator.extractNumbers(input);
            assertThat(result).isEqualTo(integerNumbers);
        }
    }

    @Nested
    class extractNumber {
        @Test
        @DisplayName("정상적인 숫자가 입력된 경우")
        void success() {
            String input = "123";
            Integer result = plusCalculator.extractNumber(input);
            assertThat(result).isEqualTo(123);
        }

        @Test
        @DisplayName("문자가 섞여있는 경우")
        void withString() {
            String input = "123b";
            assertThatThrownBy(() -> plusCalculator.extractNumber(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("음수인 경우")
        void minus() {
            String input = "-123";
            assertThatThrownBy(() -> plusCalculator.extractNumber(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class calculate {
        @Test
        @DisplayName("계산")
        void success() {
            List<Integer> input = List.of(1, 2, 3, 4);
            Integer result = plusCalculator.calculate(input);
            assertThat(result).isEqualTo(10);
        }
    }

}