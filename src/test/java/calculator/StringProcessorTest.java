package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.Model.StringProcessor;
import org.junit.jupiter.api.Test;

public class StringProcessorTest {
    @Test
    void 기본_구분자_추출() {
        assertSimpleTest(() -> {
            StringProcessor processor = new StringProcessor("1,2:3");
            assertThat(processor.getSeparator()).isEqualTo(",|:");
        });
    }

    @Test
    void 커스텀_구분자_추출() {
        assertSimpleTest(() -> {
            StringProcessor processor = new StringProcessor("//+\n1+2+3");
            assertThat(processor.getSeparator()).isEqualTo("+");
        });
    }

    @Test
    void 커스텀_구분자_추출_예외_1() {
        assertThatThrownBy(() -> {
            StringProcessor processor = new StringProcessor("//1+2+3");
            processor.getSeparator();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자가 올바르게 정의되지 않았습니다.");
    }

    @Test
    void 커스텀_구분자_추출_예외_2() {
        assertThatThrownBy(() -> {
            StringProcessor processor = new StringProcessor("1+\n2+3");
            processor.getSeparator();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자가 올바르게 정의되지 않았습니다.");
    }
}
