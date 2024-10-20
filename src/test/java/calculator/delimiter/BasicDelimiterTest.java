package calculator.delimiter;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BasicDelimiterTest {

    @Test
    void 기본_구분자_반환() {
        //when
        Set<String> basicDelimiters = BasicDelimiter.getBasicDelimiters();

        //when
        assertThat(basicDelimiters).contains(",", ":");
    }

}