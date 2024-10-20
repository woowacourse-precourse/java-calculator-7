package calculator.parser;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class DelimiterParserTest{

  private final DelimiterParser parser = new BasicDelimiterParser();

  @Test
  void 기본_구분자_테스트(){
    String input = "1,2e-3:3";
    String[] result = parser.parse(input);
    String[] expected = {"1", "2e-3", "3"};
    assertArrayEquals(expected, result);
  }

  @Test
  void 커스텀_구분자_테스트(){
    String input = "//#\n123#234#345";
    String[] result = parser.parse(input);
    String[] expected = {"123", "234", "345"};
    assertArrayEquals(expected, result);
  }

  @Test
  void 복합_구분자_테스트(){
    String input = "//#\n0.1,2.3:3e+10#4#5";
    String[] result = parser.parse(input);
    String[] expected = {"0.1", "2.3", "3e+10", "4", "5"};
    assertArrayEquals(expected, result);
  }

  @Test
  void 빈_입력_테스트(){
    String input = "";
    String[] result = parser.parse(input);
    String[] expected = {""};
    assertArrayEquals(expected, result);
  }
}
