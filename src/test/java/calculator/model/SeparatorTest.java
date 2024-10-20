package calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SeparatorTest {

    private Separator separator;

    @BeforeEach
    public void setUp() {
        separator = new Separator();
    }

    @Test
    @DisplayName("허용된 구분자 테스트")
    public void allowedSeparatorTest() {
        // given
        String inputString1 = "1:2";
        String inputString2 = "1,2";
        String inputString3 = "1:2:3";
        String inputString4 = "1,2,3";
        String inputString5 = "1,2:3";
        // when
        String separator1 = separator.getSeparator(inputString1);
        String separator2 = separator.getSeparator(inputString2);
        String separator3 = separator.getSeparator(inputString3);
        String separator4 = separator.getSeparator(inputString4);
        String separator5 = separator.getSeparator(inputString5);
        // then
        assertThat(separator1).isEqualTo("[:|,]");
        assertThat(separator2).isEqualTo("[:|,]");
        assertThat(separator3).isEqualTo("[:|,]");
        assertThat(separator4).isEqualTo("[:|,]");
        assertThat(separator5).isEqualTo("[:|,]");
    }

    @Test
    @DisplayName("커스텀 구분자 테스트")
    public void customSeparatorTest() {
        // given
        String inputString1 = "//;\\n1";
        String inputString2 = "//?\\n1";
        String inputString3 = "//.\\n1.2";
        String inputString4 = "//;\\n1;2;3";
        String inputString5 = "//b\\n10;23;4";
        // when
        String separator1 = separator.getSeparator(inputString1);
        String separator2 = separator.getSeparator(inputString2);
        String separator3 = separator.getSeparator(inputString3);
        String separator4 = separator.getSeparator(inputString4);
        String separator5 = separator.getSeparator(inputString5);
        // then
        assertThat(separator1).isEqualTo(";");
        assertThat(separator2).isEqualTo("?");
        assertThat(separator3).isEqualTo(".");
        assertThat(separator4).isEqualTo(";");
        assertThat(separator5).isEqualTo("b");
    }
}
