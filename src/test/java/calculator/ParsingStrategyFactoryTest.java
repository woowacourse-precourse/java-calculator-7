package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParsingStrategyFactoryTest {

    @Test
    void 커스텀_구분자_전략_선택() {
        ParsingStrategy strategy = ParsingStrategyFactory.getStrategy("//;\n1;2;3");
        assertTrue(strategy instanceof CustomParsingStrategy, "Expected CustomParsingStrategy for custom delimiter input");
    }

    @Test
    void 기본_구분자_전략_선택() {
        ParsingStrategy strategy = ParsingStrategyFactory.getStrategy("1,2,3");
        assertTrue(strategy instanceof DefaultParsingStrategy, "Expected DefaultParsingStrategy for default delimiter input");
    }

    @Test
    void 빈_문자열_기본_전략_선택() {
        ParsingStrategy strategy = ParsingStrategyFactory.getStrategy("");
        assertTrue(strategy instanceof DefaultParsingStrategy, "Expected DefaultParsingStrategy for empty input");
    }
}
