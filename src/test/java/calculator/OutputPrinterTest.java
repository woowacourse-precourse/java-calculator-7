package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class OutputPrinterTest {

    @Test
    void 출력_테스트() {
        // Given : 계산된 결과값
        int result = 20;

        // 출력값을 보기 위해 System.out을 변경
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // When : OutputPrinter를 사용하여 출력
        OutputPrinter printer = new OutputPrinter();
        printer.printResult(result);

        // Then : 출력값이 "결과 : 20"로 나오면 통과
        assertEquals("결과 : 20", out.toString().trim());

        // 테스트 후 System.out을 원래대로 복구
        System.setOut(System.out);
    }

    @Test
    void 출력_테스트2() {
        // Given : 계산된 결과값
        int result = 15;

        // When : OutputPrinter를 사용하여 출력
        OutputPrinter printer = new OutputPrinter();
        printer.printResult(result);

        // 출력된 값은 콘솔에서 직접 확인
        // 실제 콘솔에 "결과 : 15"이 출력되면 성공
    }
}
