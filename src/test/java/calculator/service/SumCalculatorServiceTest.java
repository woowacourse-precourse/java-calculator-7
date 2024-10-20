package calculator.service;

import calculator.error.ErrorCode;
import calculator.parser.BasicDelimiterParser;
import calculator.parser.BasicNumberParser;
import calculator.validator.BasicNumberValidator;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SumCalculatorServiceTest {

  private StringSumCalculatorService calculatorService;

  @BeforeEach
  public void setUp() {
    calculatorService = new StringSumCalculatorService(
        new BasicDelimiterParser(),
        new BasicNumberParser(),
        new BasicNumberValidator()
    );
  }

  @Test
  public void 빈_문자열_처리() {
    String result = calculatorService.calculate("");
    assertThat(result).isEqualTo("0");
  }

  @Test
  public void 기본_구분자_정수_처리() {
    String result = calculatorService.calculate("1,2,3");
    assertThat(result).isEqualTo("6");
  }

  @Test
  public void 커스텀_구분자_정수_처리(){
    String result = calculatorService.calculate("//;\\n1;2;3,4:5");
    assertThat(result).isEqualTo("15");
  }

  @Test
  public void 기본_구분자_큰_정수_BigInteger_처리() {
    BigInteger bi = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.TEN);
    String lmax = String.valueOf(Long.MAX_VALUE);

    String result = calculatorService.calculate(lmax + ",10");
    assertThat(result).isEqualTo(bi.toString());
  }

  @Test
  public void 커스텀_구분자_큰_정수_BigInteger_처리() {
    BigInteger bi = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.TEN);
    String lmax = String.valueOf(Long.MAX_VALUE);

    String result = calculatorService.calculate("//;\\n" + lmax + ";10");
    assertThat(result).isEqualTo(bi.toString());
  }

  @Test
  public void 기본_구분자_소수_BigDecimal_처리() {
    BigDecimal bd = new BigDecimal("1.5").add(new BigDecimal("2.75")).add(new BigDecimal("3"));
    String result = calculatorService.calculate("1.5,2.75,3");

    assertThat(result).isEqualTo(bd.toString());
  }

  @Test
  public void 커스텀_구분자_소수_BigDecimal_처리() {
    BigDecimal bd = new BigDecimal("1.5").add(new BigDecimal("2.75")).add(new BigDecimal("3"));
    String result = calculatorService.calculate("//;\\n1.5;2.75;3");

    assertThat(result).isEqualTo(bd.toString());
  }

  @Test
  public void 기본_구분자_과학적_표기법_BigDecimal_처리() {
    BigDecimal bd = new BigDecimal("1e+5").add(new BigDecimal("2e+5"));
    String result = calculatorService.calculate("1e+5,2e+5");

    assertThat(result).isEqualTo(bd.toPlainString());
  }

  @Test
  public void 커스텀_구분자_과학적_표기법_BigDecimal_처리() {
    BigDecimal bd = new BigDecimal("1e+5").add(new BigDecimal("2e+5"));
    String result = calculatorService.calculate("//$\\n1e+5$2e+5");

    assertThat(result).isEqualTo(bd.toPlainString());
  }

  @Test
  public void 기본_구분자_혼합_처리(){
    BigDecimal lmax = new BigDecimal(Long.MAX_VALUE);
    BigDecimal bd = new BigDecimal("1.5").add(new BigDecimal("2.75")).add(lmax)
        .add(new BigDecimal("1e+5")).add(lmax.add(BigDecimal.ONE));

    String input = "1.5:2.75:" + lmax + ",1e+5,9223372036854775808";
    String result = calculatorService.calculate(input);
    assertThat(result).isEqualTo(bd.toString());
  }

  @Test
  public void 커스텀_구분자_혼합_처리(){
    BigDecimal lmax = new BigDecimal(Long.MAX_VALUE);
    BigDecimal bd = new BigDecimal("1.5").add(new BigDecimal("2.75")).add(lmax)
        .add(new BigDecimal("1e+5")).add(lmax.add(BigDecimal.ONE));

    String input = "//;\\n1.5;2.75:" + lmax + ",1e+5;9223372036854775808";
    String result = calculatorService.calculate(input);
    assertThat(result).isEqualTo(bd.toString());
  }

  @Test
  public void 잘못된_숫자_문자_입력_예외() {
    assertThatThrownBy(() -> calculatorService.calculate("1,abc,3"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ErrorCode.INVALID_NUMBER_FORMAT.toString());
  }

  @Test
  public void 잘못된_숫자_음수_입력_예외() {
    assertThatThrownBy(() -> calculatorService.calculate("1,-2,3"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ErrorCode.NEGATIVE_NUMBER_ERROR.toString());
  }

  @Test
  public void 잘못된_숫자_빈_입력_예외() {
    assertThatThrownBy(() -> calculatorService.calculate("1,,3"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ErrorCode.EMPTY_NUMBER_ERROR.toString());
  }
}
