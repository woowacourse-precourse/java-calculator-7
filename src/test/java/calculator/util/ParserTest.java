package calculator.util;

import static org.junit.jupiter.api.Assertions.*;

import calculator.domain.Delimiter;
import calculator.domain.Number;
import java.util.List;
import org.junit.jupiter.api.*;

class ParserTest {

    @DisplayName("커스텀 구분자가 있는 문자열에서 파싱 테스트")
    @Test
    void givenInputStringWithCustomDelimiter_whenParsingDelimiter_thenReturnCustomDelimiter() throws Exception
    {
        // given
        String input = "//;\n1;2;3";
        String expected = ";";

        // when
        String actual = Parser.parseCustomDelimiter(input);

        // then
        assertEquals(expected, actual);
    }

    @DisplayName("커스텀 구분자가 없는 문자열에서 파싱 테스트")
    @Test
    void givenInputStringWithoutCustomDelimiter_whenParsingDelimiter_thenReturnEmptyString() throws Exception
    {
        // given
        String input = "1,2:3";
        String expected = "";

        // when
        String actual = Parser.parseCustomDelimiter(input);

        // then
        assertEquals(expected, actual);
    }

    @DisplayName("커스텀 구분자가 빈 문자인 문자열에서 파싱 테스트")
    @Test
    void givenInputStringWithCustomDelimiter_whenParsingDelimiter_thenReturnEmptyString() throws Exception
    {
        // given
        String input = "//\n1;2;3";
        String expected = "";

        // when
        String actual = Parser.parseCustomDelimiter(input);

        // then
        assertEquals(expected, actual);
    }

    @DisplayName("커스텀 구분자 없는 문자열에서 숫자 파싱 테스트")
    @Test
    void givenInputString_whenParsingNumber_thenReturnNumbers() throws Exception
    {
        // given
        String input = "1,2:3";
        Delimiter delimiter = new Delimiter();
        List<Number> expected = List.of(new Number(1), new Number(2), new Number(3));

        // when
        List<Number> actual = Parser.parseNumber(input, delimiter);

        // then
        assertEquals(expected, actual);
    }

    @DisplayName("커스텀 구분자 있는 문자열에서 숫자 파싱 테스트")
    @Test
    void givenInputStringWithCustomDelimiter_whenParsingNumber_thenReturnNumbers() throws Exception
    {
        // given
        String input = "//;\n1,2:3;4";
        Delimiter delimiter = new Delimiter();
        delimiter.addCustomDelimiter(Parser.parseCustomDelimiter(input));
        List<Number> expected = List.of(new Number(1), new Number(2), new Number(3), new Number(4));

        // when
        List<Number> actual = Parser.parseNumber(input, delimiter);

        // then
        assertEquals(expected, actual);
    }
}