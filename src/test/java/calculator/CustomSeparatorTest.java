package calculator;

import calculator.separator.CustomSeparator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomSeparatorTest extends NsTest {

    @Test
    public void 커스텀_지정자_지정부분_제거_테스트() {
        String input = "//&\\n23&3&74,03";
        CustomSeparator separator = new CustomSeparator(input);
        String[] strings = separator.splitLine();
        Assertions.assertThat(separator.getLine()).isEqualTo("23&3&74,03");
    }

    @Test
    public void 문자_커스텀_지정자_테스트() {
        // given
        String input = "//&\\n23&3&74,03";

        // when
        CustomSeparator separator = new CustomSeparator(input);
        String[] actual = separator.splitLine();

        // then
        String[] expected = new String[]{"23", "3", "74", "03"};
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 알파벳_커스텀_지정자_테스트() {
        // given
        String input = "//a\\n23a3a74:03";

        // when
        CustomSeparator separator = new CustomSeparator(input);
        String[] actual = separator.splitLine();

        // then
        String[] expected = new String[]{"23", "3", "74", "03"};
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Override
    protected void runMain() {
        // 여기서는 Application의 메인 메서드 실행X
    }
}
