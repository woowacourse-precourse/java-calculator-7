package calculator.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CharacterSequenceSeparatorTest {

    @Test
    void 추출테스트() {
        final CharacterSequenceSeparator characterSequenceSeparator = new CharacterSequenceSeparator("test");
        Assertions.assertThat(characterSequenceSeparator.extract("test" + "weqweqwe"))
                .isEqualTo("weqweqwe");
    }

}