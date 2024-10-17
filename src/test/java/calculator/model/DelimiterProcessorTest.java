package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterProcessorTest {

    DelimiterProcessor delimiterProcessor = new DelimiterProcessor();

    @Test
    @DisplayName("기본 구분자를 사용하여 문자열을 분리")
    public void 문자열_분리_기본_구분자사용() {
        //given
        String userInput = "1:2,3";
        String delimiter = ":,";

        //when
        String[] result = delimiterProcessor.splitByDelimiter(userInput, delimiter);

        //then
        assertThat(result).contains("1","2","3");
    }

    @Test
    @DisplayName("커스텀 구분자를 사용하여 문자열을 분리")
    public void 문자열_분리_커스텀_구분자사용() {
        //given
        String userInput = "//&\n1&2&3";
        String delimiter = "&";

        //when
        String[] result = delimiterProcessor.splitByDelimiter(userInput, delimiter);

        //then
        assertThat(result).contains("1","2","3");
    }

    @Test
    @DisplayName("기본 구분자와 커스텀 구분자를 사용하여 문자열을 분리")
    public void 문자열_분리_기본_구분자와_커스텀_구분자사용() {
        //given
        String userInput = "//&\n1&2&3,4:5";
        String delimiter = "&,:";

        //when
        String[] result = delimiterProcessor.splitByDelimiter(userInput, delimiter);

        //then
        assertThat(result).contains("1","2","3","4","5");
    }

}