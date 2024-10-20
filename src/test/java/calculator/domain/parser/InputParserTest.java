package calculator.domain.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.domain.dto.InputRequest;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    @DisplayName("빈 문자열 입력 테스트")
    void testEmptyInput() {
        String input = "";
        String expectedDelimiters = ",|:";
        InputRequest request = InputParser.parseDelimiterAndInput(input);
        assertEquals(request.delimiters(), expectedDelimiters);
    }

    @Test
    @DisplayName("기본 구분자 테스트")
    void testDefaultDelimiters() {
        String input = "1:2,3";
        String expectedDelimiters = ",|:";
        InputRequest request = InputParser.parseDelimiterAndInput(input);
        assertEquals(request.delimiters(), expectedDelimiters);
    }

    @Test
    @DisplayName("무분별한 기분 구분자 테스트")
    void testExcessiveDefaultDelimiters() {
        String input = "1:::";
        String expectedDelimiters = ",|:";
        InputRequest request = InputParser.parseDelimiterAndInput(input);
        assertEquals(request.delimiters(), expectedDelimiters);
    }

    @Test
    @DisplayName("기본 구분자 예외 테스트 - 시작이 정수가 아닌 경우")
    void testExceptionWhenStartingWithNonIntegerNegative() {
        String input = "-1,2,3";
        assertThrows(IllegalArgumentException.class, () ->
                InputParser.parseDelimiterAndInput(input)
        );
    }

    @Test
    @DisplayName("기본 구분자 예외 테스트 - 시작이 정수가 아닌 경우")
    void testExceptionWhenStartingWithNonIntegerSpecial() {
        String input = "/1,2,3";
        assertThrows(IllegalArgumentException.class, () ->
                InputParser.parseDelimiterAndInput(input)
        );
    }

    @Test
    @DisplayName("커스텀 구분자 테스트 - ;")
    void testCustomDelimiterSemicolon() {
        String input = "//;\\n1;2;3";
        String expectedDelimiters = ",|:|" + Pattern.quote(";");
        InputRequest request = InputParser.parseDelimiterAndInput(input);
        assertEquals(request.delimiters(), expectedDelimiters);
    }

    @Test
    @DisplayName("커스텀 구분자 테스트 - 공백")
    void testCustomDelimiterSpace() {
        String input = "// \\n1 2 3";
        String expectedDelimiters = ",|:|" + Pattern.quote(" ");
        InputRequest request = InputParser.parseDelimiterAndInput(input);
        assertEquals(request.delimiters(), expectedDelimiters);
    }

    @Test
    @DisplayName("커스텀 구분자 테스트 - ?")
    void testCustomDelimiterQuestionMark() {
        String input = "//?\\n1?2";
        String expectedDelimiters = ",|:|" + Pattern.quote("?");
        InputRequest request = InputParser.parseDelimiterAndInput(input);
        assertEquals(request.delimiters(), expectedDelimiters);
    }

    @Test
    @DisplayName("커스텀 구분자 테스트 - ;;")
    void testCustomDelimiterDoubleSemicolon() {
        String input = "//;;\\n1;;2;;3";
        String expectedDelimiters = ",|:|" + Pattern.quote(";;");
        InputRequest request = InputParser.parseDelimiterAndInput(input);
        assertEquals(request.delimiters(), expectedDelimiters);
    }

    @Test
    @DisplayName("커스텀 구분자 테스트 - ;;;;; 1~5자 허용")
    void testExceptionWhenCustomDelimiterLengthExceedsFive() {
        String input = "//;;;;;1;;;;;2;;;;;3";
        assertThrows(IllegalArgumentException.class, () ->
                InputParser.parseDelimiterAndInput(input)
        );
    }

    @Test
    @DisplayName("커스텀 구분자 예외 테스트 - \\n 미입력")
    void testExceptionWhenNewlineNotProvided() {
        String input = "//;;1;;2;;3";
        assertThrows(IllegalArgumentException.class, () ->
                InputParser.parseDelimiterAndInput(input)
        );
    }

    @Test
    @DisplayName("커스텀 구분자 예외 테스트 - \\n 미입력")
    void testExceptionWhenNewlineNotProvidedSpecial() {
        String input = "//;n1";
        assertThrows(IllegalArgumentException.class, () ->
                InputParser.parseDelimiterAndInput(input)
        );
    }

    @Test
    @DisplayName("커스텀 구분자 예외 테스트 - 구분자에 정수가 포함된 경우")
    void testExceptionWhenDelimiterContainsInteger() {
        String input = "//1\\n112";
        assertThrows(IllegalArgumentException.class, () ->
                InputParser.parseDelimiterAndInput(input)
        );
    }

    @Test
    @DisplayName("커스텀 구분자 예외 테스트 - 구분자에 정수가 포함된 경우")
    void testExceptionWhenDelimiterContainsIntegerSpecial() {
        String input = "//!1!\\n11!1!2!1!";
        assertThrows(IllegalArgumentException.class, () ->
                InputParser.parseDelimiterAndInput(input)
        );
    }

    @Test
    @DisplayName("기본 구분자 및 커스텀 구분자 예외 테스트 - 입력 조건에 충족하지 않는 경우")
    void testExceptionWhenInputDoesNotMeetConditions1() {
        String input = "!//!\\n1!1";
        assertThrows(IllegalArgumentException.class, () ->
                InputParser.parseDelimiterAndInput(input)
        );
    }

    @Test
    @DisplayName("기본 구분자 및 커스텀 구분자 예외 테스트 - 입력 조건에 충족하지 않는 경우")
    void testExceptionWhenInputDoesNotMeetConditions2() {
        String input = "/;\\n1";
        assertThrows(IllegalArgumentException.class, () ->
                InputParser.parseDelimiterAndInput(input)
        );
    }

    @Test
    @DisplayName("기본 구분자 및 커스텀 구분자 예외 테스트 - 입력 조건에 충족하지 않는 경우")
    void testExceptionWhenInputDoesNotMeetConditions3() {
        String input = "/n;\\n1";
        assertThrows(IllegalArgumentException.class, () ->
                InputParser.parseDelimiterAndInput(input)
        );
    }
}
