package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SeparatorTest {

    Separator separator = new Separator();

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "4,5:6", "7:8:9", "0:1:2:3:4:5:6:7:8:9", "ab:cd,ef", "a1,as2,bd3"})
    @DisplayName("문자열 분리 시 기본 구분자가 포함된 경우, 기본 구분자를 제거한 결과를 반환한다.")
    void givenInputWithBaseDelimiters_whenSeparate_thenReturnListWithoutDelimiters(String input) {
        // given
        // when
        separator.separate(input);

        // then
        String[] inputWithoutDelimiter = input.split("[,:]");
        assertThat(separator.getResult()).containsExactly(inputWithoutDelimiter);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0123", "456", "789", "1234567890"})
    @DisplayName("문자열 분리 시 구분자가 없는 문자열인 경우, 하나의 문자열을 반환한다.")
    void givenInputWithoutDelimiter_whenSeparate_thenReturnListOfOneElement(String input) {
        // given
        // when
        separator.separate(input);

        // then
        String[] inputWithoutDelimiter = input.split("[,:]");
        assertThat(separator.getResult()).containsExactly(inputWithoutDelimiter);
    }

    @Test
    @DisplayName("문자열 분리 시 기본 구분자로 시작하는 경우, 빈 문자열을 포함하여 올바르게 분리한다.")
    void givenInputStartingWithDelimiter_whenSeparate_thenReturnListIncludingEmptyString() {
        // given
        String input = ",123";

        // when
        separator.separate(input);

        // then
        List<String> expected = List.of("", "123");
        assertThat(separator.getResult()).isEqualTo(expected);
    }

    @Test
    @DisplayName("문자열 분리 시 기본 구분자로 끝나는 경우, 빈 문자열을 포함하여 올바르게 분리한다.")
    void givenInputEndingWithDelimiter_whenSeparate_thenReturnListIncludingEmptyString() {
        // given
        String input = "123,";

        // when
        separator.separate(input);

        // then
        List<String> expected = List.of("123", "");
        assertThat(separator.getResult()).isEqualTo(expected);
    }

    @Test
    @DisplayName("기본 구분자 외 다른 구분자가 주어질 경우, 다른 구분자는 제거되지 않는다.")
    void givenInputOtherDelimiter_whenSeparate_thenReturnNotSeperatedOtherDelimiter() {
        // given
        String input = "1,2:3+4";

        // when
        separator.separate(input);

        // then
        List<String> expected = List.of("1", "2", "3+4");
        assertThat(separator.getResult()).isEqualTo(expected);
    }

    @Test
    @DisplayName("기본 구분자와 커스텀 구분자가 주어질 경우, 모든 구분자를 제거한 결과를 반환한다.")
    void givenInputWithCustomDelimiter_whenCustomSeparate_thenReturnListWithoutDelimiters() {
        // given
        String input = "//+\\n1,2:3+4";

        // when
        separator.separate(input);

        // then
        List<String> expected = List.of("1", "2", "3", "4");
        assertThat(separator.getResult()).isEqualTo(expected);
    }

    @Test
    @DisplayName("기본 구분자와 커스텀 구분자 외 다른 구분자가 주어질 경우, 다른 구분자는 제거되지 않는다.")
    void givenInputWithOtherDelimiter_whenCustomSeparate_thenReturnNotSeperatedOtherDelimiter() {
        // given
        String input = "//+\\n1,2:3+4-5";

        // when
        separator.separate(input);

        // then
        List<String> expected = List.of("1", "2", "3", "4-5");
        assertThat(separator.getResult()).isEqualTo(expected);
    }

    @Test
    @DisplayName("한 번 분리한 뒤 다시 분리 할 경우, 같은 결과를 반환한다.")
    void givenSeparate_whenSeparate_thenReturnSameResult() {
        // given
        String input = "1,2,3";
        separator.separate(input);
        List<String> before = separator.getResult();

        // when
        separator.separate(input);

        // then
        assertThat(separator.getResult()).isEqualTo(before);
    }

    @Test
    @DisplayName("한 번 분리한 뒤 다른 값으로 다시 분리 할 경우, 다음 결과 값을 반환한다.")
    void givenSeparateAndOtherData_whenSeparate_thenReturnAfterSeparateResult() {
        // given
        String input = "1,2,3";
        separator.separate(input);
        String otherData = "//+\\n1,2:3+4";

        // when
        separator.separate(otherData);

        // then
        List<String> expected = List.of("1", "2", "3", "4");
        assertThat(separator.getResult()).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀 구분자를 숫자로 할 경우, 구분자를 제외한 결과를 반환한다.")
    void givenDigitCustomDelimiter_whenSeparate_thenReturnListWithoutDelimiters() {
        // given
        String input = "//1\\n1,2:3+4";

        // when
        separator.separate(input);

        // then
        List<String> expected = List.of("", "", "2", "3+4");
        assertThat(separator.getResult()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//\\n1,2:3+4", "/\\n1,2:3+4", "\\n1,2:3+4", "//ab\\n1,2:3+4"})
    @DisplayName("잘못된 입력 값으로 분리할 경우, 예외가 발생한다.")
    void givenInvalidInput_whenSeparate_thenReturnError(String input) {
        // given

        // when, then
        assertThatThrownBy(() -> separator.separate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}