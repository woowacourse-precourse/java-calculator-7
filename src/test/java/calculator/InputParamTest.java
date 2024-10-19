package calculator;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputParamTest {

    private InputParam inputParam = InputParam.of();

    @Test
    void 입력_안내_문구_확인() {
        String input = "//;\\n123;12;12";
        List<Integer> expect = List.of(123,12,12);
        CalculatorParamDomain domain = inputParam.getUserNumber(input);
        assertThat(domain.getNumbers()).isEqualTo(expect);
    }

    @Test
    void 숫자가_아닌_영어_입력_에러_확인() {
        String input = "//;\\n12q3;12;12";
        List<Integer> expect = List.of(123,12,12);
        assertThatThrownBy(() -> {
            inputParam.getUserNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주세요.");
    }

    @Test
    void 숫자가_아닌_한글_입력_에러_확인() {
        String input = "//;\\n12가3;12;12";
        List<Integer> expect = List.of(123,12,12);
        assertThatThrownBy(() -> {
            inputParam.getUserNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주세요.");
    }
}