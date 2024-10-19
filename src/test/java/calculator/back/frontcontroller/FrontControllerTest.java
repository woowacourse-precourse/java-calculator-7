package calculator.back.frontcontroller;

import calculator.back.controller.CalculatorController;
import calculator.back.resolver.ArgumentResolver;
import calculator.back.service.impl.CalculatorServiceImpl;
import calculator.front.enums.ViewMessage;
import calculator.front.view.InputView;
import calculator.front.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
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
        Console.close();
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

    @ParameterizedTest
    @MethodSource("emptyInput")
    @DisplayName("빈 문자열에 대해 0을 반환")
    void 어플리케이션_통합_테스트3(ByteArrayInputStream in) {
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

    @ParameterizedTest
    @MethodSource("dummyInput")
    @DisplayName("더미 입력에 대한 예외 반환")
    void 어플리케이션_통합_테스트4(ByteArrayInputStream in) {
        //given
        // Scanner의 nextLine()에 입력할 값
        System.setIn(in);

        //when
        //then
        assertThatThrownBy(frontController::run).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("delimitedNegativeNumbers")
    @DisplayName("음수 입력에 대한 예외 반환")
    void 어플리케이션_통합_테스트5(ByteArrayInputStream in) {
        //given
        // Scanner의 nextLine()에 입력할 값
        System.setIn(in);

        //when
        //then
        assertThatThrownBy(frontController::run).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("delimitedZeroNumbers")
    @DisplayName("0이 포함된 입력에 대한 예외 반환")
    void 어플리케이션_통합_테스트6(ByteArrayInputStream in) {
        //given
        // Scanner의 nextLine()에 입력할 값
        System.setIn(in);

        //when
        //then
        assertThatThrownBy(frontController::run).isInstanceOf(IllegalArgumentException.class);
    }

    private static final List<String> inputs = List.of("//|\\n1|2:3", "//|\\n", "\n", "asdasd12as", "-1,2,3", "0,1,2");

    static Stream<ByteArrayInputStream> validTestInput() {
        return Stream.of(new ByteArrayInputStream(inputs.get(0).getBytes()));
    }

    static Stream<ByteArrayInputStream> noDelimitedNumbers() {
        return Stream.of(new ByteArrayInputStream(inputs.get(1).getBytes()));
    }

    static Stream<ByteArrayInputStream> emptyInput() {
        return Stream.of(new ByteArrayInputStream(inputs.get(2).getBytes()));
    }

    static Stream<ByteArrayInputStream> dummyInput() {
        return Stream.of(new ByteArrayInputStream(inputs.get(3).getBytes()));
    }

    static Stream<ByteArrayInputStream> delimitedNegativeNumbers() {
        return Stream.of(new ByteArrayInputStream(inputs.get(4).getBytes()));
    }

    static Stream<ByteArrayInputStream> delimitedZeroNumbers() {
        return Stream.of(new ByteArrayInputStream(inputs.get(5).getBytes()));
    }

}