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
import org.junit.jupiter.params.provider.CsvSource;
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
  private String capturedResult;

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

  @ParameterizedTest
  @CsvSource({
      "1;2;3",
      "10;20;30",
      "5;15;25;35",
  })
  void validateInput_validInput_success(String input) {
    provideInput(input);
    String result = inputValidator.validateInput();
    assertEquals(input, result);
    assertTrue(outputStreamCaptor.toString().contains("덧셈할 문자열을 입력해주세요."));
  }

  @Test
  void validateInput_emptyStringvalidInput_success() {
    String input = "";
    final String[] result = new String[1];
    //provideInput(input);

    assertSimpleTest(() -> {
      run(input);
      assertEquals("", this.capturedResult);
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

  protected  void setCapturedResult(String result){
    this.capturedResult = result;
  }

  @Override
  protected void runMain() {
    String result = inputValidator.validateInput();
    setCapturedResult(result);
  }
}