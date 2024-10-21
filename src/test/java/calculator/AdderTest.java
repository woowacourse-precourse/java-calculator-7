package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class AdderTest {

    private static final Adder adder = new Adder();

    @Test
    void 구분자_쉼표_테스트() {
        String input = "1,2,3";

        int result = adder.run(input);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void 구분자_콜론_테스트() {
        String input = "1:2:3";

        int result = adder.run(input);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void 구분자_쉼표_콜론_혼합_테스트() {
        String input = "1,2:3";

        int result = adder.run(input);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void 빈_문자열_테스트() {
        String input = "";

        int result = adder.run(input);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void 빈_문자열을_포함한_숫자_테스트() {
        String input = "1,2,";

        int result = adder.run(input);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void 커스텀_구분자_테스트() {
        String input = "//;\\n1;2;3";

        int result = adder.run(input);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자만_있는경우_0을_반환() {
        String input = "//;\\n";

        int result = adder.run(input);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void 음수를_전달하는경우_예외처리() {
        String input = "1,2,-3";

        assertThatThrownBy(() -> adder.run(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 영0을_전달하는경우_예외처리() {
        String input = "1,2,0";

        assertThatThrownBy(() -> adder.run(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자와_구분자_이외의_문자를_전달하는경우_예외처리() {
        String input = "1,2,a";

        assertThatThrownBy(() -> adder.run(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자와_구분자_이외의_문자를_전달하는경우_예외처리2() {
        String input = "//;\n1;2,3";

        assertThatThrownBy(() -> adder.run(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자_시작문자이_없는경우_예외처리() {
        String input = ";\n1;2;3";

        assertThatThrownBy(() -> adder.run(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자_종료문자이_없는경우_예외처리() {
        String input = "//;1;2;3";

        assertThatThrownBy(() -> adder.run(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자가_빈문자열인경우_예외처리() {
        String input = "//\n1,2,3";

        assertThatThrownBy(() -> adder.run(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
