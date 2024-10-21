package calculator.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class DelimiterTest extends NsTest {
    @Test
    void 커스텀_구분자_인식_테스트() {
        assertSimpleTest(() -> {
            Delimiter delimiter = new Delimiter("//;\\n");
            delimiter.getSplitString();
            assertThat(delimiter.getCustomDelimiter()).isEqualTo(";");
        });

        assertSimpleTest(() -> {
            Delimiter delimiter = new Delimiter("///\\n");
            delimiter.getSplitString();
            assertThat(delimiter.getCustomDelimiter()).isEqualTo("/");
        });

        assertSimpleTest(() -> {
            Delimiter delimiter = new Delimiter("//=\\n");
            delimiter.getSplitString();
            assertThat(delimiter.getCustomDelimiter()).isEqualTo("=");
        });

        assertSimpleTest(() -> {
            Delimiter delimiter = new Delimiter("//)\\n");
            delimiter.getSplitString();
            assertThat(delimiter.getCustomDelimiter()).isEqualTo(")");
        });
    }

    @Test
    void 공백_입력_테스트() {
        assertSimpleTest(() -> {
            Delimiter delimiter = new Delimiter("");
            assertThat(delimiter.getSplitString()).isNull();
        });

        assertSimpleTest(() -> {
            Delimiter delimiter = new Delimiter("//;\\n");
            assertThat(delimiter.getSplitString()).isNull();
        });
    }

    @Test
    void 문자열_분리_테스트() {
        assertSimpleTest(() -> {
            Delimiter delimiter = new Delimiter("//;\\n1;2,3:4");
            assertThat(delimiter.getSplitString()).isEqualTo(new String[]{"1", "2", "3", "4"});
        });

        assertSimpleTest(() -> {
            Delimiter delimiter = new Delimiter("1,2:3");
            assertThat(delimiter.getSplitString()).isEqualTo(new String[]{"1", "2", "3"});
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
