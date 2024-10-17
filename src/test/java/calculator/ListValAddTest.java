package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * parse한 배열을 더하여 최종값을 구하는 기능에 대한 테스트 클래스
 * 음수에 대한 예외를 발생시키며
 */
public class ListValAddTest extends NsTest {

    @Test
    @DisplayName("trim은 양 끝의 공백만 없앤다. replaceAll을 사용하여 공백값 삭제")
    public void 공백값_삭제_적용() {
        assertDoesNotThrow(() -> {
            String testVal = "1  : 2 , 3    4";

            String[] testArray = testVal.split("[:|,]");

            // 다른 기능과 동일
            int[] numberArray = new int[testArray.length];
            numberArray = Arrays.stream(testArray).mapToInt(value -> {
                try {
                    return Integer.parseInt(value.replaceAll(" ", ""));
                } catch (NumberFormatException numberFormatException) { // 숫자에 지정기호 외 값이 있다! / 음수는 통과돼야함
                    System.out.println("catch!");
                    throw new IllegalArgumentException("숫자 사이에 지정하지 않은 기호가 있습니다.");
                }
            }).toArray();
        });
    }

    @Test
    @DisplayName("공백값이 숫자 사이에 있거나, 문자열 중간에 있을 시 trim은 재역할을 못한다.")
    public void 공백_처리_오류_테스트() {
        assertThatThrownBy(() -> {
            String testVal = "1  : 2 , 3    4";

            String[] testArray = testVal.split("[:|,]");

            // 다른 기능과 동일
            int[] numberArray = new int[testArray.length];
            numberArray = Arrays.stream(testArray).mapToInt(value -> {
                try {
                    return Integer.parseInt(value.trim());
                } catch (NumberFormatException numberFormatException) { // 숫자에 지정기호 외 값이 있다! / 음수는 통과돼야함
                    System.out.println("catch!");
                    throw new IllegalArgumentException("숫자 사이에 지정하지 않은 기호가 있습니다.");
                }
            }).toArray();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("기본 기호만 사용한 문자열의 덧셈을 정확하게 수행해야한다.")
    void 기본_기호_더하기() {
        assertDoesNotThrow(() -> {
            String testVal = "1:2,3,109";
            String[] parseArray = ArrayFunction.parseNumbersFromString(testVal);

            // 숫자형 배열로 변환
            int[] numArray = Arrays.stream(parseArray).mapToInt(value -> {
                try {
                    return Integer.parseInt(value.replaceAll(" ", ""));
                } catch (NumberFormatException nfe) {
                    throw new IllegalArgumentException("숫자 사이에 지정하지 않은 기호가 존재합니다.");
                }
            }).toArray();

            int addAll = Arrays.stream(numArray).sum();

            assertThat(addAll).isSameAs(115);
        });
    }

    @Test
    @DisplayName("지정기호가 있어도 정상적인 덧셈이 되어야한다.")
    void 지정기호_덧셈_테스트() {
        assertSimpleTest(() -> {
            String testVal = "//<\\n 1:3<4,1";
            String[] parseArray = ArrayFunction.parseNumbersFromString(testVal);
            int[] numArray = Arrays.stream(parseArray).mapToInt(value -> {
                try {
                    System.out.println(Integer.parseInt(value.replaceAll(" ", "")));
                    return Integer.parseInt(value.replaceAll(" ", ""));
                } catch (NumberFormatException nfe) {
                    throw new IllegalArgumentException("지정되지 않은 기호가 문자열에 있습니다.");
                }
            }).toArray();

            int addAll = Arrays.stream(numArray).sum();

            assertThat(addAll).isSameAs(9);
        });
    }

    @Test
    @DisplayName("음수가 있다면 예외를 리턴한다.")
    void 음수_예외_리턴() {
        assertThatThrownBy(() -> {
            String testVal = "-1,2:3";
            String[] parseArray = ArrayFunction.parseNumbersFromString(testVal);

            int[] numArray = Arrays.stream(parseArray).mapToInt(value -> {
                try {
                    int idNum = Integer.parseInt(value.replaceAll(" ", ""));
                    System.out.println(Integer.parseInt(value.replaceAll(" ", "")));
                    if (idNum < 0) {
                        throw new IllegalArgumentException("숫자 중 음수가 존재하면 안됩니다.");
                    } else {
                        return idNum;
                    }
                } catch (NumberFormatException nfe) {
                    throw new IllegalArgumentException("지정되지 않은 기호가 문자열에 있습니다.");
                }
            }).toArray();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 중 음수가 존재하면 안됩니다.");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
