package calculator;


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

    @DisplayName("커스텀 구분자로 시작하는 입력은 업데이트된 구분자로 파싱됩니다.")
    @Test
    void startsWithCustomDelimiter() {
        //given
        delimiter = new CustomDelimiter();
        String input = delimiter.parseDelimiter("//?\\n1,2?3");
        String require = "6";
        //when
        String result = parser.parse(input, delimiter);
        //then
        Assertions.assertEquals(require, result);
    }

    @DisplayName("숫자로 시작하는 입력은 기본 구분자로 파싱됩니다.")
    @Test
    void startsWithPositiveNumber() {
        ///given
        delimiter = new DefaultDelimiter();
        String input = delimiter.parseDelimiter("1,2,3:4");
        String require = "10";
        //when
        String result = parser.parse(input, delimiter);
        //then
        Assertions.assertEquals(require, result);
    }
}