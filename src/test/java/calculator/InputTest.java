package calculator;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {
    @Test
    public void testInput() {
        // 준비: System.in을 대체할 입력 스트림을 설정
        String testInput = "//;\\n1,2:3";
        InputStream input = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(input);

        // Input 객체 생성
        Input inputObj = new Input();

        // 실행: input 메서드 호출
        String result = inputObj.input();

        // 확인: 결과가 예상한 입력과 일치하는지 검증
        assertEquals("//;\\n1,2:3", result);

        // 원래 System.in 복원
        System.setIn(System.in);
    }
}