package calculator.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import calculator.model.InputData;
import calculator.model.SumCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("문자열 계산기 작동 테스트")
class StringCalculatorControllerTest extends NsTest {
    private StringCalculatorController stringCalculatorController;

    @BeforeEach
    void setUp() {
        stringCalculatorController = new StringCalculatorController.Builder()
                .withInputView(new InputView())
                .withOutputView(new OutputView())
                .withDelimiterController(new DelimiterController())
                .withSumCalculator(new SumCalculator())
                .build();
    }

    @ParameterizedTest(name = "{1}")
    @CsvSource({"'1,2,3' , '기본 구분자'", "'//;\\n1;2;3', '커스텀구분자'"})
    @DisplayName("사용자의 입력을 받아 데이터 객체를 생성한다")
    void createInputDataInstance(String input, String testCase) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(stringCalculatorController.handoverInput())
                    .isInstanceOf(InputData.class);
        });
    }

    @Override
    protected void runMain() {

    }
}