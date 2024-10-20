package view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputViewTest {


    // 원본 표준 출력 복원을 위해 참조를 저장합니다.
    private final PrintStream systemOut = System.out;

    // 테스트에서 사용될 출력 바이트 스트림
    private ByteArrayOutputStream testOut;

    /**
     * 표준 출력을 캡쳐하기 위해 System.out을 ByteArrayOutputStream로 리다이렉션 합니다.
     */
    @BeforeEach
    void setOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    /**
     * 테스트 실행 후 표준 출력을 복원합니다.
     */
    @AfterEach
    void restoreSystemInputOutput() {
        System.setOut(systemOut);
    }

    /**
     * 예측 출력값을 리턴하는 메서드
     *
     * @param calculatedResult 출력할 계산 결과
     */
    private String expectedOutput(int calculatedResult) {
        return "결과 : " + Integer.toString(calculatedResult);
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
    void 덧셈_결과_12345_출력() {
        int calculatedResult = 12345;
        OutputView outputView = new OutputView();
        outputView.printResult(calculatedResult);
        String expected = expectedOutput(calculatedResult);
        assertEquals(expected, getOutput());
    }

    @Test
    void 덧셈_결과_0을_출력() {
        int calculatedResult = 0;
        OutputView outputView = new OutputView();
        outputView.printResult(calculatedResult);
        String expected = expectedOutput(calculatedResult);
        assertEquals(expected, getOutput());
    }

}
