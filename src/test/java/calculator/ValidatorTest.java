package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    private CalculatorParamDomain domain;
    private Validator validator;
    private InputParam inputParam;

    @BeforeEach
    void 테스트_전_세팅() {
        this.domain = CalculatorParamDomain.of();
        this.validator = Validator.of();
        this.inputParam = InputParam.of();
    }

    @Test
    void 구분자_검증_확인() {
        String 구분자 = "//; \n1;2;3\n";

        List<Character> result = List.of(';',' ');

        List<String> inputDataList = inputParam.splitInputString(구분자);

        if(validator.validDelimiters(구분자)) {
            domain.changeUserDelimiters(inputParam.findDelimiters(inputDataList));
            assertThat(domain.getDelimiters()).isEqualTo(result);
        }
    }

    @Test
    void 입력값_검증() {
        String input = "1,2:3\n";

        List<Integer> expected = List.of(1, 2, 3);

        List<String> inputDataList = inputParam.splitInputString(input);
        domain.splitStringNumbers(inputDataList);

        if(validator.validDelimiters(input)) {
            domain.changeUserDelimiters(inputParam.findDelimiters(inputDataList));
        }

        domain = inputParam.findNumbers(domain);
        assertThat(domain.getNumbers()).isEqualTo(expected);
    }
}