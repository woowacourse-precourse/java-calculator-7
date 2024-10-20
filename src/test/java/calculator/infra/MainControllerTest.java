package calculator.infra;

import static calculator.common.message.ErrorMessage.CAN_NOT_PARSE;

import calculator.helper.MockIOExtension;
import calculator.helper.MockInput;
import calculator.infra.controller.MainController;
import calculator.model.exception.ParseToIntegerFailedException;
import calculator.service.SeparateService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockIOExtension.class)
public class MainControllerTest {

    private final SeparateService separateService = new SeparateService();
    private final MainController sut = new MainController(separateService);

    @Test
    @DisplayName("컴스텀 구분자 : ^")
    @MockInput("//^\\n6^7^8")
    void mainTestV1() {
        // given & when
        sut.runCalculator();
        // then
        String output = MockIOExtension.getOutput();
        Assertions.assertThat(output).isEqualTo("21");
    }

    @Test
    @DisplayName("[ParseToIntegerFailedException] 컴스텀 구분자로 숫자를 구분하지 않음")
    @MockInput("//^\\n6%7%9")
    void mainTestV2() {
        // given & when & then
        Assertions.assertThatThrownBy(sut::runCalculator)
                .isInstanceOf(ParseToIntegerFailedException.class)
                .hasMessage(CAN_NOT_PARSE);
    }

    @Test
    @DisplayName("컴스텀 구분자 없음")
    @MockInput("1,7,8")
    void mainTestV3() {
        // given & when
        sut.runCalculator();
        // then
        String output = MockIOExtension.getOutput();
        Assertions.assertThat(output).isEqualTo("16");
    }

    @Test
    @DisplayName("어떠한 구분자도 없음")
    @MockInput("123")
    void mainTestV4() {
        // given & when
        sut.runCalculator();
        // then
        String output = MockIOExtension.getOutput();
        Assertions.assertThat(output).isEqualTo("123");
    }
}
