package calculator;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomTest {

    @Test
    void 커스텀_구분자_사용() {
        String CUSTOM_DELIMITER_FORMAT = "//.\\\\n.*";
        assertThat(Pattern.matches(CUSTOM_DELIMITER_FORMAT, "//?\\n2:3,2")).isTrue();
    }

    @Test
    void 커스텀_구분자_사용하지_않음() {
        String CUSTOM_DELIMITER_FORMAT = "//.\\\\n.*";
        assertThat(Pattern.matches(CUSTOM_DELIMITER_FORMAT, "2:3,2")).isFalse();
    }
}
