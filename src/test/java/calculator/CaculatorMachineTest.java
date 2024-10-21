package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CaculatorMachineTest {

    @DisplayName("기본 구분자 덧셈")
    @Test
    void BaseDelimiterTest() {
        // given
        CalculatorMachine calculatorMachine = new CalculatorMachine();
        String userInput = "1,2";
        // when
        int result = calculatorMachine.calculate(userInput);

        // then
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("커스텀 구분자 덧셈")
    @Test
    void CustomDelimiterTest() {
        // given
        CalculatorMachine calculatorMachine = new CalculatorMachine();
        String userInput = "//;\\n1;2";
        // when
        int result = calculatorMachine.calculate(userInput);

        // then
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("커스텀 구분자 + 기본 구분자 덧셈")
    @Test
    void CustomDelimiterAndBaseDelimiterTest() {
        // given
        CalculatorMachine calculatorMachine = new CalculatorMachine();
        String userInput = "//;\\n1;2,3:2";
        // when
        int result = calculatorMachine.calculate(userInput);

        // then
        assertThat(result).isEqualTo(8);
    }

    @DisplayName("정해진 구분자가 아닌 다른 문자가 입력된 경우")
    @Test
    void OtherDelimiterTest() {
        // given
        CalculatorMachine calculatorMachine = new CalculatorMachine();
        String userInput = "1,2;3";
        // when
        Throwable thrown = catchThrowable(() -> calculatorMachine.calculate(userInput));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("잘못된 입력입니다.");
    }

    @DisplayName("음수가 입력된 경우")
    @Test
    void NegativeNumberTest() {
        // given
        CalculatorMachine calculatorMachine = new CalculatorMachine();
        String userInput = "1,-2:3";
        // when
        Throwable thrown = catchThrowable(() -> calculatorMachine.calculate(userInput));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("잘못된 입력입니다.");
    }

    @DisplayName("구분자가 연속으로 2번 이상 나온 경우")
    @Test
    void MultipleDelimitersTest() {
        // given
        CalculatorMachine calculatorMachine = new CalculatorMachine();
        String userInput = "2,,3::4";
        // when
        Throwable thrown = catchThrowable(() -> calculatorMachine.calculate(userInput));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("잘못된 입력입니다.");
    }

    @DisplayName("문자열이 구분자로 시작하는 경우")
    @Test
    void StartWithDelimiterTest() {
        // given
        CalculatorMachine calculatorMachine = new CalculatorMachine();
        String userInput = ",2,3:4";
        // when
        Throwable thrown = catchThrowable(() -> calculatorMachine.calculate(userInput));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("잘못된 입력입니다.");
    }

    @DisplayName("문자열이 구분자로 끝나는 경우")
    @Test
    void EndWithDelimiterTest() {
        // given
        CalculatorMachine calculatorMachine = new CalculatorMachine();
        String userInput = "2,3:4:";
        // when
        Throwable thrown = catchThrowable(() -> calculatorMachine.calculate(userInput));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("잘못된 입력입니다.");
    }

    @DisplayName("//만 존재하는 경우")
    @Test
    void OnlyOneStartDelimiterTest() {
        // given
        CalculatorMachine calculatorMachine = new CalculatorMachine();
        String userInput = "//";
        // when
        Throwable thrown = catchThrowable(() -> calculatorMachine.calculate(userInput));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("잘못된 입력입니다.");
    }

    @DisplayName("\\n만 존재하는 경우")
    @Test
    void OnlyOneEndDelimiterTest() {
        // given
        CalculatorMachine calculatorMachine = new CalculatorMachine();
        String userInput = "\\n";
        // when
        Throwable thrown = catchThrowable(() -> calculatorMachine.calculate(userInput));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("잘못된 입력입니다.");
    }

    @DisplayName("\\n이 //보다 앞에 있는 경우")
    @Test
    void EndDelimiterBeforeStartDelimiterTest() {
        // given
        CalculatorMachine calculatorMachine = new CalculatorMachine();
        String userInput = "\\n;//2;3";
        // when
        Throwable thrown = catchThrowable(() -> calculatorMachine.calculate(userInput));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("잘못된 입력입니다.");
    }

    @DisplayName("//와 \\n 사이에 구분자가 1개가 아닌 경우")
    @Test
    void TwoCustomDelimiterTest() {
        // given
        CalculatorMachine calculatorMachine = new CalculatorMachine();
        String userInput = "//;;\\n2;;3";
        // when
        Throwable thrown = catchThrowable(() -> calculatorMachine.calculate(userInput));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("잘못된 입력입니다.");
    }

    @DisplayName("//와 \\n이 문자열 맨 앞에 존재하지 않는 경우")
    @Test
    void isNotStartWithCustomDelimiterTest() {
        // given
        CalculatorMachine calculatorMachine = new CalculatorMachine();
        String userInput = "2,3:4//;\\n";
        // when
        Throwable thrown = catchThrowable(() -> calculatorMachine.calculate(userInput));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("잘못된 입력입니다.");
    }

    @DisplayName("//이 2개 이상 존재하는 경우")
    @Test
    void MultipleStartDelimitersTest() {
        // given
        CalculatorMachine calculatorMachine = new CalculatorMachine();
        String userInput = "//;\\n//2,3:4";
        // when
        Throwable thrown = catchThrowable(() -> calculatorMachine.calculate(userInput));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("잘못된 입력입니다.");
    }

    @DisplayName("\\n이 2개 이상 존재하는 경우")
    @Test
    void MultipleEndDelimitersTest() {
        // given
        CalculatorMachine calculatorMachine = new CalculatorMachine();
        String userInput = "//;\\n\\n2,3:4";
        // when
        Throwable thrown = catchThrowable(() -> calculatorMachine.calculate(userInput));

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("잘못된 입력입니다.");
    }
}