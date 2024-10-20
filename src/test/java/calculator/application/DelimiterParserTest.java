package calculator.application;

import calculator.util.RandomSupport;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;

class DelimiterParserTest extends RandomSupport {
    private static final DelimiterParser DELIMITER_PARSER;

    static {
        DELIMITER_PARSER = new DelimiterParser(new DelimiterValidator());
    }

    @Nested
    class 커스텀_구분자가_없는_문자열 {
        private String value;
        private DelimiterList expectedDelimiterList;
        private String expectedParsed;

        @BeforeEach
        void set() {
            this.value = "1,2:3";
            this.expectedDelimiterList = DelimiterList.from(new HashSet<>(Set.of(
                Delimiter.from(":"),
                Delimiter.from(",")
            )));
            this.expectedParsed = this.value;
        }

        @Test
        void 파싱에_성공할_것이다() {
            assertAll(
                () -> Assertions.assertThat(DELIMITER_PARSER.parseToDelimiterList(this.value)).isEqualTo(this.expectedDelimiterList),
                () -> Assertions.assertThat(DELIMITER_PARSER.getParsed()).isEqualTo(this.expectedParsed)
            );
        }
    }

    @Nested
    class 커스텀_구분자가_있는_문자열 {

        private String value;
        private DelimiterList expectedDelimiterList;
        private String expectedParsed;

        @BeforeEach
        void set() {
            this.value = "//'\\n1,2,3";
            this.expectedDelimiterList = DelimiterList.from(new HashSet<>(Set.of(
                Delimiter.from(":"),
                Delimiter.from(","),
                Delimiter.from("'")
            )));
            this.expectedParsed = "1,2,3";
        }

        @Test
        void 파싱에_성공할_것이다() {
            assertAll(
                () -> Assertions.assertThat(DELIMITER_PARSER.parseToDelimiterList(this.value)).isEqualTo(this.expectedDelimiterList),
                () -> Assertions.assertThat(DELIMITER_PARSER.getParsed()).isEqualTo(this.expectedParsed)
            );
        }
    }
}