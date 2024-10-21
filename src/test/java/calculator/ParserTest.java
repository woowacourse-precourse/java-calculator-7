package calculator;

import calculator.delimiter.Delimiter;
import calculator.delimiter.DelimiterFactory;
import calculator.parser.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {
    private Parser parser;
    private Delimiter delimiter;

    @BeforeEach
    void resetResult() {
        // 각 테스트 전에 Parser.result를 0으로 초기화하여 테스트 간 상태를 공유하지 않도록 함
        parser = new Parser();
    }

    @Test
    @DisplayName("커스텀 구분자로 시작하는 입력은 업데이트된 구분자로 파싱됩니다.")
    void startsWithCustomDelimiter() {
        //given
        String input = "//?\\n1,2?3";
        delimiter = DelimiterFactory.createDelimiter(input);
        input = delimiter.parseDelimiter(input);
        //when
        String result = parser.parse(input, delimiter);
        String require = "6";
        //then
        Assertions.assertEquals(require, result);
    }

    @Test
    @DisplayName("숫자로 시작하는 입력은 기본 구분자로 파싱됩니다.")
    void startsWithPositiveNumber() {
        ///given
        String input = "1,2,3:4";
        delimiter = DelimiterFactory.createDelimiter(input);
        input = delimiter.parseDelimiter(input);
        //when
        String result = parser.parse(input, delimiter);
        String require = "10";
        //then
        Assertions.assertEquals(require, result);
    }
}