package calculator.controller;

import calculator.model.CustomDelimiter;
import calculator.model.DefaultDelimiter;
import calculator.model.InputData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("구분자 작동 테스트")
class DelimiterControllerTest {
    private DelimiterController delimiterController;

    @BeforeEach
    void setUp() {
        delimiterController = new DelimiterController();
    }

    @Test
    @DisplayName("커스텀 구분자가 있는 데이터 객체를 받아 커스텀 구분자 객체를 생성한다")
    void createCustomDelimiterInstance() {
        InputData inputData = new InputData("//;\\n1;2;3");
        assertThat(delimiterController.createDelimiterPart(inputData))
                .isInstanceOf(CustomDelimiter.class);
    }

    @Test
    @DisplayName("커스텀 구분자가 없는 데이터 객체를 받아 기본 구분자 객체를 생성한다")
    void createDefaultDelimiterInstance() {
        InputData inputData = new InputData("1,2,3");
        assertThat(delimiterController.createDelimiterPart(inputData))
                .isInstanceOf(DefaultDelimiter.class);
    }

}