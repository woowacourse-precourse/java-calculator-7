package calculator.Parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.dto.InputRequest;
import calculator.parser.InputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    @Test
    @DisplayName("입력 값 null 테스트")
    void nullInputTest() {
        String input = null;

        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    @DisplayName("빈 문자열 테스트")
    void EmptyInputTest() {
        String input = "";
        InputRequest inputRequest = InputParser.parseInput(input);
        assertThat(inputRequest.factors()[0].isEmpty());
    }

    @Test
    @DisplayName("기본 구분자 사용 테스트")
    void defaultDelimiterTest() {
        String input = "1,2,3";
        String[] expetedResult = {"1", "2", "3"};
        InputRequest inputRueqest = InputParser.parseInput(input);
        assertArrayEquals(inputRueqest.factors(), expetedResult);
    }

    @Test
    @DisplayName("기본 구분자 연속 사용 테스트")
    void consecutiveDefaultDelimiterTest() {
        String input = "1,,2,,3";
        String[] expectedResult = {"1", "", "2", "", "3"};
        InputRequest result = InputParser.parseInput(input);

        assertArrayEquals(result.factors(), expectedResult);
    }

    @Test
    @DisplayName("시작 값이 숫자가 아닌 경우 테스트")
    void doNotStartNumberTest() {
        String input = "*1,2,3";
        String[] expectedResult = {"*1", "2", "3"};
        InputRequest result = InputParser.parseInput(input);

        assertArrayEquals(result.factors(), expectedResult);
    }

    @Test
    @DisplayName("마지막에 기본 구분자 사용")
    void lastDefaultDelimiterTest() {
        String input = "1,2,3,";
        String[] expectedResult = {"1", "2", "3"};
        InputRequest result = InputParser.parseInput(input);

        assertArrayEquals(result.factors(), expectedResult);
    }

    @Test
    @DisplayName("커스텀 구분자 사용 테스트")
    void customDelimiterTest() {
        String input = "//;\\n1;2;3"; // \n을 문자열로 인식을 위한 \추가
        String[] expectedResult = {"1", "2", "3"};
        InputRequest result = InputParser.parseInput(input);

        assertArrayEquals(result.factors(), expectedResult);
    }

    @Test
    @DisplayName("입력 값 시작이 커스텀 구분자인 경우")
    void firstCustomDelimiterTest() {
        String input = "//;\\n;1;2;3"; // \n을 문자열로 인식을 위한 \추가
        String[] expectedResult = {"", "1", "2", "3"};
        InputRequest result = InputParser.parseInput(input);

        assertArrayEquals(result.factors(), expectedResult);
    }

    @Test
    @DisplayName("마무리 값이 커스텀 구분자인 경우")
    void lastCustomDelimiterTest() {
        String input = "//;\\n1;2;3;"; // \n을 문자열로 인식을 위한 \추가
        String[] expectedResult = {"1", "2", "3"};
        InputRequest result = InputParser.parseInput(input);

        assertArrayEquals(result.factors(), expectedResult);
    }

    @Test
    @DisplayName("커스텀 구분자가 없는 경우")
    void emptyCustomDelimiterTest() {
        String input = "//\\n123"; // \n을 문자열로 인식을 위한 \추가

        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.parseInput(input);
        });
    }

    @Test
    @DisplayName("커스텀 구분자가 space인 경우")
    void spaceCustomDelimiterTest() {
        String input = "// \\n1 2 3"; // \n을 문자열로 인식을 위한 \추가

        String[] expectedResult = {"1", "2", "3"};
        InputRequest result = InputParser.parseInput(input);

        assertArrayEquals(result.factors(), expectedResult);
    }

    @Test
    @DisplayName("커스텀 구분자가 문자열인 경우")
    void stringCustomDelimiterTest() {
        String input = "//tt\\n1tt2tt3"; // \n을 문자열로 인식을 위한 \추가

        String[] expectedResult = {"1", "2", "3"};
        InputRequest result = InputParser.parseInput(input);

        assertArrayEquals(result.factors(), expectedResult);
    }

    @Test
    @DisplayName("커스텀 구분자가 여러개의 특수문자인 경우")
    void specialCharCustomDelimiterTest() {
        String input = "//**\\n1**2**3"; // \n을 문자열로 인식을 위한 \추가

        String[] expectedResult = {"1", "2", "3"};
        InputRequest result = InputParser.parseInput(input);

        assertArrayEquals(result.factors(), expectedResult);
    }
}
