package view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputViewTest extends NsTest {

    // 원본 표준 입출력 복원을 위해 참조를 저장합니다.
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    // 테스트에서 사용될 입출력 바이트 스트림
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    /**
     * 표준 출력을 캡쳐하기 위한 설정 System.out을 ByteArrayOutputStream로 리다이렉션 합니다.
     */
    @BeforeEach
    void setOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    /**
     * 테스트 실행 후 표준 입출력을 복원합니다.
     */
    @AfterEach
    void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    /**
     * 테스트할 입력 데이터를 제공하는 메서드
     *
     * @param data 테스트할 입력 데이터
     */
    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    /**
     * 캡처된 표준 출력을 반환하는 메서드
     *
     * @return 캡처된 출력 문자열
     */
    private String getOutput() {
        return testOut.toString().trim();
    }

    @Test
    void 쉼표_구분자와_숫자를_입력() {
        provideInput("1,2,3");
        InputView inputView = new InputView();
        String input = inputView.getInput();

        assertTrue(getOutput().contains("덧셈할 문자열을 입력해 주세요."));
        assertThat(input).isEqualTo("1,2,3");
    }

    @Test
    void 커스텀_구분자를_포함된_입력() {
        provideInput("//;\n1;2;3");
        InputView inputView = new InputView();
        String input = inputView.getInput();

        assertTrue(getOutput().contains("덧셈할 문자열을 입력해 주세요."));
        assertThat(input).isEqualTo("//;\n1;2;3");
    }

    @Test
    void 잘못된_형식의_문자열이지만_View에서는_처리하지_않음() {
        provideInput("//;1");
        InputView inputView = new InputView();
        String input = inputView.getInput();

        assertTrue(getOutput().contains("덧셈할 문자열을 입력해 주세요."));
        assertThat(input).isEqualTo("//;1");
    }

    @Test
    void 공백_입력() {
        provideInput(" ");
        InputView inputView = new InputView();
        String input = inputView.getInput();

        assertTrue(getOutput().contains("덧셈할 문자열을 입력해 주세요."));
        assertThat(input).isEqualTo(" ");
    }

    @Test
    void 입력값이_없으면_예외처리() {
        provideInput("");
        InputView inputView = new InputView();

        assertThatThrownBy(inputView::getInput)
                .isInstanceOf(NoSuchElementException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
