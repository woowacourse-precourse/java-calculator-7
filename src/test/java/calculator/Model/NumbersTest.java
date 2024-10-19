package calculator.Model;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest extends NsTest {

    @Test
    @DisplayName("불가능한 Numbers 객체를 확인합니다.")
    void numbers_테스트() {
        List<Number> input = new ArrayList<>();
        Assertions.assertThatThrownBy(() -> new Numbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
