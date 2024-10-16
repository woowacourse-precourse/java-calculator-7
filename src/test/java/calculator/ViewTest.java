package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ViewTest {

    @Test
    @DisplayName("문자열을 입력받습니다.")
    void input() {
        // given
        String inputValue = "1:1:2\n";
        ByteArrayInputStream in = new ByteArrayInputStream(inputValue.getBytes());
        System.setIn(in);

        // when
        View view = new View();
        String inputResult = view.input();

        // then
        Assertions.assertEquals("1:1:2", inputResult);
    }

}