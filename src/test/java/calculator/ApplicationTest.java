package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ApplicationTest extends NsTest {
    private StringSeparator separator;

    @BeforeEach
    public void setUp() {
        separator = new StringSeparator();
    }

    @Test
    void 기본_구분자_구분_반환() {
        String input = "1,2:3";
        String[] expected = {"1", "2", "3"};
        String[] actual = separator.parseNumbers(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    void 커스텀_구분자_구분_반환2() {
        String input = "//;\\n1,2;3:4";
        String[] expected = {"1", "2", "3", "4"};
        String[] actual = separator.parseNumbers(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
