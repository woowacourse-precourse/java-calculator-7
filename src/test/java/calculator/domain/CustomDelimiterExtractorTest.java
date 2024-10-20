package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomDelimiterExtractorTest {

    private CustomDelimiterExtractor customDelimiterExtractor;

    @BeforeEach
    void setUp() {
        customDelimiterExtractor = new CustomDelimiterExtractor();
    }

    @DisplayName("문자열 앞부분의 \"//\"와 \"\\n\" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.")
    @ParameterizedTest
    @CsvSource(value = {"//|\\n1|2|3, |", "//v\\n5000v6035v7090, v", "//냥\\n10냥20냥30, 냥", "//!!\\n1!!2!!3, !!"})
    void getCustomDelimiter(String stringWithDelimiter, String expectedDelimiter) {
        //given
        //when
        String customDelimiter = customDelimiterExtractor.getCustomDelimiter(stringWithDelimiter);
        //then
        assertThat(customDelimiter).isEqualTo(expectedDelimiter);
    }

    @DisplayName("문자열 앞부분은 \"//\"로 시작하지만 \"\\n\" 로 끝나지 않으면 WRONG_CUSTOM_DELIMITER_FORMAT 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"//|\\t1|2|3", "//|1|2|3", "//|\n1|2|3", "//|n1|2|3", "//|\\1|2|3"})
    void throwsExceptionWhenCustomDelimiterFormatIsWrong(String stringWithDelimiter) {
        //given
        //when
        //then
        assertThatThrownBy(() -> customDelimiterExtractor.getCustomDelimiter(stringWithDelimiter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 커스텀 구분자 형식입니다.");
    }
}