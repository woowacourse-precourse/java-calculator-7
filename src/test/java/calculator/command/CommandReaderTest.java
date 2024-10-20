package calculator.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CommandReaderTest {
    CommandReader commandReader;

    @BeforeEach
    void beforeEach() {
        commandReader = new CommandReader();
    }

    @Test
    @DisplayName("구분자 옵션을 찾을 수 없다면 EMPTY_STRING 반환")
    void testDelimiter1() {
        String testInput = "1;2;3";

        DelimiterLine result = commandReader.readDelimiter(testInput);

        assertThat(result).isEqualTo(DelimiterLine.EMPTY_LINE);
        assertThat(result.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("구분자를 가져올 수 있어야 함")
    void testDelimiter2() {
        String testInput = "//;\\n1;2;3";

        DelimiterLine result = commandReader.readDelimiter(testInput);

        assertThat(result.value()).isEqualTo(";");
    }

    @Test
    @DisplayName("구분자를 길이는 상관없음")
    void testDelimiter3() {
        String testInput = "//;asd\\n1;2;3";

        DelimiterLine result = commandReader.readDelimiter(testInput);

        assertThat(result.value()).isEqualTo(";asd");
    }

    @Test
    @DisplayName("잘못된 prefix 구분자가 들어온다면 예외를 발생")
    void testDelimiter4() {
        String testInput = "/;\\n1;2;3";

        assertThrows(IllegalArgumentException.class, () -> commandReader.readDelimiter(testInput));
    }

    @Test
    @DisplayName("잘못된 suffix 구분자가 들어온다면 예외를 발생")
    void testDelimiter5() {
        String testInput = "//;\\a1;2;3";

        assertThrows(IllegalArgumentException.class, () -> commandReader.readDelimiter(testInput));
    }

    @Test
    @DisplayName("공백 구분자와 EMPTY 구분자는 엄연히 다름")
    void testDelimiter6() {
        String testLine = "//\\n1;2;3";

        DelimiterLine result = commandReader.readDelimiter(testLine);

        assertThat(result).isNotEqualTo(DelimiterLine.EMPTY_LINE);
        assertThat(result.value()).isEqualTo("");
        assertThat(result.isEmpty()).isFalse();
    }

    @Test
    @DisplayName("prefix와 suffix만을 제거해서 반환해줌")
    void testDelimiter7() {
        String testLine = "//aas//daaa\ns\\n";

        DelimiterLine result = commandReader.readDelimiter(testLine);
        assertThat(result.value()).isEqualTo("aas//daaa\ns");
    }


    @Test
    @DisplayName("구분자와 관계없는 숫자 라인을 읽음")
    void testNumbers1() {
        String testLine = "//a\\n1;2;3";

        assertThat(commandReader.readNumbers(testLine).value()).isEqualTo("1;2;3");
    }

    @Test
    @DisplayName("구분자 이후의 숫자 라인을 파싱하므로 잘못된 구분자가 들어온다면 예외 발생1")
    void testNumbers2() {
        String testLine = "/;\\n1;2;3";

        assertThrows(IllegalArgumentException.class, () -> commandReader.readNumbers(testLine));
    }

    @Test
    @DisplayName("구분자 이후의 숫자 라인을 파싱하므로 잘못된 구분자가 들어온다면 예외 발생2")
    void testNumbers3() {
        String testInput = "//;\\a1;2;3";

        assertThrows(IllegalArgumentException.class, () -> commandReader.readNumbers(testInput));
    }

    @Test
    @DisplayName("구분자가 없어도 숫자 라인을 읽음")
    void testNumbers4() {
        String testInput = "1234";
        assertThat(commandReader.readNumbers(testInput).value()).isEqualTo("1234");
    }

}