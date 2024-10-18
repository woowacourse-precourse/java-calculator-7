package calculator;

import calculator.Interface.Calculator;
import calculator.Interface.Parser;
import calculator.Model.CalculatorModel;
import calculator.Service.InputParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class CustomParseTest {

    private Parser inputParser;

    @BeforeEach
    void setUp(){
        inputParser = new InputParser();
    }

    @Test
    void Default_Separators(){
        inputParser.setInput(":1::2,3:4");
        inputParser.parseCustomSeparator();
        String[] tokens = inputParser.getTokens();
        assertThat(tokens).containsExactly("1","2","3","4");
    }

    @Test
    void Custom_Separators(){
        inputParser.setInput("//a\\n1a2a:4");
        inputParser.parseCustomSeparator();
        String[] tokens = inputParser.getTokens();
        assertThat(tokens).containsExactly("1","2","4");
    }

    @Test
    void Many_Custom_Separators(){
        inputParser.setInput("//abcd<>+-)(\\n1+2-3)4d(5>6");
        inputParser.parseCustomSeparator();
        String[] tokens = inputParser.getTokens();
        assertThat(tokens).containsExactly("1","2","3","4","5","6");
    }

}
