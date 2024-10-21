package calculator;

import calculator.Controller.CalculatorController;
import calculator.Controller.InputController;
import calculator.Model.CalculatorModel;
import calculator.View.CalculatorView;
import calculator.vaildator.InputValidator;
import calculator.vaildator.SeparatorHandler;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.*;

class ApplicationTest {

    @Test
    void 유효한_입력을_처리하는_테스트() {
        CalculatorModel model = new CalculatorModel();
        InputController inputController = new InputController();
        CalculatorView view = new CalculatorView() {
            @Override
            public String getInput() {
                return "1,2,3"; // 테스트를 위한 입력
            }

            @Override
            public void showResult(int sum) {
                assertThat(sum).isEqualTo(6); // 결과가 올바른지 확인
            }
        };

        CalculatorController controller = new CalculatorController(model, view, inputController);
        controller.run();
    }

    @Test
    void 빈_입력을_처리하는_테스트() {
        CalculatorModel model = new CalculatorModel();
        InputController inputController = new InputController();
        CalculatorView view = new CalculatorView() {
            @Override
            public String getInput() {
                return ""; // 빈 입력 처리
            }

            @Override
            public void showResult(int sum) {
                assertThat(sum).isEqualTo(0); // 빈 입력일 때 0 반환
            }
        };

        CalculatorController controller = new CalculatorController(model, view, inputController);
        controller.run();
    }

    @Test
    void 커스텀_구분자가_있는_경우_처리_테스트() {
        InputController inputController = new InputController();
        String input = "//.\\n1.2.3";

        String[] result = inputController.processInput(input);

        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 기본_구분자로_입력_처리_테스트() {
        InputController inputController = new InputController();
        String input = "1,2:3";

        String[] result = inputController.processInput(input);

        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 잘못된_구분자_형식을_처리하는_테스트() {
        InputController inputController = new InputController();
        String input = "/;\n1;2;3"; // 잘못된 구분자 형식

        assertThatThrownBy(() -> inputController.processInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자를 정확하게 입력해주세요.");
    }

    @Test
    void 유효한_입력값_검증_테스트() {
        InputValidator inputValidator = new InputValidator();
        String[] inputArr = {"1", "2", "3"};

        inputValidator.validateInputArray(inputArr); // 예외가 발생하지 않음
    }

    @Test
    void 빈값_입력시_예외처리_테스트() {
        InputValidator inputValidator = new InputValidator();
        String[] inputArr = {"", "2", "3"};

        assertThatThrownBy(() -> inputValidator.validateInputArray(inputArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 입력이 제대로 되지 않았습니다.");
    }

    @Test
    void 음수값_입력시_예외처리_테스트() {
        InputValidator inputValidator = new InputValidator();
        String[] inputArr = {"-1", "2", "3"};

        assertThatThrownBy(() -> inputValidator.validateInputArray(inputArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 입력할 수 없습니다.");
    }

    @Test
    void 숫자_0_입력시_예외처리_테스트() {
        InputValidator inputValidator = new InputValidator();
        String[] inputArr = {"0", "2", "3"};

        assertThatThrownBy(() -> inputValidator.validateInputArray(inputArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0은 입력할 수 없습니다.");
    }

    @Test
    void 잘못된_문자가_포함된_입력_처리_테스트() {
        InputValidator inputValidator = new InputValidator();
        String[] inputArr = {"a", "2", "3"};

        assertThatThrownBy(() -> inputValidator.validateInputArray(inputArr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자, 구분자 이외의 문자가 들어왔습니다.");
    }

    @Test
    void 커스텀_구분자_추출_테스트() {
        SeparatorHandler separatorHandler = new SeparatorHandler();
        String input = "//;\\n1;2;3";

        String separator = separatorHandler.getCustomSeparator(input);

        assertThat(separator).isEqualTo(";");
    }

    @Test
    void 잘못된_구분자_형식_처리_테스트() {
        SeparatorHandler separatorHandler = new SeparatorHandler();
        String input = "/;\n1;2;3"; // 잘못된 형식

        assertThatThrownBy(() -> separatorHandler.getCustomSeparator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자를 정확하게 입력해주세요.");
    }

    @Test
    void 커스텀_구분자로_입력_분리_테스트() {
        SeparatorHandler separatorHandler = new SeparatorHandler();
        String separator = "--";
        String input = "1--2--3";

        String[] result = separatorHandler.splitInput(input, separator);

        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 잘못된_구분자_유효성_검증_테스트() {
        SeparatorHandler separatorHandler = new SeparatorHandler();

        assertThatThrownBy(() -> separatorHandler.validateSeparator(","))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("기본 구분자를 커스텀 구분자로 사용할 수 없습니다.");
    }

    @Test
    void 문자열을_정수_배열로_변환하는_테스트() {
        CalculatorModel model = new CalculatorModel();
        String[] inputArr = {"1", "2", "3"};

        int[] result = model.convertToIntArray(inputArr);

        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    void 숫자를_더하는_로직_테스트() {
        CalculatorModel model = new CalculatorModel();
        int[] inputArr = {1, 2, 3};

        int result = model.sum(inputArr);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void 결과_출력_테스트() {
        CalculatorView view = new CalculatorView();

        // 콘솔 출력을 모니터링
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        view.showResult(6);

        assertThat(outContent.toString()).isEqualTo("결과 : 6");
    }

    @Test
    void 오류_메시지_출력_테스트() {
        CalculatorView view = new CalculatorView();

        // 콘솔 출력을 모니터링
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        view.showError("에러 메시지");

        assertThat(outContent.toString().trim()).isEqualTo("오류: 에러 메시지");
    }
}
