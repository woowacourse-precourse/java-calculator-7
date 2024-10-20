package calculator.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사용자의 입력을 계산하는 비즈니스 로직에 대한 테스트")
class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    public void 커스텀_구분자_미사용시_정상_호출() {
        // given
        Map<String, String> inputAndResults = new HashMap<>();
        inputAndResults.put("1,2,3:4,,5::6", "21");
        inputAndResults.put("1,2,3", "6");
        inputAndResults.put("92475293847592734598234579235325:3124349872313549723498579127349"
                , "95599643719906284321733158362674");
        inputAndResults.put("1:23,", "24");
        inputAndResults.put("//\\n1:23,", "24");

        // when, then
        inputAndResults.forEach((rawInput, expected) -> {
            // when
            String actual = calculatorService.calculate(rawInput);

            // then
            Assertions.assertThat(actual).isEqualTo(expected);
        });
    }

    @Test
    public void 단일_커스텀_구분자_사용시_정상_호출() {
        // given
        Map<String, String> inputAndResults = new HashMap<>();
        inputAndResults.put("//@\\n1,2@3:4,,5::6", "21");
        inputAndResults.put("///\\n6/6,3", "15");
        inputAndResults.put("//|\\n92475293847592734598234579235325|3124349872313549723498579127349"
                , "95599643719906284321733158362674");
        inputAndResults.put("//\"\\n1:2\"3,", "6");

        // when, then
        inputAndResults.forEach((rawInput, expected) -> {
            // when
            String actual = calculatorService.calculate(rawInput);

            // then
            Assertions.assertThat(actual).isEqualTo(expected);
        });
    }

    @Test
    public void 빈문자열_입력시_정상_호출() {
        // given
        String rawInput = "";

        // when
        String actual = calculatorService.calculate(rawInput);

        // then
        Assertions.assertThat(actual).isEqualTo("0");
    }

    @Test
    public void 커스텀_구분자_중복시_예외_발생() {
        // given
        List<String> inputs = new ArrayList<>();
        inputs.add("//,\\n1,2,3");
        inputs.add("////\\n6/6,3");
        inputs.add("//|#|\\n92475293847592734598234579235325|3124349872313549723498579127349");
        inputs.add("//\":\\n1:2\"3,");

        // when, then
        inputs.forEach((rawInput) -> {
            Assertions.assertThatThrownBy(() -> {
                calculatorService.calculate(rawInput);
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    public void 잘못된_커스텀_구분자_사용시_예외_발생() {
        // given
        List<String> inputs = new ArrayList<>();
        inputs.add("//1\\n1,2,3");
        inputs.add("//|0#\\n6/6,3");
        inputs.add("//0\\n92475293847592734598234579235325|3124349872313549723498579127349");
        inputs.add("//1234\":\\n1:2\"3,");

        // when, then
        inputs.forEach((rawInput) -> {
            Assertions.assertThatThrownBy(() -> {
                calculatorService.calculate(rawInput);
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    public void 잘못된_숫자형식_입력시_예외_발생() {
        // given
        List<String> inputs = new ArrayList<>();
        inputs.add("1.1241,2.4324.3,3");
        inputs.add("-1,324:213");
        inputs.add("-132414.3124,31341");
        inputs.add("12.31.34");

        // when, then
        inputs.forEach((rawInput) -> {
            Assertions.assertThatThrownBy(() -> {
                calculatorService.calculate(rawInput);
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }
}