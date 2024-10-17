package calculator.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimiterParserTest {

    DelimiterParser delimiterParser;

    @BeforeEach
    void before() {
        delimiterParser = new DelimiterParser();
    }

    @Test
    void TDD_기본_구분자_반환() {
        //when
        List<String> basicDelimiters = delimiterParser.getBasicDelimiters();

        //then
        assertThat(basicDelimiters).contains(":", ",");
    }

    @Test
    void TDD_커스텀_구분자_공백_반환() {
        //given
        String input = "1:2,3";

        //when
        String customDelimiter = delimiterParser.getCustomDelimiter(input);

        //then
        assertThat(customDelimiter).isEqualTo("");
    }

    @Test
    void TDD_커스텀_구분자_반환() {
        //given
        String input = "//|\n1:2|3";

        //when
        String customDelimiter = delimiterParser.getCustomDelimiter(input);

        //then
        assertThat(customDelimiter).isEqualTo("|");
    }

    @Test
    void TDD_커스텀_구분자_존재시_계산_필요한_문자열_추출() {
        //given
        String input = "//|\n1:2|3";

        //when
        String customDelimiter = delimiterParser.getCustomDelimiter(input);
        input = delimiterParser.replaceCustomDelimiterSyntax(input, customDelimiter);

        //then
        assertThat(input).isEqualTo("1:2|3");
    }
}
