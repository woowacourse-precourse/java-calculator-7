package detector;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomSeparatorDetectorImplTest {
    static final CustomSeparatorDetector detector = new CustomSeparatorDetectorImpl();

    @Test
    @DisplayName("커스텀 구분자 찾기")
    void detectSeparator() {
        // given
        String input = "//;\\n1;2;3";
        // when
        String customSeparator = detector.detectSeparator(input);
        // then
        assertThat(customSeparator).isEqualTo(";");
    }

    @Test
    @DisplayName("커스텀 구분자가 없는 경우")
    void detectSeparator_X() {
        // given
        String input = "1,2,3";
        // when
        String customSeparator = detector.detectSeparator(input);
        // then
        assertThat(customSeparator).isEqualTo("");
    }

    @Test
    @DisplayName("커스텀 구분자가 2자리 이상")
    void 커스텀_구분자_2글자_이상() {
        // given
        String input = "//abcde\\n1,2,3";
        // when
        String customSeparator = detector.detectSeparator(input);
        // then
        assertThat(customSeparator).isEqualTo("abcde");
    }

    @Test
    @DisplayName("커스텀 구분자 순서가 바뀐 경우")
    void 커스텀_구분자_순서_바뀐_경우() {
        // given
        String input = "\\n;//1,2,3";
        // when
        String customSeparator = detector.detectSeparator(input);
        // then
        assertThat(customSeparator).isEqualTo("");
    }

    @Test
    @DisplayName("커스텀 구분자 안에 커스텀 구분자 \\n")
    void 커스텀_구분자_안_커스텀_구분자_1() {
        // given
        String input = "//\\n\\n1,2,3";
        // when
        String customSeparator = detector.detectSeparator(input);
        // then
        assertThat(customSeparator).isEqualTo("\\n");
    }

    @Test
    @DisplayName("커스텀 구분자 안에 커스텀 구분자 //")
    void 커스텀_구분자_안_커스텀_구분자_2() {
        // given
        String input = "////\\n1,2,3";
        // when
        String customSeparator = detector.detectSeparator(input);
        // then
        assertThat(customSeparator).isEqualTo("//");
    }
}