package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import calculator.service.CalculatorService;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculateServiceTest extends NsTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "1,1,1,1,1,1,", "1:1:1:3:"})
    void 구분자_추출후_계산_테스트(String text) {
        assertSimpleTest(() -> {
            Map<String, String> inputData = new HashMap<>();
            inputData.put("calculateString", text);
            inputData.put("customDelimiter", null);

            assertThat(CalculatorService.extractAndCalculate(inputData)).isEqualTo(6);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2:2;1", "1,1;1,1;1,1,", "1:1:1;3:"})
    void 구분자_추출후_계산_with_커스텀_구분자_테스트(String text) {
        assertSimpleTest(() -> {
            Map<String, String> inputData = new HashMap<>();
            inputData.put("calculateString", text);
            inputData.put("customDelimiter", ";");

            assertThat(CalculatorService.extractAndCalculate(inputData)).isEqualTo(6);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
