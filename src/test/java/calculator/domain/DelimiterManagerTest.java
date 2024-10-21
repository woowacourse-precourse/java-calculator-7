package calculator.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterManagerTest {

    @DisplayName("constructor() : 생성된 구분자들을 관리할 수 있다.")
    @ParameterizedTest
    @CsvSource({",,:,;"})
    void constructor_delimiterManager_success(
              String symbolComma
            , String symbolColon
            , String symbolSemiColon) throws Exception {
        //given & when & then
        assertThatCode(() -> createDelimiterManager(symbolComma, symbolColon, symbolSemiColon))
                .doesNotThrowAnyException();
    }


    private static DelimiterManager createDelimiterManager(String symbol1, String symbol2, String symbol3) {
        return new DelimiterManager(List.of(new Delimiter(symbol1)
                , new Delimiter(symbol2)
                , new Delimiter(symbol3)));
    }
}