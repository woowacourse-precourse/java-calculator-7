package calculator.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.dto.CalculatorRequest;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

public class DelimiterParserTest {

    @Test
    void 기본_구분자_반환() {
        assertSimpleTest(() -> {
            String input = "1,2,3:4";
            String expected = "[,:]";
            CalculatorRequest request = DelimiterParser.parseDelimiters(input);
            assertThat(request.delimiters()).isEqualTo(expected);
        });
    }

    @Test
    void 빈문자열_입력_시_기본_구분자_반환() {
        assertSimpleTest(() -> {
            String input = "";
            String expected = "[,:]";
            CalculatorRequest request = DelimiterParser.parseDelimiters(input);
            assertThat(request.delimiters()).isEqualTo(expected);
        });
    }

    @Test
    void 커스텀_구분자_1문자() {
        assertSimpleTest(() -> {
            String input = "//;\\n1;2;3";
            String expected = Pattern.quote(";");
            CalculatorRequest request = DelimiterParser.parseDelimiters(input);
            assertThat(request.delimiters()).isEqualTo(expected);
        });
    }

    @Test
    void 커스텀_구분자_2문자_이상() {
        assertSimpleTest(() -> {
            String input = "//;,\\n1;,2;,3";
            String expected = Pattern.quote(";,");
            CalculatorRequest request = DelimiterParser.parseDelimiters(input);
            assertThat(request.delimiters()).isEqualTo(expected);
        });
    }

    @Test
    void 잘못된_커스텀_구분자_형식1() {
        assertSimpleTest(() -> {
            String input = "//;1;2;3";
            assertThatThrownBy(() -> DelimiterParser.parseDelimiters(input))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 잘못된_커스텀_구분자_형식2() {
        assertSimpleTest(() -> {
            String input = "/;\\n1;2;3";
            assertThatThrownBy(() -> DelimiterParser.parseDelimiters(input))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 존재X_커스텀_구분자() {
        assertSimpleTest(() -> {
            String input = "//\\n1;2;3";
            assertThatThrownBy(() -> DelimiterParser.parseDelimiters(input))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }
}
