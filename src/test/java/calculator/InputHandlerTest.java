package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputHandlerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        // 출력 스트림을 가로채기 위해 System.out 재설정
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        // 테스트가 끝난 후 원래 출력 스트림으로 복원
        System.setOut(originalOut);
    }

    @DisplayName("안내 문구를 출력한다.")
    @Test
    void testWelcomeMessage() {
        // when: 안내 문구 출력
        InputHandler.welcome();

        // then: 출력된 안내 문구 검증
        assertThat(outContent.toString().trim()).contains(InputHandler.welcomeMessage);
    }

    @DisplayName("문자열을 입력 받는다.")
    @Test
    void testInput() {
        // given: 입력 스트림에 입력값 설정
        String input = "123";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when: 입력을 처리
        String result = new InputHandler().getInput();

        // then: 입력된 값이 예상과 일치하는지 검증
        assertThat(result).isEqualTo("123");
    }
}
