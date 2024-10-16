package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    @DisplayName("입력 메시지를 출력한다.")
    void 입력_메시지_출력() {
        // Given
        Calculator calculator = new Calculator();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // When
        calculator.displayInputMessage();

        // Then
        assertThat(outputStream.toString()).isEqualTo("덧셈할 문자열을 입력해 주세요.\n");

        // Cleanup
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("입력 값을 반환한다.")
    void 입력_값_반환() {
        // Given
        Calculator calculator = new Calculator();
        String input = "입력값";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // When
        String result = calculator.getInput();

        // Then
        assertThat(result).isEqualTo(input);

        System.setIn(System.in);
    }

    @Test
    @DisplayName("null 입력 시 예외를 발생시킨다.")
    void null_입력_예외_발생() {
        // Given
        Calculator calculator = new Calculator();
        String input = null;

        // When & Then
        assertThatThrownBy(() -> calculator.add(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 null입니다.");
    }

    @Test
    @DisplayName("빈 문자열 입력 시 0을 반환한다.")
    void 빈_문자열_입력_시_0_반환() {
        // Given
        Calculator calculator = new Calculator();
        String input = "";

        // When
        int result = calculator.add(input);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("입력 문자열에서 모든 공백을 제거한다.")
    void 입력_문자열_공백_제거() {
        // Given
        Calculator calculator = new Calculator();
        String input = "1, 2:   3";

        // When
        String result = calculator.preprocess(input);

        // Then
        assertThat(result).isEqualTo("1,2:3");
    }

    @Test
    @DisplayName("올바른 형식의 커스텀 구분자를 추출한다.")
    void 올바른_형식의_커스텀_구분자_추출() {
        // Given
        Calculator calculator = new Calculator();
        String input = "//;\n1;2;3";

        // When
        String delimiter = calculator.extractCustomDelimiter(input);

        // Then
        assertThat(delimiter).isEqualTo(";");
    }

    @Test
    @DisplayName("커스텀 구분자가 두 글자 이상인 경우에도 추출한다.")
    void 커스텀_구분자_두_글자_이상_추출() {
        // Given
        Calculator calculator = new Calculator();
        String input = "//delimiter\n1;;2;;3";

        // When
        String delimiter = calculator.extractCustomDelimiter(input);

        // Then
        assertThat(delimiter).isEqualTo("delimiter");
    }

    @Test
    @DisplayName("커스텀 구분자가 특수문자인 경우에도 추출한다.")
    void 커스텀_구분자_특수문자_추출() {
        // Given
        Calculator calculator = new Calculator();
        String input = "//.\n1.2.3";

        // When
        String delimiter = calculator.extractCustomDelimiter(input);

        // Then
        assertThat(delimiter).isEqualTo(".");
    }

    @Test
    @DisplayName("커스텀 구분자가 없을 경우 null을 반환한다.")
    void 커스텀_구분자_없음() {
        // Given
        Calculator calculator = new Calculator();
        String input = "1,2,3";

        // When
        String delimiter = calculator.extractCustomDelimiter(input);

        // Then
        assertThat(delimiter).isNull();
    }

    @Test
    @DisplayName("커스텀 구분자가 숫자인 경우에는 예외를 발생시킨다.")
    void 커스텀_구분자_숫자_예외_발생() {
        // Given
        Calculator calculator = new Calculator();
        String input = "//1\n1,2,3";  // 숫자로 시작하는 구분자

        // When & Then
        assertThatThrownBy(() -> calculator.extractCustomDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 숫자가 될 수 없습니다.");
    }

    @Test
    @DisplayName("올바르지 않은 형식의 커스텀 구분자 사용 시 예외를 발생시킨다.")
    void 잘못된_형식의_커스텀_구분자_예외_발생() {
        // Given
        Calculator calculator = new Calculator();
        String input = "//;\1;2;3";  // 올바르지 않은 형식

        // When & Then
        assertThatThrownBy(() -> calculator.extractCustomDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자 형식이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("비어있는 커스텀 구분자 사용 시 예외를 발생시킨다.")
    void 비어있는_커스텀_구분자_예외_발생() {
        // Given
        Calculator calculator = new Calculator();
        String input = "//\n1,2,3";  // 비어 있는 구분자

        // When & Then
        assertThatThrownBy(() -> calculator.extractCustomDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자가 비어 있습니다.");
    }

    @Test
    @DisplayName("기본 구분자로 문자열을 분리한다.")
    void 기본_구분자로_문자열_분리() {
        // Given
        Calculator calculator = new Calculator();
        String input = "1,2:3";
        String[] expected = {"1", "2", "3"};

        // When
        String[] result = calculator.splitNumbers(input, null);

        // Then
        assertThat(result).containsExactly(expected);
    }

    @Test
    @DisplayName("커스텀 구분자로 문자열을 분리한다.")
    void 커스텀_구분자로_문자열_분리() {
        // Given
        Calculator calculator = new Calculator();
        String input = "//;\n1;2;3";
        String delimiter = ";";
        String[] expected = {"1", "2", "3"};

        // When
        String[] result = calculator.splitNumbers(input, delimiter);

        // Then
        assertThat(result).containsExactly(expected);
    }

    @Test
    @DisplayName("구분자 사이에 숫자가 없는 경우 예외를 발생시킨다.")
    void 구분자_사이에_숫자_없음_예외_발생() {
        // Given
        Calculator calculator = new Calculator();
        String input = "1,,2";

        // When & Then
        assertThatThrownBy(() -> calculator.splitNumbers(input, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자 사이에 숫자가 없습니다.");
    }

    @Test
    @DisplayName("숫자 문자열을 정수로 변환하고 합산한다.")
    void 숫자_문자열을_정수로_변환하고_합산() {
        // Given
        Calculator calculator = new Calculator();
        String[] numbers = {"1", "2", "3"};

        // When
        int result = calculator.calculateSum(numbers);

        // Then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 포함된 경우 예외를 발생시킨다.")
    void 음수_포함_예외_발생() {
        // Given
        Calculator calculator = new Calculator();
        String[] numbers = {"1", "-2", "3"};

        // When & Then
        assertThatThrownBy(() -> calculator.calculateSum(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 허용되지 않습니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 포함된 경우 예외를 발생시킨다.")
    void 숫자_아닌_문자_포함_예외_발생() {
        // Given
        Calculator calculator = new Calculator();
        String[] numbers = {"1", "a", "3"};

        // When & Then
        assertThatThrownBy(() -> calculator.calculateSum(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 값이 포함되어 있습니다.");
    }

    @Test
    @DisplayName("결과를 출력한다.")
    void 결과_출력() {
        // Given
        Calculator calculator = new Calculator();
        int result = 6;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // When
        calculator.printResult(result);

        // Then
        assertThat(outputStream.toString()).isEqualTo("결과: 6\n");

        // Cleanup
        System.setOut(originalOut);
    }

}
