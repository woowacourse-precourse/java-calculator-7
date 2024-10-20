package calculator;


import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DelimiterTest extends NsTest {

    @Test
    @DisplayName("커스텀 구분자가 존재하지 않고, ','와 ':'를 제외한 다른 문자열이 있을 경우 예외를 발생시킨다.")
    void DelimiterTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run("1,2'3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 문자가 들어있습니다.")
        );
    }

    @Test
    @DisplayName("구분자로 나눈 문자열이 빈 칸일 경우 0으로 저장한다.")
    void DelimiterBlankTest() {
        assertSimpleTest(() -> {
            run("1,,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
