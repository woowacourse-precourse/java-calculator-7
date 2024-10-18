package calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterParserTest {

    DelimiterParser delimiterParser;

    @BeforeEach
    public void setup(){
        delimiterParser = new DelimiterParser();
    }

    @Test
    public void 커스텀_구분자를_입력하지_않은_경우의_구분자(){
        String delimiters = delimiterParser.parseDelimiter("1,2;3");
        assertThat(",|:").isEqualTo(delimiters); //기본 구분자 ,|:
    }

    @Test
    public void 커스텀_구분자를_입력한_경우의_구분자(){
        String delimiters = delimiterParser.parseDelimiter("//;\\n1,2;3");
        assertThat(",|:|;").isEqualTo(delimiters); //기본 구분자와 커스텀 구분자인 ;을 포함
    }

    @Test
    public void 커스텀_구분자를_입력한_경우_구분자_뒤에_숫자_분리(){
        String numbers = delimiterParser.extractNumbers("//;\\n1;2;3");
        assertThat("1;2;3").isEqualTo(numbers); // \n 뒤에 있는 숫자 문자열 자르기
    }

}