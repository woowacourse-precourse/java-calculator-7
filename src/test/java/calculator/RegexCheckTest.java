package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegexCheckTest {
  private Calculator calculator;
  protected String sort = ",:";
  protected String regex = "^[" + sort + "]?[1-9][0-9]*([" + sort + "][1-9][0-9]*)*$";
  private static final String SORT = "^//[^0-9\\\\n]\\\\n([^\\\\n]+)$";
  private String strNumber;
  private String strSort;
  protected String input;

  @BeforeEach
  public void setUp() {
    calculator = new Calculator("//;\\n1;2;3");

  }

  @Test
  public void testIsSort() {
    assertTrue(calculator.isSort());
  }

  @Test
  public void testSortCheck() {
    String[] split = calculator.input.split("\\\\n");
    strSort = split[0];
    strNumber = split[1];
    sort = String.valueOf(strSort.charAt(2));
    String regex = "^[" + sort + "]?[1-9][0-9]*([" + sort + "][1-9][0-9]*)*$";

    if(strNumber.matches(regex)){
      calculator.intChange(strNumber.split(sort));
      System.out.println(Arrays.toString(calculator.numbers));
    }else{
      throw new IllegalArgumentException("지정 구분자로 숫자를 구분해주세요");
    };

    assertTrue(strNumber.matches(regex));
  }
}
