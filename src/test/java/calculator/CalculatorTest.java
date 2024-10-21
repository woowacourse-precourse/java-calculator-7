package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void 계산_시나리오_테스트() {
        Delimiter delimiter = new Delimiter();
        DelimiterParser dp = new DelimiterParser();

        String input = "//@\\n1,2,3//,\\n4:5:6//!\\n7!8!9//_\\n";
//        String input = "1r2r3!//r\\n//!\\n";
        String customDelimiter = dp.findCustomDelimiter(input);

        delimiter.addCustomDelimiter(customDelimiter);
        input = dp.removeCustomDelimiterRegistrant(input);

        Calculator calculator = new Calculator(delimiter, input);
        long result = calculator.calculate();

        assertThat(result).isEqualTo(45L);
    }

    @Test
    void 기본_구분자와_커스텀_구분자가_아닌_문자를_입력한_경우() {
        Delimiter delimiter = new Delimiter();
        DelimiterParser dp = new DelimiterParser();

        String input = "1,2,3//,\\n4:5:6//!\\n7!8@9//_\\n";
        String customDelimiter = dp.findCustomDelimiter(input);

        delimiter.addCustomDelimiter(customDelimiter);
        input = dp.removeCustomDelimiterRegistrant(input);

        Calculator calculator = new Calculator(delimiter, input);
        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자를_0이하로_입력한_경우() {
        Delimiter delimiter = new Delimiter();
        DelimiterParser dp = new DelimiterParser();

        String input = "-1,2,3";
        String customDelimiter = dp.findCustomDelimiter(input);

        delimiter.addCustomDelimiter(customDelimiter);
        input = dp.removeCustomDelimiterRegistrant(input);

        Calculator calculator = new Calculator(delimiter, input);
        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자료형_범위_밖의_숫자를_입력한_경우() {
        Delimiter delimiter = new Delimiter();
        DelimiterParser dp = new DelimiterParser();

        String input = "2147483648:1:2:3";
        String customDelimiter = dp.findCustomDelimiter(input);

        delimiter.addCustomDelimiter(customDelimiter);
        input = dp.removeCustomDelimiterRegistrant(input);

        Calculator calculator = new Calculator(delimiter, input);
        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(IllegalArgumentException.class);
    }


}