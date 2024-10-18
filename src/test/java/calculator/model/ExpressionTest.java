package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpressionTest{

    @Test
    void 계산식_생성() {
        String input = "1,2,3";
        Expression newExpression = new Expression(input);

        // 생성자 동작하는 지 테스트
        Assertions.assertThat(newExpression).isNotNull();
    }
}
