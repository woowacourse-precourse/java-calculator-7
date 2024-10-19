package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.model.DelimiterHandler;
import calculator.model.ExpressionHandler;
import calculator.model.TokenCalculator;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.StringTokenizer;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    // 문제에서 제공한 테스트 2개
    @Test
    void usingCustomDelimiterTest() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void exceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 개인 테스트
    @Test
    void getCustomDelimiterTest() {
        assertSimpleTest(() -> {
            String expression = "//.\\n1,2";
            DelimiterHandler delimiterHandler = new DelimiterHandler(expression);
            assertThat(delimiterHandler.getAllDelimiters().contains(".,:"));
        });
    }

    @Test
    void filterExpressionTest1() {
        String expression = "//;\\n1,2,";
        String delimiter = ",:;";
        ExpressionHandler expressionHandler = new ExpressionHandler(expression, delimiter, true);
        assertThat(expressionHandler.getExpression()).contains("1,2,");
    }

    @Test
    void filterExpressionTest2() {
        String expression = "/;\\n1,2,";
        String delimiter = ",:;";
        ExpressionHandler expressionHandler = new ExpressionHandler(expression, delimiter, false);
        assertThat(expressionHandler.getExpression()).contains("/;\\n1,2,");
    }

    @Test
    void getSumTest1() {
        String expression = "1,2:33";
        String delimiters = ",:";

        ExpressionHandler expressionHandler = new ExpressionHandler(expression, delimiters, false);
        StringTokenizer tokenizedExpression = expressionHandler.tokenizeExpression();

        TokenCalculator tokenCalculator = new TokenCalculator(tokenizedExpression, delimiters);
        int result = tokenCalculator.getSum();

        assertThat(result).isEqualTo(1 + 2 + 33);
    }

    // input case test
    @Test
    void inputErrorCaseTest1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void inputErrorCaseTest2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3:"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void inputErrorCaseTest3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(","))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void inputErrorCaseTest4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,-2,-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void inputErrorCaseTest5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("///\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void inputWellCaseTest1() {
        assertSimpleTest(() -> {
            run("//.\\n1.2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void inputWellCaseTest2() {
        assertSimpleTest(() -> {
            run("//.\\n1.2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void inputWellCaseTest3() {
        assertSimpleTest(() -> {
            run("//\\\\n1\\2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void inputWellCaseTest4() {
        assertSimpleTest(() -> {
            run("//0\\n102,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
