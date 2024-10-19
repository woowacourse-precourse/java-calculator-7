package calculator.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class NumberTest extends NsTest {
    @Test
    void 문자열_숫자_변환() {
        Delimiter delimiter = new Delimiter("1:2,3");
        delimiter.checkCustomDelimiter();
        assertSimpleTest(() -> {
            Number number = new Number(delimiter.splitString());
            number.stringToInt();
            assertThat(number.getNumbers()).isEqualTo(new int[]{1, 2, 3});
        });
    }

    @Test
    void 커스텀_구분자_포함_문자열_숫자_변환() {
        Delimiter delimiter = new Delimiter("//*\\n1:2*3");
        delimiter.checkCustomDelimiter();
        assertSimpleTest(() -> {
            Number number = new Number(delimiter.splitString());
            number.stringToInt();
            assertThat(number.getNumbers()).isEqualTo(new int[]{1, 2, 3});
        });
    }

    @Test
    void 숫자_더하기_테스트() {
        Delimiter delimiter = new Delimiter("1:2,3");
        delimiter.checkCustomDelimiter();
        assertSimpleTest(() -> {
            Number number = new Number(delimiter.splitString());
            assertThat(number.addCalculator()).isEqualTo(6);
        });
    }

    @Test
    void 커스텀_구분자_포함_문자열_숫자_더하기_테스트() {
        Delimiter delimiter = new Delimiter("//*\\n1:2*3");
        delimiter.checkCustomDelimiter();
        assertSimpleTest(() -> {
            Number number = new Number(delimiter.splitString());
            assertThat(number.addCalculator()).isEqualTo(6);
        });
    }

    @Test
    void 양수_검증() {
        Delimiter delimiter = new Delimiter("//*\\n1:2*3,4:5");
        delimiter.checkCustomDelimiter();
        assertSimpleTest(() -> {
            Number number = new Number(delimiter.splitString());
            number.stringToInt();
            for (int num : number.getNumbers()) {
                assertThat(num).isGreaterThanOrEqualTo(1);
            }
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
