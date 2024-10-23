package calculator.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    private final InputStream originalSystemIn = System.in;

    @BeforeEach
    void setUp() {
        // 매 테스트 실행 전에 설정할 부분
    }

    @AfterEach
    void tearDown() {
        // 테스트 후 원래의 System.in으로 복구
        System.setIn(originalSystemIn);
    }

    @Test
    void 입력_테스트() {
        String input = "1,2:3";
        // 입력을 모의하기 위해 ByteArrayInputStream 사용
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        InputView inputView = new InputView();
        String result = inputView.getInput();

        assertThat(result).isEqualTo(input);
    }
}
