package calculator.io.page;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class SimpleTextPageTest extends NsTest {

    @Override
    protected void runMain() {}

    @Test
    void default_constructor_test() {
        // given
        Page<String> page = new SimpleTextPage();
        // when
        // then
        assertSimpleTest(() -> {
            page.render();
            assertThat(output()).isEqualTo("");
        });
    }

    @Test
    void constructor_test() {
        // given
        String content = "test content for SimpleTestPageTest";
        // when
        Page<String> page = new SimpleTextPage(content);
        // then
        assertSimpleTest(() -> {
            page.render();
            assertThat(output()).isEqualTo(content);
        });
    }

    @Test
    void setContent_test() {
        // given
        String defaultContent = "default content for SimpleTestPageTest";
        String newContent = "new content for SimpleTestPageTest";
        // when
        Page<String> page = new SimpleTextPage(defaultContent);
        page.setContent(newContent);
        // then
        assertSimpleTest(() -> {
            page.render();
            assertThat(output()).isEqualTo(newContent);
        });
    }
}
