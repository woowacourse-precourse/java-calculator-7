package calculator.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DelimiterParserTest {

    DelimiterParser delimiterParser;

    @BeforeEach
    public void setup(){
        delimiterParser = new DelimiterParser();
    }

    @Test
    @DisplayName("커스텀 구분자를 입력하지 않은 경우")
    public void test1(){
        String delimiters = delimiterParser.parseDelimiter("1,2;3");
        assertThat(",|:").isEqualTo(delimiters); //기본 구분자 ,|:
    }

    @Test
    @DisplayName("커스텀 구분자를 입력한 경우 1")
    public void test2(){
        String delimiters = delimiterParser.parseDelimiter("//;\\n1,2;3");
        assertThat(",|:|;").isEqualTo(delimiters); //기본 구분자와 커스텀 구분자인 ;을 포함
    }

    @Test
    @DisplayName("커스텀 구분자를 입력한 경우 2")
    public void test3(){
        String delimiters = delimiterParser.parseDelimiter("//;;;\\n1,2;;;3");
        assertThat(",|:|;;;").isEqualTo(delimiters); //기본 구분자와 커스텀 구분자인 ;을 포함
    }


    @Test
    @DisplayName("커스텀 구분자 입력 형식이 잘못된 경우 1")
    public void test4(){
        assertThatThrownBy(() -> delimiterParser.parseDelimiter("//;//n1,2;3"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("커스텀 구분자 지정 형식이 잘못 되었습니다.");
    }

    @Test
    @DisplayName("커스텀 구분자 입력 형식이 잘못된 경우 2")
    public void test5(){
        assertThatThrownBy(() -> delimiterParser.parseDelimiter("//;1,2;3"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("커스텀 구분자 지정 형식이 잘못 되었습니다.");
    }

    @Test
    @DisplayName("커스텀 구분자에 숫자가 입력될 경우")
    public void test6(){
        assertThatThrownBy(() -> delimiterParser.parseDelimiter("//a1a\\n;1,2;3"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("커스텀 구분자 지정 형식이 잘못 되었습니다.");
    }

    @Test
    @DisplayName("커스텀 구분자 입력한 경우 구분자 뒤에 숫자 분리")
    public void test7(){
        String numbers = delimiterParser.extractNumbers("//;\\n1;2;3");
        assertThat("1;2;3").isEqualTo(numbers); // \n 뒤에 있는 숫자 문자열 자르기
    }

}