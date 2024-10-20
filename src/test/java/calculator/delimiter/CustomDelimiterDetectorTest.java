package calculator.delimiter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomDelimiterDetectorTest {
    static final CustomDelimiterDetector detector = new CustomDelimiterDetector();

    @Test
    @DisplayName("커스텀 구분자 찾기")
    void 커스텀_구분자_찾기(){
        // given
        String input = "//;\n1;2;3";
        // when
        String customDelimiter = detector.findCustomDelimiter(input);
        // then
        assertThat(customDelimiter).isEqualTo(";");
    }

    @Test
    @DisplayName("커스텀 구분자 x")
    void 커스텀_구분자_x(){
        // given
        String input = "1,2:3";
        // when
        String customDelimiter = detector.findCustomDelimiter(input);
        // then
        assertThat(customDelimiter).isEqualTo("");
    }

    @Test
    @DisplayName("두 글자 이상의 커스텀 구분자")
    void 커스텀_구분자_over_two(){
        // given
        String input = "//;;\n1;2;3";
        // when
        String customDelimiter = detector.findCustomDelimiter(input);
        // then
        assertThat(customDelimiter).isEqualTo(";;");
    }

    @Test
    @DisplayName("커스텀 구분자 순서가 바뀜")
    void 커스텀_구분자_순서바뀜(){
        // given
        String input = "\n;//1;2;3";
        // when
        String customDelimiter = detector.findCustomDelimiter(input);
        // then
        assertThat(customDelimiter).isEqualTo("");
    }
}