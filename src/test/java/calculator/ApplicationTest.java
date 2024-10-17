package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    void 커스텀_구분자_사용() {
        String str = "//;\n1;2,3";
        List<Character> separatorList = new ArrayList<>();
        separatorList.add(':');
        separatorList.add(',');
        Application.addSepartor(str, separatorList);
        assertThat(separatorList).containsExactly(':', ',', ';');
    }

    @Test
    void 숫자_추출_테스트() {
        List<Character> separatorList = new ArrayList<>();
        separatorList.add(':');
        separatorList.add(',');

        List<Integer> numbers = Application.extractNumbers("1,2:3", separatorList);
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    void 숫자_합계_테스트() {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);

        long sum = Application.sumNumbers(numberList);
        assertThat(sum).isEqualTo(6);
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
