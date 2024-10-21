package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
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
    @CsvSource({"',', ':', ';'"})
    void constructor_delimiterManager_success(
              String symbolComma
            , String symbolColon
            , String symbolSemiColon) throws Exception {
        //given & when & then
        assertThatCode(() -> createDelimiterManager(symbolComma, symbolColon, symbolSemiColon))
                .doesNotThrowAnyException();
    }

    @DisplayName("uniqueDelimiters() : 구분자들은 고유한 값을 가진다.")
    @ParameterizedTest
    @CsvSource({"',',:,:", "',',;,;"})
    void uniqueDelimiters_delimiterManager_success(
            String symbolComma
            , String duplicationSymbol1
            , String duplicationSymbol2) throws Exception {
        //given
        DelimiterManager delimiterManager = createDelimiterManager(symbolComma, duplicationSymbol1, duplicationSymbol2);
        System.out.println(delimiterManager.getDelimiters().size());;
        // when
        List<Delimiter> uniqueDelimiters = delimiterManager.getDelimiters();
        System.out.println(uniqueDelimiters.size());

        // then
        assertThat(uniqueDelimiters)
                .hasSize(2)
                .extracting(Delimiter::getSymbol)
                .containsExactlyInAnyOrder(symbolComma, duplicationSymbol1);
    }

    private static DelimiterManager createDelimiterManager(String symbol1, String symbol2, String symbol3) {
        return new DelimiterManager(List.of(new Delimiter(symbol1)
                , new Delimiter(symbol2)
                , new Delimiter(symbol3)));
    }
}