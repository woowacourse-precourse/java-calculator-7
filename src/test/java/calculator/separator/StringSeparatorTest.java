package calculator.separator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringSeparatorTest {

    StringSeparator stringSeparator;

    @Test
    public void 커스텀_구분자_지정을_확인() throws Exception {
        //given
        String inputString = "//?\\n3?2:4";
        stringSeparator = new StringSeparator(inputString);

        //when
        boolean isCustomDelimiters = stringSeparator.validCustomDelimiters();

        //then
        assertThat(isCustomDelimiters).isTrue();
    }
}