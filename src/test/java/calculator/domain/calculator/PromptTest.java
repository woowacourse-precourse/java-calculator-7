package calculator.domain.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PromptTest {

    Prompt prompt;

    @BeforeEach
    void setUp() {
        prompt = new Prompt();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "4,5:6", "7:8:9", "0:1:2:3:4:5:6:7:8:9", "ab:cd,ef", "a1,as2,bd3"})
    @DisplayName("문자열 분리 시 기본 구분자가 포함된 경우, 기본 구분자를 제거한 결과를 반환한다.")
    void givenInputWithBaseDelimiters_whenSeparate_thenReturnListWithoutDelimiters(String input) {
        // given

        // when
        List<String> result = prompt.separate(input);

        // then
        String[] inputWithoutDelimiter = input.split("[,:]");
        assertThat(result).containsExactly(inputWithoutDelimiter);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0123", "456", "789", "1234567890"})
    @DisplayName("문자열 분리 시 구분자가 없는 문자열인 경우, 하나의 문자열을 반환한다.")
    void givenInputWithoutDelimiter_whenSeparate_thenReturnListOfOneElement(String input) {
        // given

        // when
        List<String> result = prompt.separate(input);

        // then
        String[] inputWithoutDelimiter = input.split("[,:]");
        assertThat(result).containsExactly(inputWithoutDelimiter);
    }

    @Test
    @DisplayName("문자열 분리 시 기본 구분자로 시작하는 경우, 빈 문자열을 포함하여 올바르게 분리한다.")
    void givenInputStartingWithDelimiter_whenSeparate_thenReturnListIncludingEmptyString() {
        // given
        String input = ",123";

        // when
        List<String> result = prompt.separate(input);

        // then
        String[] inputWithoutDelimiter = input.split("[,:]");
        assertThat(result).containsExactly(inputWithoutDelimiter);
    }

    @Test
    @DisplayName("문자열 분리 시 기본 구분자로 끝나는 경우, 빈 문자열을 포함하여 올바르게 분리한다.")
    void givenInputEndingWithDelimiter_whenSeparate_thenReturnListIncludingEmptyString() {
        // given
        String input = ",123";

        // when
        List<String> result = prompt.separate(input);

        // then
        String[] inputWithoutDelimiter = input.split("[,:]");
        assertThat(result).containsExactly(inputWithoutDelimiter);
    }

}