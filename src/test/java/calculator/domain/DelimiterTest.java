package calculator.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterTest {

    @DisplayName("constructor() : 구분자를 정상적으로 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings = {";", "-", "/"})
    void constructor_delimiter_success(String symbol) throws Exception {
        //given & when & then
        assertThatCode(() -> new Delimiter(symbol))
                .doesNotThrowAnyException();;
    }

}