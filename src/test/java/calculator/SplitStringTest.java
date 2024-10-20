package calculator;

import calculator.utils.SplitString;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SplitStringTest extends NsTest {
    @Test
    void 디폴트_구분자_분리() {
        String[] result = SplitString.splitInput("1,2,3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 커스텀_구분자_분리() {
        String[] result = SplitString.splitInput("//;\\n1;2;3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 커스텀_구분자_형식_예외_테스트() {
        assertThatThrownBy(() -> SplitString.splitInput("//\\n1;2;3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}