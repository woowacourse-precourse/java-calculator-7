package calculator.operator;

import calculator.arithmeticUnit.ArithmeticOperation;
import calculator.arithmeticUnit.PlusOperation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OperatorMapTest {
    @Test
    @DisplayName("OperatoMap에 Separator가 정상적으로 등록되는지 확인")
    void testRegisterSeparatorToOperator() {
        OperatorMap operatorMap = OperatorMap.getInstance();
        Separator separator = new Separator(";");
        ArithmeticOperation expected = PlusOperation.getInstance();
        operatorMap.registerSeparatorToOperator(separator, expected);
        ArithmeticOperation actual = operatorMap.getOperatorBySeparator(separator);

        assertThat(actual).isEqualTo(expected);
    }
}