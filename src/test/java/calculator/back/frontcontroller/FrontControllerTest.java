package calculator.back.frontcontroller;

import calculator.back.controller.CalculatorController;
import calculator.back.resolver.ArgumentResolver;
import calculator.back.service.impl.CalculatorServiceImpl;
import calculator.front.enums.ViewMessage;
import calculator.front.view.InputView;
import calculator.front.view.OutputView;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

class FrontControllerTest {

    private final FrontController frontController = new FrontController(new InputView(), new OutputView(),
            new ArgumentResolver(), new CalculatorController(new CalculatorServiceImpl()));

    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    private static final String message =
            ViewMessage.INPUT_MESSAGE.getMessage() + ViewMessage.OUTPUT_MESSAGE.getMessage();

    @BeforeEach
    void setUp() {
        // sout을 가로 채기 위함
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @ParameterizedTest
    @MethodSource("validTestInput")
    @DisplayName("사용자 입력값에 대한 계산된 값을 반환하는 통합 테스트")
    void 어플리케이션_통합_테스트1(ByteArrayInputStream in) {
        //given
        // Scanner의 nextLine()에 입력할 값
        System.setIn(in);
        // 예상 값
        String expectedValue = "6";

        //when
        frontController.run();

        //then
        assertThat(byteArrayOutputStream.toString().replaceAll("\\s+", "")).isEqualTo(
                (message + expectedValue).replaceAll("\\s+", ""));
    }

    @ParameterizedTest
    @MethodSource("noDelimitedNumbers")
    @DisplayName("커스텀구분자는 존재하지면 구분된숫자가 존재하지 않을 때 0을 반환")
    void 어플리케이션_통합_테스트2(ByteArrayInputStream in) {
        //given
        // Scanner의 nextLine()에 입력할 값
        System.setIn(in);
        // 예상 값
        String expectedValue = "0";

        //when
        frontController.run();

        //then
        assertThat(byteArrayOutputStream.toString().replaceAll("\\s+", "")).isEqualTo(
                (message + expectedValue).replaceAll("\\s+", ""));
    }

    private static List<String> inputs = List.of("//|\\n1|2:3", "//|\\n");

    static Stream<ByteArrayInputStream> validTestInput() {
        return Stream.of(new ByteArrayInputStream(inputs.get(0).getBytes()));
    }

    static Stream<ByteArrayInputStream> noDelimitedNumbers() {
        return Stream.of(new ByteArrayInputStream(inputs.get(1).getBytes()));
    }

}