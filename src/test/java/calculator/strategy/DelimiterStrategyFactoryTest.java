package calculator.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DelimiterStrategyFactoryTest {
    @Test
    void 커스텀_구분자_입력() {
        // given
        String input = "//;\\n1;2;3";

        // when
        DelimiterStrategy strategy = DelimiterStrategyFactory.getDelimiterStrategy(input);

        // then
        assertTrue(strategy instanceof CustomDelimiterStrategy);
    }

    @Test
    void 기본_구분자_입력() {
        // given
        String input = "1,2:3";

        // when
        DelimiterStrategy strategy = DelimiterStrategyFactory.getDelimiterStrategy(input);

        // then
        assertTrue(strategy instanceof DefaultDelimiterStrategy);
    }
}
