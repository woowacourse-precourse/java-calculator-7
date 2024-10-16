package calculator.delimiter.factory;

import calculator.delimiter.handler.impl.ColonSemicolonDelimiterHandler;
import calculator.delimiter.handler.impl.CustomDelimiterHandler;
import calculator.delimiter.handler.DelimiterHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterHandlerFactoryTest {
    @Test
    @DisplayName("구분자가 ,와 :인 경우, ColonSemicolonDelimiterHandler을 가진다.")
    void when_commaAndColon_are_delimiters_then_return_colonSemicolonDelimiterHandler_() {
        DelimiterHandlerFactory factory = new DelimiterHandlerFactory();
        String str = "1,2:3";

        DelimiterHandler handler = factory.getHandler(str);

        assertThat(handler).isInstanceOf(ColonSemicolonDelimiterHandler.class);

        assertThat(handler.split(str)).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("구분자가 ,와 :가 아닌 custom인 경우, CustomDelimiterHandler를 가진다.")
    void when_customDelimiter_is_used_then_return_customDelimiterHandler() {
        DelimiterHandlerFactory factory = new DelimiterHandlerFactory();
        String str = "//|\n1|2|3";

        DelimiterHandler handler = factory.getHandler(str);

        assertThat(handler).isInstanceOf(CustomDelimiterHandler.class);

        assertThat(handler.split(str)).containsExactly("1", "2", "3");
    }
}