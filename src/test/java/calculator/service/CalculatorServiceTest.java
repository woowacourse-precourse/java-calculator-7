package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

    @DisplayName("주어진 숫자 리스트의 총합을 계산")
    @Test
    void calculateSum() {
        List<Integer> values = List.of(1, 2, 4, 10);

        CalculatorService service = new CalculatorService();
        int calculateSum = service.calculateSum(values);

        assertThat(calculateSum).isEqualTo(17);
        assertThat(calculateSum).isNotEqualTo(20);
    }

    @DisplayName("올바른 문자열을 숫자로 변환하여 숫자 리스트로 반환")
    @Test
    void convertToNumbers() {
        String[] parts = {"1", "2", "4", "10"};

        CalculatorService service = new CalculatorService();
        List<Integer> values = service.convertToNumbers(parts);

        assertThat(values).containsAll(List.of(1, 2, 4, 10));
        assertThat(values).doesNotContainSequence(List.of(15, 42, 4, 10));
    }

    @DisplayName("빈 문자열 입력 시 0으로 변환")
    @Test
    void convertToNumbersContainsEmpty() {
        String[] parts = {"", "2", "", "10"};
        CalculatorService service = new CalculatorService();
        List<Integer> values = service.convertToNumbers(parts);

        assertThat(values).containsAll(List.of(0, 2, 0, 10));
        assertThat(values).doesNotContainSequence(List.of(2, 10));
    }

    @DisplayName("올바르지 않은 문자열 입력 시 IllegalArgumentException 발생")
    @Test
    void convertToNumbersContainsInvalidStringThrowByIllegalArgumentException() {
        String[] parts = {"1a", "2b", "4", "10"};

        CalculatorService service = new CalculatorService();

        assertThatThrownBy(() -> service.convertToNumbers(parts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 값이 입력되었습니다.");
    }

    @DisplayName("음수가 포함된 문자열 입력 시 IllegalArgumentException 발생")
    @Test
    void convertToNumbersContainsNegativeValueThrowByIllegalArgumentException() {
        String[] parts = {"-1", "20", "4", "10"};

        CalculatorService service = new CalculatorService();

        assertThatThrownBy(() -> service.convertToNumbers(parts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 값이 입력되었습니다.");
    }

    @DisplayName("기본 구분자를 사용한 문자열 분리")
    @Test
    void parseInputDefault() {
        String line1 = "1,2,4:5";
        String line2 = "1:1,2a:4,5";
        String line3 = "1: ,2:4,5";
        CalculatorService service = new CalculatorService();
        String[] paresInput1 = service.paresInput(line1);
        String[] paresInput2 = service.paresInput(line2);
        String[] paresInput3 = service.paresInput(line3);

        assertThat(paresInput1).containsAll(Arrays.asList("1", "2", "4", "5"));
        assertThat(paresInput2).containsAll(Arrays.asList("1", "1", "2a", "4", "5"));
        assertThat(paresInput3).containsAll(Arrays.asList("1", " ", "2", "4", "5"));
    }

    @DisplayName("커스텀 구분자입력시 문자열 분리")
    @Test
    void parseInputCustom() {
        CalculatorService service = new CalculatorService();
        String[] parses1 = service.paresInput("//n\\n1n2");
        String[] parses2 = service.paresInput("//;\\n1;2");
        String[] parses3 = service.paresInput("//;\\n1;2:2");
        String[] parses4 = service.paresInput("//;\\n1; ;2");

        assertThat(parses1).containsAll(Arrays.asList("1", "2"));
        assertThat(parses2).containsAll(Arrays.asList("1", "2"));
        assertThat(parses3).containsAll(Arrays.asList("1", "2:2"));
        assertThat(parses4).containsAll(Arrays.asList("1", " ", "2"));
    }
}