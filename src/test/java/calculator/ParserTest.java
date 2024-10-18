package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ParserTest {

    private Parser parser = new Parser();

    @DisplayName("빈 문자열 또는 null 값이 들어올 경우 0을 반환하기 테스트")
    @Test
    void emptyOrNullTest() {
        String input = "";
        String[] expectedNumber = {"0"};
        assertThat(parser.parse(input)).isEqualTo(expectedNumber);
        input = null;
        assertThat(parser.parse(input)).isEqualTo(expectedNumber);
    }

    @DisplayName("기본 구분자(쉼표, 클론)를 기준으로 숫자 분리하기 테스트")
    @Test
    void defaultDelimiterParsingTest() {
        String input = "1,2,3";
        String[] expectedNumbers = {"1", "2", "3"};
        assertThat(parser.parse(input)).isEqualTo(expectedNumbers);
        input = "1,2:3";
        assertThat(parser.parse(input)).isEqualTo(expectedNumbers);
        input = "1:2:3:";
        assertThat(parser.parse(input)).isEqualTo(expectedNumbers);
    }

    @DisplayName("커스텀 구분자를 기준으로 숫자 분리하기 테스트")
    @Test
    void customDelimiterParsingTest() {
        String input = "//;\\n1;2;3";
        String[] expectedNumbers = {"1", "2", "3"};
        assertThat(parser.parse(input)).isEqualTo(expectedNumbers);
    }

    @DisplayName("커스텀 구분자 사용되었는지 여부 테스트")
    @Test
    void isCustomDelimiterTest() {
        boolean isCustom = parser.isCustomDelimiter("//;\\n1;2;3");
        assertThat(isCustom).isTrue();
    }
}
