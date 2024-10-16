package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomDelimiterExtractorTest {

    @DisplayName("문자열 앞부분의 \"//\"와 \"\\n\" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.")
    @Test
    void getCustomDelimiter() {
        //given
        CustomDelimiterExtractor customDelimiterExtractor = new CustomDelimiterExtractor();
        String stringWithDelimiter = "//|\\n1|2|3";
        //when
        String customDelimiter = customDelimiterExtractor.getCustomDelimiter(stringWithDelimiter);
        //then
        assertThat(customDelimiter).isEqualTo("|");
    }

    @DisplayName("문자열 앞부분은 \"//\"로 시작하지만 \"\\n\" 로 끝나지 않으면 WRONG_CUSTOM_DELIMITER_FORMAT 예외가 발생한다.")
    @Test
    void throwsExceptionWhenCustomDelimiterFormatIsWrong() {
        //given
        CustomDelimiterExtractor customDelimiterExtractor = new CustomDelimiterExtractor();
        String stringWithDelimiter = "//|\\t1|2|3";
        //when
        //then
        assertThatThrownBy(() -> customDelimiterExtractor.getCustomDelimiter(stringWithDelimiter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 커스텀 구분자 형식입니다.");
    }

    @DisplayName("문자열 앞부분은 \"//\"로 시작하지만 \"\\n\" 로 끝나지 않으면 WRONG_CUSTOM_DELIMITER_FORMAT 예외가 발생한다.")
    @Test
    void throwsExceptionWhenCustomDelimiterFormatIsWrong2() {
        //given
        CustomDelimiterExtractor customDelimiterExtractor = new CustomDelimiterExtractor();
        String stringWithDelimiter = "//|1|2|3";
        //when
        //then
        assertThatThrownBy(() -> customDelimiterExtractor.getCustomDelimiter(stringWithDelimiter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 커스텀 구분자 형식입니다.");
    }

    @DisplayName("문자열 앞부분이 \"//\"로 시작하지 않으면 WRONG_CUSTOM_DELIMITER_FORMAT 예외가 발생한다.")
    @Test
    void throwsExceptionWhenCustomDelimiterFormatIsWrong3() {
        //given
        CustomDelimiterExtractor customDelimiterExtractor = new CustomDelimiterExtractor();
        String stringWithDelimiter = "/|\\n1|2|3";
        //when
        //then
        assertThatThrownBy(() -> customDelimiterExtractor.getCustomDelimiter(stringWithDelimiter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 커스텀 구분자 형식입니다.");
    }
}