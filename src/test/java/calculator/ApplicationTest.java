package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void 커스텀_구분자_구분_반환1() {
        String input = "//;\\n1,2;3:4";
        String[] expected = {"1", "2", "3", "4"};
        String[] actual = separator.parseNumbers(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    void 커스텀_구분자_구분_반환2() {
        String input = "//?\\n1,2?3:4";
        String[] expected = {"1", "2", "3", "4"};
        String[] actual = separator.parseNumbers(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    void 빈_문자열_입력() {
        String input = "";

        assertThrows(IllegalArgumentException.class, () -> separator.parseNumbers(input));
    }

    @Test
    void 숫자가_아닌_문자() {
        String input = "a,2:c";

        assertThrows(IllegalArgumentException.class, () -> separator.parseNumbers(input));
    }

//    @Test
//    void 가능한_음수() {
//        String input = "-1:2:3";
//        String[] expected = {"-1", "2", "3"};
//        String[] actual = separator.parseNumbers(input);
//        assertArrayEquals(expected, actual);
//    }

    @Test
    void 불가능한_음수() {
        String input = "//-\\n-1:2:3";

        assertThrows(IllegalArgumentException.class, () -> separator.parseNumbers(input));
    }

    @Test
    void 잘못된_커스텀_구분자1() {
        String input = "//--\\n1:2:3";

        assertThrows(IllegalArgumentException.class, () -> separator.parseNumbers(input));
    }

    @Test
    void 잘못된_커스텀_구분자2() {
        String input = "//1\\n2:2:3";

        assertThrows(IllegalArgumentException.class, () -> separator.parseNumbers(input));
    }

    @Test
    void 문자열_공백_체크() {
        String input = " 1:2, 3";

        assertThrows(IllegalArgumentException.class, () -> separator.parseNumbers(input));
    }

    @Test
    void 맨_끝에_구분자1() {
        String input = "1:2:";

        assertThrows(IllegalArgumentException.class, () -> separator.parseNumbers(input));
    }

    @Test
    void 맨_끝에_구분자2() {
        String input = "//;\\n1:2;";

        assertThrows(IllegalArgumentException.class, () -> separator.parseNumbers(input));
    }

    @Test
    void 구분자_연속_두_개() {
        String input = "1::2,3";

        assertThrows(IllegalArgumentException.class, () -> separator.parseNumbers(input));
    }

    @Test
    void 큰_수() {
        assertSimpleTest(() -> {
            run("1236547898745632:1236547898745632");
            assertThat(output()).contains("결과 : 2473095797491264");
        });
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
