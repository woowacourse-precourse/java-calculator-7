package calculator;

import calculator.separator.CustomSeparator;
import calculator.separator.Separator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomSeparatorTest extends NsTest {

    @Test
    public void 커스텀_지정자_지정부분_제거_테스트() {
        String input = "//&\\n23&3&74,03";
        CustomSeparator separator = new CustomSeparator(input);
        separator.splitLine();
        Assertions.assertThat(separator.getLine()).isEqualTo("23&3&74,03");
    }

    @Test
    public void 문자_커스텀_지정자_테스트() {
        // given
        String input = "//&\\n23&3&74,03";

        // when
        Separator separator = new CustomSeparator(input);
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
        Separator separator = new CustomSeparator(input);
        String[] actual = separator.splitLine();

        // then
        String[] expected = new String[]{"23", "3", "74", "03"};
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 숫자_커스텀_구분자_예외_테스트() {
        // given
        String input = "//4\\n2123534:03";

        // when
        Separator separator = new CustomSeparator(input);

        // then
        assertSimpleTest(() ->
                assertThatThrownBy(separator::splitLine)
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    public void 특수문자_구분자_테스트_큰따옴표() {
        // given
        String input = "//\"\\n21\"534:62,36\"53";

        // when
        Separator separator = new CustomSeparator(input);
        String[] actual = separator.splitLine();

        // then
        String[] expected = new String[]{"21", "534", "62", "36", "53"};
        Assertions.assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void 특수문자_구분자_테스트_백슬래시() {
        // given
        String input = "//\\\\n21\\534:62,36\\53";

        // when
        Separator separator = new CustomSeparator(input);
        String[] actual = separator.splitLine();

        // then
        String[] expected = new String[]{"21", "534", "62", "36", "53"};
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 커스텀_구분자_두글자_예외() {
        // given
        String input = "//ad\\n21,534:62,36";

        // when
        Separator separator = new CustomSeparator(input);

        // then
        assertSimpleTest(() ->
                assertThatThrownBy(separator::splitLine)
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 커스텀_구분자_잘못_지정() {
        // given
        String input = "//\n21,534:62,36";

        // when
        CustomSeparator separator = new CustomSeparator(input);

        // then
        assertSimpleTest(() ->
                assertThatThrownBy(separator::splitLine)
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    public void 빈_문자열_입력() {
        // given
        String input = "//%\\n";

        // when
        Separator separator = new CustomSeparator(input);
        String[] actual = separator.splitLine();

        // then
        Assertions.assertThat(actual).isEqualTo(null);
    }

    @Test
    public void 숫자없이_구분자만_입력() {
        // given
        String input = "//%\\n,:,%:";

        // when
        Separator separator = new CustomSeparator(input);
        String[] actual = separator.splitLine();

        // then
        Assertions.assertThat(actual).isEqualTo(null);
    }

    @Override
    protected void runMain() {
        // 여기서는 Application의 메인 메서드 실행X
    }
}
