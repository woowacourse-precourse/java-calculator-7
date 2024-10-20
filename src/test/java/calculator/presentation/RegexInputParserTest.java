package calculator.presentation;

import calculator.presentation.parser.RegexInputParser;
import calculator.presentation.request.CalculatorRequest;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class RegexInputParserTest {

    @Test
    void 커스텀_등록자_등록_요청을_형식에_맞게_작성한다() {
        // given
        String input = "//;\\n1;2;3";

        // when
        RegexInputParser validator = new RegexInputParser();
        CalculatorRequest calculatorRequest = validator.parseToRequest(input);

        // then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(calculatorRequest.getCustomDelimiter()).isEqualTo(";");
            softly.assertThat(calculatorRequest.getTokens()).isEqualTo("1;2;3");
        });
    }

    @Test
    void 커스텀_등록자_등록_요청이_없다면_토큰_값만_반환한다() {
        // given
        String input = "1;2;3";

        // when
        RegexInputParser validator = new RegexInputParser();
        CalculatorRequest calculatorRequest = validator.parseToRequest(input);

        // then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(calculatorRequest.getCustomDelimiter()).isNull();
            softly.assertThat(calculatorRequest.getTokens()).isEqualTo("1;2;3");
        });
    }
}
