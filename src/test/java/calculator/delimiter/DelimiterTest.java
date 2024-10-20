package calculator.delimiter;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class DelimiterTest {
    @Test
    void addCustomDelimiter_validInput() {
        assertSimpleTest(() -> {
            Delimiter delimiter = new Delimiter();
            String input = "//;\\n1;2;3";

            String result = delimiter.addCustomDelimiter(input);
            assertThat(result).isEqualTo("1;2;3");
            assertThat(delimiter.getDel()).isEqualTo("[,:;]");
        });
    }

    @Test
    void addCustomDelimiter_validInputWithLength5() {
        assertSimpleTest(() -> {
            Delimiter delimiter = new Delimiter();
            String input = "//;\\n";

            String result = delimiter.addCustomDelimiter(input);
            assertThat(result).isEqualTo("");
            assertThat(delimiter.getDel()).isEqualTo("[,:;]");
        });
    }

    @Test
    void addCustomDelimiter_shortInput() {
        assertSimpleTest(() -> {
            Delimiter delimiter = new Delimiter();
            String input = "//;";

            assertThatThrownBy(() -> delimiter.addCustomDelimiter(input))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void addCustomDelimiter_InvalidCustomDelHeader() {
        assertSimpleTest(() -> {
            Delimiter delimiter = new Delimiter();
            String input = "//;;;";

            assertThatThrownBy(() -> delimiter.addCustomDelimiter(input))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void addCustomDelimiter_defaultDelimiter() {
        assertSimpleTest(() -> {
            Delimiter delimiter = new Delimiter();
            String input = "//:\\n";

            assertThatThrownBy(() -> delimiter.addCustomDelimiter(input))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }


}