package calculator.separator;

import static org.assertj.core.api.Assertions.*;
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

    @Test
    public void 커스텀_구분자_추출() throws Exception {
        //given
        String inputString = "//?\\n3?2:4";
        stringSeparator = new StringSeparator(inputString);

        //when
        String extractedCustomDelimiters = stringSeparator.extractCustomDelimiters();

        //then
        assertThat(extractedCustomDelimiters).isEqualTo("?");
    }


    @Test
    public void 추출된_커스텀_구분자를_기본_구분자에_추가() throws Exception {
        //given
        stringSeparator = new StringSeparator();
        String customDelimiters = "?";

        //when
        String delimiters = stringSeparator.addCustomDelimiters(customDelimiters);

        //then
        assertThat(delimiters).contains(customDelimiters);
    }
}