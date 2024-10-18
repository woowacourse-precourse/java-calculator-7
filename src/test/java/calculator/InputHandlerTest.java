package calculator;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputHandlerTest extends NsTest {

    @DisplayName("안내 문구를 출력한다.")
    @Test
    void testWelcomeMessage() {
        // when
        InputHandler.welcome();

        // then: 출력을 캡처하여 확인
        assertThat(output()).contains(InputHandler.welcomeMessage);
    }

    @DisplayName("문자열을 입력 받는다.")
    @Test
    void testInput() {
        // given: 콘솔에 입력값을 설정
        run("123");

        // then: 입력에 따른 결과 검증
        assertThat(output()).contains("결과 : 123");
    }

    @Override
    protected void runMain() {
        // InputHandler의 메인 로직을 호출
        // 예를 들어 InputHandler의 welcome() 메서드와 input 처리 로직을 호출한다.
        InputHandler.welcome();
        String input = Console.readLine();  // Console.readLine()은 가짜 입력을 받음
        System.out.println("결과 : " + input);
    }
}
