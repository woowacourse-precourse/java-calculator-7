package calculator.stringAdder.delimiterParser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 18.
 */
class DelimiterParserTest {
  private DelimiterParser delimiterParser;

  @BeforeEach
  void setUp(){
    delimiterParser = new DelimiterParser();
  }

  @Test
  void getDelimiters_defaultDelimiters_success() {
    String input = "1,2:3";
    String[] expected = {",",":"};
    assertArrayEquals(expected, delimiterParser.getDelimiters(input));
  }

  @Test
  void getDelimiters_defaultDelimiters_withoutCustomDelimiters_success() {
    String input = "/1,2:3";
    String[] expected = {",",":"};
    assertArrayEquals(expected, delimiterParser.getDelimiters(input));
  }


  @Test
  void getDelimiters_customDelimiters_success(){
    String input = "//;\\n1;2;3";
    String[] expected = {",", ":", ";"};
    assertArrayEquals(expected, delimiterParser.getDelimiters(input));
  }

  @ParameterizedTest
  @ValueSource(strings = {"//n1,2,3", "//\n1,2,3", "//n1,2,34", "//;1;2;3"})
  void getDelimiters_invalidCustomDelimiters_fail(String input) {
    Exception exception = assertThrows(IllegalArgumentException.class, () ->
        delimiterParser.getDelimiters(input)
    );
    String expectedMessage = "DelimiterParser: 올바르지 않은 커스텀 구분자 설정입니다.";
    assertTrue(exception.getMessage().contains(expectedMessage));
  }

  @ParameterizedTest
  @ValueSource(strings = {"//0\\n1;2;3", "//1\\n1;2;3", "//2\\n1;2;3", "//3\\n1;2;3",
      "//4\\n1;2;3", "//5\\n1;2;3", "//6\\n1;2;3", "//7\\n1;2;3",
      "//8\\n1;2;3", "//9\\n1;2;3"})
  void getDelimiters_invalidCustomDelimitersNumber_fail(String input) {
    Exception exception = assertThrows(IllegalArgumentException.class, () ->
        delimiterParser.getDelimiters(input)
    );
    String expectedMessage = "DelimiterParser: 숫자는 구분자로 사용할 수 없습니다.";
    assertTrue(exception.getMessage().contains(expectedMessage));
  }

  @Test
  void getDelimiters_multipleCustomDelimiters_fail() {
    String input = "//;,\\n1;2,3";
    Exception exception = assertThrows(IllegalArgumentException.class, () ->
        delimiterParser.getDelimiters(input)
    );
    String expectedMessage = "DelimiterParser: 올바르지 않은 커스텀 구분자 설정입니다.";
    assertTrue(exception.getMessage().contains(expectedMessage));
  }
}