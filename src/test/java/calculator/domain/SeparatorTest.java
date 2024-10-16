package calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class SeparatorTest {
    @Test
    void 문자열_분리_테스트() {
        Separator separator = new Separator("1,2,3:4,5:6");
        assertThat(separator.getElements()).isEqualTo(new String[]{"1", "2", "3", "4", "5", "6"});
    }
}
