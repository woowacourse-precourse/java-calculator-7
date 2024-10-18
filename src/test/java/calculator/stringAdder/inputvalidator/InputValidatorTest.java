package calculator.stringAdder.inputvalidator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import camp.nextstep.edu.missionutils.Console;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 18.
 */
// 더 상세한 테스트는 StringAddertTest에서 하도록 한다.
class InputValidatorTest extends NsTest{
  private InputValidator inputValidator;
  private final InputStream standardIn = System.in;
  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  void setUp(){
    inputValidator = new InputValidator();
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @AfterEach
  void tearDown(){
    Console.close();
    System.setIn(standardIn);
    System.setOut(standardOut);
  }

  @Test
  void validateInput_validInput_success() {
    String input = "1,2,3";
    provideInput(input);

    String result = inputValidator.validateInput();

    assertEquals(input, result);
    assertTrue(outputStreamCaptor.toString().contains("덧셈할 문자열을 입력해주세요."));
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "\n"})
  void validateInput_emptyInput_fail(String input) {
    provideInput(input);

    Exception exception = assertThrows(IllegalArgumentException.class,
        () -> inputValidator.validateInput());

    String expectedMessage = "InputValidator: NoSuchElementException, 입력한 문자열이 비었습니다.";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "\n"})
  void validateInput_emptyInput_fail_usingAssertSimpleTest(String input) {
    assertSimpleTest(() -> {
      assertThatThrownBy(() -> run(input))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("입력한 문자열이 비었습니다.");
    });
  }

  @Test
  void validateInput_nullInput_fail() {
    provideInput(null);

    Exception exception = assertThrows(IllegalArgumentException.class,
        () -> inputValidator.validateInput());

    String expectedMessage = "InputValidator: NoSuchElementException, 입력한 문자열이 비었습니다.";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void validateInput_nullInput_fail_usingAssertSimpleTest() {
    assertSimpleTest(() -> {
      assertThatThrownBy(() -> run())
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("입력한 문자열이 비었습니다.");
    });
  }

  private void provideInput(String data) {
    InputStream testIn;
    if (data == null || data.equals("") || data.equals("\n")) {
      testIn = new ByteArrayInputStream("".getBytes());
    } else {
      testIn = new ByteArrayInputStream(data.getBytes());
    }
    System.setIn(testIn);
  }

  @Override
  protected void runMain() {
    inputValidator.validateInput();
  }
}