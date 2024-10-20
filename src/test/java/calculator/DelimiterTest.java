package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class DelimiterTest extends NsTest {


    @Test
    void 커스텀_구분자에_기본_구분자를_넣으면_오류가_발생한다() {
        assertThatThrownBy(() -> run("//,\n1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자는_공백일_수_없다() {
        assertThatThrownBy(() -> run("// \n1 2 3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자_지정방식을_지켜야_한다() {
        assertThatThrownBy(() -> run("/;\n1;2;3"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> run("//;n1;2;3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 기본_구분자가_아닌_다른_구분자를_사용하면_오류가_발생한다() {
        assertThatThrownBy(() -> run("1@2@3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 선언하지_않은_구분자가_사용되면_오류가_발생한다() {
        assertThatThrownBy(() -> run("//;\n1;2#3"))
                .isInstanceOf(IllegalArgumentException.class);
    }


        @Override
    public void runMain() {
        Application.main(new String[]{});
    }


}
