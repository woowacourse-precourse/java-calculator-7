package calculator.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IOHandlerTest {

  private InputHandler inputHandler;
  private OutputHandler outputHandler;
  private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    inputHandler = new InputHandler();
    outputHandler = new OutputHandler();
    System.setOut(new PrintStream(outputStream));
  }

  @Test
  void printInputTest() {
    ByteArrayInputStream in = new ByteArrayInputStream("1,2,3".getBytes());
    System.setIn(in);

    String result = inputHandler.consoleInput();

    Assertions.assertThat(result).isEqualTo("1,2,3");
  }

  @Test
  void printOutputTest() {
    String input = "1234";

    outputHandler.printOutput(Integer.parseInt(input));

    Assertions.assertThat(outputStream.toString().trim())
        .isEqualTo(String.format("결과 : %s", input));
  }
}