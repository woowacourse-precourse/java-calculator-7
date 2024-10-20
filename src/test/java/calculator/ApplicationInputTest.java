package calculator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class ApplicationInputTest {

    @Test
    void 입력_테스트() {
        // Given: 가상 입력과 가상 출력을 설정
        String simulatedInput = "1,2,3\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // When: 애플리케이션 실행
        Application app = new Application();
        app.run();

        // Then: 출력된 값을 검증
        String output = out.toString();
        assertTrue(output.contains("입력된 값: 1,2,3"));
    }
}
