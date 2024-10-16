package calculator;

import calculator.service.CalculatorService;
import calculator.service.DelimiterService;
import calculator.util.StringNumberSumCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    DelimiterService delimiterService = new DelimiterService();
    CalculatorService calculatorService = new CalculatorService(delimiterService);

    @Test
    @DisplayName("기본 구분자(콤마와 콜론)를 기준으로 숫자를 추출하여 합을 구한다.")
    void 기본_구분자로_숫자를_추출하여_합을_구한다() {
        // given
        String input = "1,2:3";

        // when
        int result = calculatorService.calculateSum(input);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 기준으로 숫자를 추출하여 합을 구한다.")
    public void 커스텀_구분자로_숫자를_추출하여_합을_구한다() {
        // given
        String input = "//;\n1;2;3";

        // when
        int result = splitCustomDelimiter(input);

        // then
        assertThat(result).isEqualTo(6);
    }

    private int splitCustomDelimiter(String input) {
        String regex = "//(.)\n(.*)";
        Matcher matcher = Pattern.compile(regex).matcher(input);

        if (!matcher.find()) {
            throw new IllegalArgumentException("No match found");
        }

        String[] split = matcher.group(2).split(matcher.group(1));
        return StringNumberSumCalculator.sum(split);
    }

}