package calculator.delimiter.factory;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.delimiter.handler.ColonSemicolonDelimiterHandler;
import calculator.delimiter.handler.CustomDelimiterHandler;
import calculator.delimiter.handler.DelimiterHandler;
import calculator.delimiter.handler.NoDelimiterHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterHandlerFactoryTest {
    private DelimiterHandlerFactory factory = new DelimiterHandlerFactory();

    @Test
    @DisplayName("구분자가 ,와 :인 경우, ColonSemicolonDelimiterHandler을 가진다.")
    void when_commaAndColon_are_delimiters_then_return_colonSemicolonDelimiterHandler_() {
        // given
        String str = "1,2:3";

        // when
        DelimiterHandler handler = factory.getHandler(str);

        // then
        assertThat(handler).isInstanceOf(ColonSemicolonDelimiterHandler.class);
        assertThat(handler.split(str)).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("구분자가 ,와 :가 아닌 custom인 경우, CustomDelimiterHandler를 가진다.")
    void when_customDelimiter_is_used_then_return_customDelimiterHandler() {
        // given
        String str = "//|\\n1|2|3";

        // when
        DelimiterHandler handler = factory.getHandler(str);

        // then
        assertThat(handler).isInstanceOf(CustomDelimiterHandler.class);
        assertThat(handler.split(str)).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("빈 문자열일 경우 NoDelimeterHandler를 가진다.")
    void test1() {
        // given
        String str = "";

        // when
        DelimiterHandler handler = factory.getHandler(str);

        // then
        System.out.println(handler);
        assertThat(handler).isInstanceOf(NoDelimiterHandler.class);
    }
}