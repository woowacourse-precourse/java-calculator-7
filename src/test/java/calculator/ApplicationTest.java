package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
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

    @Test
    void checkCustomDelimiterTest() {
        //when
        String input = "//.\n";
        int beforeCount = calculator.delimiters.size();

        //given
        calculator.checkCustomDelimiter(input);
        int afterCount = calculator.delimiters.size();

        //then
        assertThat(afterCount).isEqualTo(beforeCount + 1);

    }

    @Test
    void splitNumbersTest() {
        //when
        String input = "//;\n1;2;3";
        String[] expected = {"1", "2", "3"};

        //given
        String[] actual = calculator.splitNumbers(input);

        //then
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void sumNumbersTest() {
        //when
        String[] input = {"1", "2", "3"};
        int inputSum = Arrays.stream(input)
                .mapToInt(Integer::parseInt)  // 문자열을 정수로 변환
                .sum();

        //given
        int actual = calculator.sumNumbers(input);

        //then
        assertThat(actual).isEqualTo(inputSum);

    }
}
