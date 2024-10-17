package calculator.controller;

import calculator.model.InputData;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 계산기 작동 테스트")
class StringCalculatorControllerTest extends NsTest{
    private StringCalculatorController stringCalculatorController;

    @BeforeEach
    void setUp() {
        stringCalculatorController = new StringCalculatorController();
    }

    @Test
    @DisplayName("사용자의 입력을 받아 데이터 객체를 생성한다")
    void createInputDataInstance(){
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(stringCalculatorController.handoverInput())
                    .isInstanceOf(InputData.class);
        });
    }

    @Override
    protected void runMain() {

    }
}