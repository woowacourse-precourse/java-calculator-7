package calculator.io.page;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import calculator.io.read.Reader;
import calculator.io.read.SingleLineReader;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class SimpleTextReaderPageTest extends NsTest {

    @Override
    protected void runMain() {}

    @Test
    void read_and_getOutput_test() {
        // given
        String content = "덧셈할 문자열을 입력해주세요.\n";
        Reader<String> reader = new SingleLineReader();
        ReaderPage<String, String> page = new SimpleTextReaderPage(content, reader);
        // when
        // then
        assertThat(content).isEqualTo(page.getContent());
        assertThat(reader).isEqualTo(page.getReader());
        assertSimpleTest(() -> {
            String input = "input 문자열";
            run(input + "\n");
            page.render();
            String output = page.getOutput();
            assertThat(content + output).isEqualTo(content + input);
        });
    }

}
