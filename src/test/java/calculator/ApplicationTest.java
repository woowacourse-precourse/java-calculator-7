package calculator;

import calculator.model.ExpressionHandler;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.StringTokenizer;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void getCustomDelimiterTest(){
        assertSimpleTest(() -> {
           run("//;\\n");
           assertThat(output()).contains(";");
        });
    }

    @Test
    void filterExpressionTest1(){
        ExpressionHandler expressionHandler = new ExpressionHandler();
        String filtered = expressionHandler.filterExpression("//;\\n1,2,", true);
        assertThat(filtered).contains("1,2,");
    }
    @Test
    void filterExpressionTest2(){
        ExpressionHandler expressionHandler = new ExpressionHandler();
        String filtered = expressionHandler.filterExpression("/;\\n1,2,", false);
        assertThat(filtered).contains("/;\\n1,2,");
    }

    @Test
    void tokenizeExpressionTest(){
        String expression = "//;\\n1,2:33";
        ExpressionHandler expressionHandler = new ExpressionHandler();
        expression = expressionHandler.filterExpression(expression, true);

        StringTokenizer tokenizedExpression = expressionHandler.tokenizeExpression(expression);
        String[] expectedTokens = {"1", "2", "33"};

        int index = 0;
        while (tokenizedExpression.hasMoreTokens()) {
            String token = tokenizedExpression.nextToken();
            assertThat(token).isEqualTo(expectedTokens[index++]);
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
