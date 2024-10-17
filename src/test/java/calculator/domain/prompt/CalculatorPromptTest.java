package calculator.domain.prompt;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.domain.Calculator;
import java.util.List;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorPromptTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "4,5:6", "7:8:9", "0:1:2:3:4:5:6:7:8:9", "ab:cd,ef", "a1,as2,bd3"})
    @DisplayName("문자열 분리 시 기본 구분자가 포함된 경우, 기본 구분자를 제거한 결과를 반환한다.")
    void givenInputWithBaseDelimiters_whenSeparate_thenReturnListWithoutDelimiters(String input) {
        // given
        // when
        CalculatorPrompt prompt = new CalculatorPrompt(input);

        // then
        String[] inputWithoutDelimiter = input.split("[,:]");
        assertThat(prompt.getInput()).containsExactly(inputWithoutDelimiter);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0123", "456", "789", "1234567890"})
    @DisplayName("문자열 분리 시 구분자가 없는 문자열인 경우, 하나의 문자열을 반환한다.")
    void givenInputWithoutDelimiter_whenSeparate_thenReturnListOfOneElement(String input) {
        // given
        // when
        CalculatorPrompt prompt = new CalculatorPrompt(input);

        // then
        String[] inputWithoutDelimiter = input.split("[,:]");
        assertThat(prompt.getInput()).containsExactly(inputWithoutDelimiter);
    }

    @Test
    @DisplayName("문자열 분리 시 기본 구분자로 시작하는 경우, 빈 문자열을 포함하여 올바르게 분리한다.")
    void givenInputStartingWithDelimiter_whenSeparate_thenReturnListIncludingEmptyString() {
        // given
        String input = ",123";

        // when
        CalculatorPrompt prompt = new CalculatorPrompt(input);

        // then
        String[] inputWithoutDelimiter = input.split("[,:]");
        assertThat(prompt.getInput()).containsExactly(inputWithoutDelimiter);
    }

    @Test
    @DisplayName("문자열 분리 시 기본 구분자로 끝나는 경우, 빈 문자열을 포함하여 올바르게 분리한다.")
    void givenInputEndingWithDelimiter_whenSeparate_thenReturnListIncludingEmptyString() {
        // given
        String input = ",123";

        // when
        CalculatorPrompt prompt = new CalculatorPrompt(input);

        // then
        String[] inputWithoutDelimiter = input.split("[,:]");
        assertThat(prompt.getInput()).containsExactly(inputWithoutDelimiter);
    }

    @Test
    @DisplayName("기본 구분자 외 다른 구분자가 주어질 경우, 다른 구분자는 제거되지 않는다.")
    void givenInputOtherDelimiter_whenSeparate_thenReturnNotSeperatedOtherDelimiter() {
        // given
        String input = "1,2:3+4";

        // when
        CalculatorPrompt prompt = new CalculatorPrompt(input);

        // then
        String[] inputWithoutDelimiter = input.split("[,:]");
        assertThat(prompt.getInput()).containsExactly(inputWithoutDelimiter);
        assertThat(prompt.getInput().get(2)).contains("+");
    }

    @Test
    @DisplayName("기본 구분자와 커스텀 구분자가 주어질 경우, 모든 구분자를 제거한 결과를 반환한다.")
    void givenInputWithCustomDelimiter_whenCustomSeparate_thenReturnListWithoutDelimiters() {
        // given
        String input = "//+\n1,2:3+4";

        // when
        CalculatorPrompt prompt = new CalculatorPrompt(input);

        // then
        String[] inputWithoutDelimiter = "1,2:3+4".split("[,:+]");
        assertThat(prompt.getInput()).containsExactly(inputWithoutDelimiter);
    }

    @Test
    @DisplayName("기본 구분자와 커스텀 구분자 외 다른 구분자가 주어질 경우, 다른 구분자는 제거되지 않는다.")
    void givenInputWithOtherDelimiter_whenCustomSeparate_thenReturnNotSeperatedOtherDelimiter() {
        // given
        String input = "//+\n1,2:3+4-5";

        // when
        CalculatorPrompt prompt = new CalculatorPrompt(input);

        // then
        String[] inputWithoutDelimiter = "1,2:3+4-5".split("[,:+]");
        assertThat(prompt.getInput()).containsExactly(inputWithoutDelimiter);
        assertThat(prompt.getInput().get(3)).contains("-");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "4,5:6", "7:8:9", "0:1:2:3:4:5:6:7:8:9"})
    @DisplayName("기본 구분자가 포함된 한자리 숫자로 이루어진 문자열 추출시, 정수 리스트를 반환한다.")
    void givenPromptWithDigit_whenExtractInteger_thenReturnIntegerList(String input) {
        // given
        CalculatorPrompt prompt = new CalculatorPrompt(input);

        // when, then
        assertThat(prompt.extractInteger()).doesNotHaveSameClassAs(String.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"11,22,33", "444,555:666", "777:888:999", "012:123:234:345:456:567:678:789:8910:91011"})
    @DisplayName("기본 구분자가 포함된 숫자로 이루어진 문자열 추출시, 정수 리스트를 반환한다.")
    void givenPromptWithNumber_whenExtractInteger_thenReturnIntegerList(String input) {
        // given
        CalculatorPrompt prompt = new CalculatorPrompt(input);

        // when, then
        assertThat(prompt.extractInteger()).doesNotHaveSameClassAs(String.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "1", "0", "9999999"})
    @DisplayName("구분자가 없는 숫자로 이루어진 문자열 추출 시, 한 개의 숫자를 반환한다.")
    void givenPromptWithoutDelimiters_whenExtractInteger_thenReturnIntegerList(String input) {
        // given
        CalculatorPrompt prompt = new CalculatorPrompt(input);

        // when
        List<Integer> result = prompt.extractInteger();

        // then
        AssertionsForClassTypes.assertThat(result.size()).isOne();
    }

    @Test
    @DisplayName("기본 구분자로 시작하는 숫자로 이루어진 문자열 추출 시, 예외가 발생한다")
    void givenPromptStartingWithBaseDelimiter_whenExtractInteger_thenReturnError() {
        // given
        String input = ",123";
        CalculatorPrompt prompt = new CalculatorPrompt(input);

        // when, then
        assertThatThrownBy(prompt::extractInteger)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("기본 구분자로 끝나는 숫자로 이루어진 문자열 추출 시, 예외가 발생한다")
    void givenPromptEndingWithBaseDelimiter_whenExtractInteger_thenReturnError() {
        // given
        String input = "123,";
        CalculatorPrompt prompt = new CalculatorPrompt(input);

        // when, then
        assertThatThrownBy(prompt::extractInteger)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2.3", "1.2.3", "1 2 3", "1, 2, 3", "1+2+3", "123 ", " 1,2,3 ", " 123", ",", ":", ", ,"})
    @DisplayName("기본 구분자 외에 다른 문자가 포함되면 예외가 발생한다.")
    void givenInvalidPrompt_whenExtractInteger_thenReturnError(String input) {
        // given
        CalculatorPrompt prompt = new CalculatorPrompt(input);

        // when, then
        assertThatThrownBy(prompt::extractInteger)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//+\n11+22,33", "//+\n444+555:666", "//+\n777+888+999", "//s\n12s3", "// \n1 2"})
    @DisplayName("커스텀 구분자가 포함된 숫자로 이루어진 문자열 추출시, 정수 리스트를 반환한다.")
    void givenInputNumberStringWithCustomDelimiter_whenExtractInteger_thenReturnIntegerList(String input) {
        // given
        char customDelimiter = '+';
        CalculatorPrompt prompt = new CalculatorPrompt(input);

        // when, then
        assertThat(prompt.extractInteger()).doesNotHaveSameClassAs(String.class);
    }

}