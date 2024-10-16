package calculator.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @DisplayName("사용자가 InputView를 통해 입력한 값은 같은 값을 반환한다.")
    @Test
    void getInput(){
        String input = "//;\\n1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String inputValue = InputView.scanString();
        assertThat(inputValue).isEqualTo("//;\\n1");
    }
}
