package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputTest extends NsTest {

    @Test
    @DisplayName("input에 띄어쓰기가 들어올 경우")
    void getBlankInputTest() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("띄어쓰기만 입력할 수 없습니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
