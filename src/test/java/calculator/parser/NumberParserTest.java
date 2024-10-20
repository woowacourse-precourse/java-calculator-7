package calculator.parser;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

public class NumberParserTest {

  private final NumberParser numberParser = new BasicNumberParser();

  @Test
  public void 정수_Long_파싱(){
    String token = "12345";
    Number number = numberParser.parseNumber(token);

    assertThat(number).isInstanceOf(Long.class);
    assertThat(number).isEqualTo(12345L);
  }

  @Test
  public void 정수_BigInteger_파싱() {
    String input = "12345678901234567890";
    Number result = numberParser.parseNumber(input);

    assertThat(result).isInstanceOf(BigInteger.class);
    assertThat(result).isEqualTo(new BigInteger("12345678901234567890"));
  }

  @Test
  public void 소수_BigDecimal_파싱() {
    String input = "123.456";
    Number result = numberParser.parseNumber(input);

    assertThat(result).isInstanceOf(BigDecimal.class);
    assertThat(result).isEqualTo(new BigDecimal("123.456"));
  }

  @Test
  public void 과학적_표기법_BigDecimal_파싱() {
    String input = "1.23e10";
    Number result = numberParser.parseNumber(input);

    assertThat(result).isInstanceOf(BigDecimal.class);
    assertThat(result).isEqualTo(new BigDecimal("1.23e10"));
  }
}
