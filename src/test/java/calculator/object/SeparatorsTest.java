package calculator.object;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SeparatorsTest {

    @Test
    void 커스텀구분자푸터를_반환한다() {
        String expectedSeparatorFooter = "\\n";
        assertThat(Separators.getSeparatorFooter()).isEqualTo(expectedSeparatorFooter);
    }

    @Test
    void isCustomSeparatorEmpty로_커스텀구분자가_지정되지않은경우_true_확인할수있다() {
        Separators actual = new Separators("1234");
        assertThat(actual.isCustomSeparatorEmpty()).isTrue();
    }

    @Test
    void isCustomSeparatorEmpty로_커스텀구분자가_지정된경우_false_확인할수있다() {
        Separators actual = new Separators("//*\\n12*34");
        assertThat(actual.isCustomSeparatorEmpty()).isFalse();
    }

    @Test
    void contains로_지정한커스텀구분자를_찾을수있으면_true_확인할수있다() {
        Separators actual = new Separators("//*\\n12*34");
        assertThat(actual.contains('*')).isTrue();
    }

    @Test
    void contains로_지정한커스텀구분자를_찾을수없으면_false_확인할수있다() {
        Separators actual = new Separators("//*\\n1234");
        assertThat(actual.contains('!')).isFalse();
    }

}