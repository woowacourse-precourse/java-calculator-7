package detector;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("커스텀구분자가 없는 경우")
    void detectSeparator_X() {
        // given
        String input = "1,2,3";
        // when
        String customSeparator = detector.detectSeparator(input);
        // then
        assertThat(customSeparator).isEqualTo("");
    }
}