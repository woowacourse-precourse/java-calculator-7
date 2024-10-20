package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigInteger;
import java.util.List;

import org.junit.jupiter.api.Test;

import calculator.model.Command;
import calculator.model.Number;
import camp.nextstep.edu.missionutils.test.NsTest;

class CommandTest extends NsTest {

    @Test
    void 커스텀_구분자를_포함한_문자열을_명령어로_변환한다() {
        assertSimpleTest(() -> {
            Command command = Command.from("//;\\n1");
            assertThat(command.header()).isEqualTo(";");
            assertThat(command.content()).isEqualTo("1");
        });
    }

    @Test
    void 커스텀_구분자를_포함하지_않은_문자열을_명령어로_변환한다() {
        assertSimpleTest(() -> {
            Command command = Command.from("1,2,3");
            assertThat(command.header()).isEmpty();
            assertThat(command.content()).isEqualTo("1,2,3");
        });
    }

    @Test
    void 커스텀_구분자가_문자열의_앞에_오지_않는_경우_무시한다() {
        assertSimpleTest(() -> {
            Command command = Command.from("1,2,3//;\\n,4");
            assertThat(command.header()).isEmpty();
            assertThat(command.content()).isEqualTo("1,2,3//;\\n,4");
        });
    }

    @Test
    void 커스텀_구분자가_숫자인_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Command.from("//1\\n1,1,3,4"))
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자를_이용해서_숫자를_추출한다() {
        assertSimpleTest(() -> {
            Command command = Command.from("//-\\n1-3-4");
            List<Number> numbers = command.extractNumbers();
            List<Number> expect = List.of(
                new Number(new BigInteger("1")),
                new Number(new BigInteger("3")),
                new Number(new BigInteger("4"))
            );
            assertThat(numbers).isEqualTo(expect);
        });
    }

    @Test
    void 요소중_공백은_0으로_처리한다() {
        assertSimpleTest(() -> {
            Command command = Command.from("//-\\n1-3--4");
            List<Number> numbers = command.extractNumbers();
            List<Number> expect = List.of(
                new Number(new BigInteger("1")),
                new Number(new BigInteger("3")),
                new Number(new BigInteger("0")),
                new Number(new BigInteger("4"))
            );
            assertThat(numbers).isEqualTo(expect);
        });
    }

    @Test
    void 입력이_공백인_경우_0을_출력한다() {
        assertSimpleTest(() -> {
            Command command = Command.from("");
            List<Number> numbers = command.extractNumbers();
            List<Number> expect = List.of(
                new Number(new BigInteger("0"))
            );
            assertThat(numbers).isEqualTo(expect);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
