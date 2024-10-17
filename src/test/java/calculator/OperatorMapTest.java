package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OperatorMapTest {

    @Test
    @DisplayName("OperatoMap에 Separator가 정상적으로 등록되는지 확인")
    void testRegisterSeparatorToOperator() {
        OperatorMap operatorMap = OperatorMap.getInstance();
        Separator separator = new Separator(";");
        OperatorEnum expected = OperatorEnum.PLUS;
        operatorMap.registerSeparatorToOperator(separator, expected);
        OperatorEnum actual = operatorMap.getOperatorBySeparator(separator);

        assertThat(actual).isEqualTo(expected);
    }
}