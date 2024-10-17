package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    SeparatorExtractor separator = new SeparatorExtractor();

    @Test
    void 문자열이_비었으면_결과는_0이다() {
        String arg = "";

        SeparatorExtractor.ExtractResult extractResult = separator.extract(arg);
        String exp = extractResult.getExpression();
        Character separator = extractResult.getSeparator().orElse(null);

        Calculator calculator;
        if (separator == null) {
            calculator = new Calculator(exp);
        } else {
            calculator = new Calculator(exp, separator);
        }

        int result = calculator.calculate();

        assertThat(result).isEqualTo(0);
    }

    @Test
    void 문자열에_숫자만_있으면_결과는_그_숫자다() {
        String arg = "1083467";

        SeparatorExtractor.ExtractResult extractResult = separator.extract(arg);
        String exp = extractResult.getExpression();
        Character separator = extractResult.getSeparator().orElse(null);

        Calculator calculator;
        if (separator == null) {
            calculator = new Calculator(exp);
        } else {
            calculator = new Calculator(exp, separator);
        }

        int result = calculator.calculate();

        assertThat(result).isEqualTo(1083467);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3,4:5,6:7,8:9", "//?\\n1,2:3?4?5?6:7,8:9", "//;\\n1,2:3;4,5:6;7,8:9;"})
    void 구분자_사이의_정수를_처리할_수_있다(String arg) {
        SeparatorExtractor.ExtractResult extractResult = separator.extract(arg);
        String exp = extractResult.getExpression();
        Character separator = extractResult.getSeparator().orElse(null);

        Calculator calculator;
        if (separator == null) {
            calculator = new Calculator(exp);
        } else {
            calculator = new Calculator(exp, separator);
        }

        int result = calculator.calculate();

        assertThat(result).isEqualTo(45);
    }

    @ParameterizedTest
    @ValueSource(strings = {",:,:", "//@\\n,:@@:@:,"})
    void 구분자가_연속으로_나오면_0으로_간주한다(String arg) {
        SeparatorExtractor.ExtractResult extractResult = separator.extract(arg);
        String exp = extractResult.getExpression();
        Character separator = extractResult.getSeparator().orElse(null);

        Calculator calculator;
        if (separator == null) {
            calculator = new Calculator(exp);
        } else {
            calculator = new Calculator(exp, separator);
        }

        int result = calculator.calculate();

        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 ,2:3,4:5,6:7,8:9" // 공백
            , "1,2:3,4:5,6:7,8:9.3" // 실수(Real Number)
            , "1,-2:3,4:5,6:7,8:9" // 음수
            , "1x,2:3,4:5,6:7,8:9" // 문자
    })
    void 구분자_사이가_양의_정수가_아니면_예외가_발생한다(String arg) {
        SeparatorExtractor.ExtractResult extractResult = separator.extract(arg);
        String exp = extractResult.getExpression();
        Character separator = extractResult.getSeparator().orElse(null);

        Calculator calculator;
        if (separator == null) {
            calculator = new Calculator(exp);
        } else {
            calculator = new Calculator(exp, separator);
        }

        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(IllegalArgumentException.class);
    }
}