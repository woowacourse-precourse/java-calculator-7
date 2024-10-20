package calculator.back.resolver;

import calculator.back.dto.RequestDTO;
import calculator.front.input.CustomDelimiterParsedInput;
import calculator.front.input.TotalDelimitedInput;
import calculator.front.parser.CustomDelimiterParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ArgumentResolverTest {

    @Test
    @DisplayName("TotalDelimitedInput을 ReqeustDTO 객체로 변환")
    void 객체_변환_테스트() {
        //given
        String rawInput = "//;\\n1:2:3";
        ArgumentResolver argumentResolver = new ArgumentResolver();
        //when
        CustomDelimiterParsedInput customDelimiterParsedInput = CustomDelimiterParser.parse(rawInput);
        TotalDelimitedInput totalDelimitedInput = TotalDelimitedInput.fromCustomDelimiterParseInput(
                customDelimiterParsedInput);
        RequestDTO requestDTO = argumentResolver.resolve(totalDelimitedInput);
        //then
        assertThat(requestDTO.delimiters()).isEqualTo(totalDelimitedInput.getDelimiters());
        assertThat(requestDTO.inputWithDelimiters()).isEqualTo(totalDelimitedInput.getInputWithDelimiters());
    }
}