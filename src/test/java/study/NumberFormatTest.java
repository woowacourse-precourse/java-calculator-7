package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Locale;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberFormatTest {

    @CsvSource(value = {"1:1", "100:100", "1000:1,000", "1000000:1,000,000"}, delimiter = ':')
    @ParameterizedTest(name = "{0} -> {1}")
    @DisplayName("NumberFormat.getNumberInstance: Locale에 맞는 숫자 포맷팅을 제공")
    void 한국의_숫자_포맷(String before, String after) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);

        assertThat(numberFormat.format(new BigInteger(before))).isEqualTo(after);
    }

}
