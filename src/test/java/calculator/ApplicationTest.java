package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("빈 문자열 입력 시 0을 반환해야한다.")
    void should_returnZero_when_inputIsEmpty() {
        int result = Application.calculateSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("쉼표를 구분자로 사용해 문자열에 포함된 숫자를 배열로 반환한다")
    void should_returnDigitArray_when_CommaSeparatedString() {
        List<Integer> result = Application.parseInput("1,2, 15");
        assertThat(result).isEqualTo(List.of(1, 2, 15));
    }

    @Test
    @DisplayName("콜론을 구분자로 사용해 문자열에 포함된 숫자를 배열로 반환한다.")
    void should_returnDigitArray_when_ColonSeparatedString() {
        List<Integer> result = Application.parseInput("1:2: 15");
        assertThat(result).isEqualTo(List.of(1, 2, 15));
    }

    @Test
    @DisplayName("커스텀 구분자를 사용해 문자열에 포함된 숫자를 배열로 반환한다.")
    void should_returnDigitArray_when_CustomDelimiterSeparatedString() {
        List<Integer> result = Application.parseInput("//;\\n1;2");
        assertThat(result).isEqualTo(List.of(1, 2));
    }

    @Test
    @DisplayName("배열의 요소를 더한 값을 반환한다.")
    void should_returnSumOfDigitArray() {
        int result = Application.calculateSum("//a\\n1a2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("잘못된 숫자 형식이 포함된 경우 예외가 발생해야 한다.")
    void should_ThrowException_when_InvalidNumberFormat() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    Application.calculateSum("//;\\1;2;3");
                }),
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    Application.calculateSum("//;\\n1;2;-3");
                })
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
