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
        String userInput = "//&\\n1&2&3";
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
        String userInput = "//&\\n1&2&3,4:5";
        String delimiter = "&,:";

        //when
        String[] result = delimiterProcessor.splitByDelimiter(userInput, delimiter);

        //then
        assertThat(result).contains("1","2","3","4","5");
    }

    @Test
    @DisplayName("빈 문자열 또는 구분자가 없을 때 기본값을 처리한다.")
    public void 빈_문자열을_입력하거나_구분자가_없을_경우() {
        //given
        String userInput = "0";
        String delimiter = "";

        //when
        String[] result = delimiterProcessor.splitByDelimiter(userInput, delimiter);

        //then
        assertThat(result).contains("0");
    }


}