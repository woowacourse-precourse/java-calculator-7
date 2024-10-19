package calculator.model;

import calculator.controller.DelimiterController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("연산부분 테스트")
class ArithmeticTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4","1:2:3:4","1,2:3,4","1:2:3,4"})
    @DisplayName("기본 구분자를 사용해서 연산 부분의 숫자를 낱개로 분리한다")
    void splitCalculatorPartWithDefaultDelimiter(String input) {
        assertThat(new Arithmetic(new DefaultDelimiter(), input).getArithmetic()).isEqualTo(List.of(1,2,3,4));
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1;2;3;4","//.;\\n1.2;3.4","//^?!\\n1^2?3!4"})
    @DisplayName("커스텀 구분자를 사용해서 연산 부분의 숫자를 낱개로 분리한다")
    void splitCalculatorPartWithCustomDelimiter(String input) {
        InputData inputData = new InputData(input);
        assertThat(new Arithmetic
                (new CustomDelimiter(inputData.convertDelimiterPart()), inputData.convertCalculatorPart())
                .getArithmetic()).isEqualTo(List.of(1,2,3,4));
    }
}