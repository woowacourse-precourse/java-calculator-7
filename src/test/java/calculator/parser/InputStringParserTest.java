package calculator.parser;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

class InputStringParserTest {

    private final InputStringParser inputStringParser = new InputStringParser();

    private Optional<String> invokeExtractCustomDelimiter(String input) throws NoSuchMethodException {
        Method method = inputStringParser.getClass().getDeclaredMethod("extractCustomDelimiter", String.class);
        method.setAccessible(true);

        try {
            return (Optional<String>) method.invoke(inputStringParser, input);
        } catch (IllegalAccessException | InvocationTargetException | ClassCastException e) {
            throw new RuntimeException("메서드 호출 실패", e);
        }
    }

    private String invokeRemoveCustomDelimiter(String input) throws NoSuchMethodException {
        Method method = inputStringParser.getClass().getDeclaredMethod("removeCustomDelimiterFromOriginal", String.class);
        method.setAccessible(true);

        try {
            return (String) method.invoke(inputStringParser, input);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("메서드 호출 실패", e);
        }
    }

    @Test
    @DisplayName("커스텀 구분자를 확인하고 문자열을 list로 변환한다.")
    void 문자열_변환() {
        String input = "//#@#\\n9#@#2#@#8";
        List<Long> list = inputStringParser.parse(input);

        Assertions.assertThat(list).containsExactly(9L, 2L, 8L);
    }

    @Test
    @DisplayName("기본 구분자를 확인하고 문자열을 list로 변환한다.")
    void 기본_구분자_문자열_변환() {
        String input = "9,2:8:4,2";
        List<Long> list = inputStringParser.parse(input);

        Assertions.assertThat(list).containsExactly(9L, 2L, 8L, 4L, 2L);
    }

    @Test
    @DisplayName("커스텀 구분자 확인하고 문자열 list로 변환 오류시 IllegalArgumentException 던진다.")
    void 문자열_변환_오류() {
        String input = "//#@cdcndck2nfin5!!))#\\n9#@cdcndck2nfin5!!))2#@#8";
        Assertions.assertThatThrownBy(() -> inputStringParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("커스텀 구분자를 제거한다.")
    void 커스텀_구분자_제거() throws NoSuchMethodException {
        String input = "//#@#\\n9#@#2#@#8";
        String removedCustomDelimiter = invokeRemoveCustomDelimiter(input);

        Assertions.assertThat(removedCustomDelimiter).isEqualTo("9#@#2#@#8");
    }

    @Test
    @DisplayName("커스텀 구분자를 추출한다.")
    void 커스텀_구분자_추출_테스트() throws NoSuchMethodException {
        String input = "//#@#\\n9#@#2#@#8";
        Optional<String> customDelimiter = invokeExtractCustomDelimiter(input);

        Assertions.assertThat(customDelimiter).isPresent();
        Assertions.assertThat(customDelimiter.get()).isEqualTo("#@#");
    }

    @Test
    @DisplayName("regex로 복잡한 커스텀 구분자를 추출한다.")
    void 복잡한_커스텀_구분자_추출_테스트() throws NoSuchMethodException {
        String input = "//#@cdcndck2nfin5!!))#\\n9#@#2#@#8";
        Optional<String> customDelimiter = invokeExtractCustomDelimiter(input);

        Assertions.assertThat(customDelimiter).isPresent();
        Assertions.assertThat(customDelimiter.get()).isEqualTo("#@cdcndck2nfin5!!))#");

    }

    @Test
    @DisplayName("regex 특정 prefix의 커스텀 구분자를 추출한다.")
    void 특정_커스텀_구분자_추출_테스트() throws NoSuchMethodException {
        String input = "//d\\n1d3d4";
        Optional<String> customDelimiter = invokeExtractCustomDelimiter(input);

        Assertions.assertThat(customDelimiter).isPresent();
        Assertions.assertThat(customDelimiter.get()).isEqualTo("d");
    }

    @Test
    void 커스텀_구분자_추출_테스트_실패() throws NoSuchMethodException {
        String input = "/dkd\\n2dkd4dkd5";
        Optional<String> customDelimiter = invokeExtractCustomDelimiter(input);

        Assertions.assertThat(customDelimiter).isNotPresent();
    }
}