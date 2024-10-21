package calculator.model.delimiter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomDelimiterTest {

    @Test
    @DisplayName("입력에 커스텀 구분자가 있으면 커스텀 구분자를 반환한다.")
    void ReturnsCustomDelimiterIfInputHasCustomDelimiter() {
        // given
        String input = "//;\\n1;2;3";
        CustomDelimiter customDelimiter = new CustomDelimiter(input);

        // when
        String delimiter = customDelimiter.getDelimiter();

        // then
        assertThat(delimiter).isEqualTo(";");
    }

    @Test
    @DisplayName("입력에 커스텀 구분자가 없으면 빈 값을 반환한다.")
    void ReturnsEmptyStringIfInputHasNoCustomDelimiter() {
        // Given
        String input = "1,2,3";
        CustomDelimiter customDelimiter = new CustomDelimiter(input);

        // When
        String delimiter = customDelimiter.getDelimiter();

        // Then
        assertThat(delimiter).isEqualTo("");
    }

    @Test
    @DisplayName("입력이 커스텀 구분자 형식에 맞으면 true를 반환한다.")
    void ReturnsTrueIfInputMatchesCustomDelimiterFormat() {
        // Given
        String input = "//;\\n1;2;3";
        CustomDelimiter customDelimiter = new CustomDelimiter(input);

        // When
        boolean isApplicable = customDelimiter.isApplicable(input);

        // Then
        assertThat(isApplicable).isTrue();
    }

    @Test
    @DisplayName("입력이 커스텀 구분자 형식에 맞지 않으면 false를 반환한다.")
    void ReturnsFalseIfInputDoesNotMatchCustomDelimiterFormat() {
        // Given
        String input = "1,2,3";
        CustomDelimiter customDelimiter = new CustomDelimiter(input);

        // When
        boolean isApplicable = customDelimiter.isApplicable(input);

        // Then
        assertThat(isApplicable).isFalse();
    }

    @Test
    @DisplayName("커스텀 구분자가 있을 경우 해당 패턴을 반환한다.")
    void ReturnsCorrectCustomDelimiterPatternIfDelimiterProvided() {
        // Given
        String input = "//;\\n1;2;3";
        CustomDelimiter customDelimiter = new CustomDelimiter(input);

        // When
        String pattern = customDelimiter.getCustomDelimiterPattern();

        // Then
        assertThat(pattern).isEqualTo("//;\\n");
    }

    @Test
    @DisplayName("커스텀 구분자가 사용되면 true를 반환한다.")
    void ReturnsTrueIfCustomDelimiterIsUsed() {
        // Given
        String input = "//;\n1;2;3";
        CustomDelimiter customDelimiter = new CustomDelimiter(input);

        // When
        boolean isCustomDelimiter = customDelimiter.isCustomDelimiter();

        // Then
        assertThat(isCustomDelimiter).isTrue();
    }
}
