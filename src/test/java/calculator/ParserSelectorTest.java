package calculator;

import calculator.parser.BasicStringParser;
import calculator.parser.CustomStringParser;
import calculator.parser.ParserSelector;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParserSelectorTest {
    @Test
    void 적절한_Parser_리턴(){
        assertThat(ParserSelector.select("1:2:3")).isInstanceOf(BasicStringParser.class);
        assertThat(ParserSelector.select("//;\\n1;2;3")).isInstanceOf(CustomStringParser.class);
    }
}
