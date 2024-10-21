package calculator.study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class AssertJStudyTest {

    @Test
    public void containsExactlyInAnyOrder() {
        assertThat(List.of("1", "1", "2")).containsExactlyInAnyOrder("2", "1", "1");
    }
}
