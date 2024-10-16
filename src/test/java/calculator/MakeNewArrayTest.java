package calculator;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MakeNewArrayTest extends NsTest {

    @Test
    @DisplayName("원하는대로 구분자가 분리될까?")
    void 커스텀_구분자_테스트() {
        assertSimpleTest(() -> {
            //String testVal = "//(\\n1";
            String testVal2 = "//()\\n1";

            String customSymbol = "";

            Pattern pattern = Pattern.compile("//(.*?)\\\\n");
            Matcher matcher = pattern.matcher(testVal2);

            while (matcher.find()) {
                customSymbol = matcher.group(1);
            }

            System.out.println("custom = " + customSymbol);

            assertThat(customSymbol).isEqualTo("()");

        });
    }

    @Test
    @DisplayName("NumberFormatExcep에 걸리지 않는 잘못된 문자열을 확인했을 때 IllegalArgumentExcep 발생해야함")
    void 잘못된_문자열_예외처리() {
        String testVal = "d//#@\\n1:3,4:5"; // //로 시작하지 않는다.
        boolean startSlash = testVal.startsWith("//");

        assertThatThrownBy(() -> {
            if (!startSlash) {
                throw new IllegalArgumentException("문자열은 //로 시작해야합니다.");
            }
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("구분자를 포함한 문자열 덧셈 시작")
    void 구분자_포함_문자열_덧셈() {
        String testVal = "//!\\n1!2!3";

        assertSimpleTest(() -> {
            int number = 0;
            String customSymbol = "";

            Pattern pattern = Pattern.compile("//(.*?)\\\\n");
            Matcher matcher = pattern.matcher(testVal);

            while (matcher.find()) {
                customSymbol = matcher.group(1);
            }

            String deleteSymbol = testVal.replaceAll("//.*?\\\\n", "");
            System.out.println("deleteSymbol = " + deleteSymbol);
            // \\Q와 \\E사이에 있는 문자는 문자 그대로 인식되도록 이스케이프 처리된다.
            String[] returnList = deleteSymbol.split("\\Q" + customSymbol + "\\E");

            for (String value : returnList) {
                number += Integer.parseInt(value);
            }

            assertThat(number).isEqualTo(6);
        });
    }

    @Test
    @DisplayName(",과 :만 있는 기본 문자열이 들어왔을 때 정상적인 배열 생성이 돼야한다.")
    void 기본_덧셈_테스트() {
        String testVal = "1,2:3";
        String[] testArray = testVal.split("[,:]");
        assertSimpleTest(() -> {
            String arrayVal = Arrays.toString(testVal.split("[,:]"));
            assertThat(arrayVal).isEqualTo("[1, 2, 3]"); // 의도한대로 값이 잘 나눠졌는가?

            int returnVal = 0; // 리턴할 정답

            for (String number : testArray) {// 숫자 더하기
                returnVal += Integer.parseInt(number);
            }

            assertThat(returnVal).isEqualTo(6);
        });
    }

    @Test
    @DisplayName("커스텀 기호가 있을 때 정상적인 배열생성이 되어야한다.")
    void 커스텀기호_숫자형_배열_만들기() {
        assertSimpleTest(() -> {
            String testVal1 = "//(\\n1(2(3";

            // 우선 특수기호를 구한다.
            String customSymbol = "";
            Pattern pattern = Pattern.compile("//(.*?)\\\\n");
            Matcher matcher = pattern.matcher(testVal1);

            while (matcher.find()) {
                customSymbol = matcher.group(1);
            }

            // 커스텀 기호를 문자열에서 삭제한다.
            testVal1 = testVal1.replaceAll("//.*?\\\\n", "");

            // 남은 문자열을 가지고 숫자형 배열을 생성한다.
            String[] testArray = testVal1.split("\\Q" + customSymbol + "\\E"); // 기본 기호를 기준으로 문자열 배열 생성
            System.out.println("testArray = " + Arrays.toString(testArray));

            int[] numArray = new int[testArray.length];
            for (int i = 0; i < numArray.length; i++) {
                numArray[i] = Integer.parseInt(testArray[i]);
            }
            assertThat(numArray[0]).isSameAs(1);
        });
    }

    @Test
    @DisplayName("기본 기호와 커스텀 기호가 둘다 존재할 때 정상적인 숫자형 배열 생성이 돼야한다.")
    void 기본_커스텀_기호_숫자형_배열_만들기() {
        String testVal = "//?\\n1:4?3,5";

        // 우선 특수기호를 구한다.
        String customSymbol = "";
        Pattern pattern = Pattern.compile("//(.*?)\\\\n");
        Matcher matcher = pattern.matcher(testVal);

        while (matcher.find()) {
            customSymbol = matcher.group(1);
        }

        testVal = testVal.replaceAll("//.*?\\\\n", "");

        String[] testArray = testVal.split("[:|,|"+ customSymbol + "]");
        System.out.println("testArray = " + Arrays.toString(testArray));

        int[] numArray = new int[testArray.length];
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = Integer.parseInt(testArray[i]);
        }

        assertThat(numArray[1]).isSameAs(4);
    }

    @Test
    @DisplayName("커스텀 기호를 포함하지 않았을때 로직테스트, 기본 문자열 테스트와 비슷함")
    void 기본_기호_숫자형_배열_만들기() {
        assertSimpleTest(() -> {
            String testVal2 = "1:2,3:4";

            String[] testArray = testVal2.split("[:|,]"); // 기본 기호를 기준으로 문자열 배열 생성
            System.out.println("testArray = " + Arrays.toString(testArray));

            int[] numArray = new int[testArray.length];
            for (int i = 0; i < numArray.length; i++) {
                numArray[i] = Integer.parseInt(testArray[i]);
            }
            System.out.println("Arrays.toString(numArray) = " + Arrays.toString(numArray));

            assertThat(numArray[3]).isSameAs(4);
        });
    }

    @Test
    @DisplayName("숫자형 배열만들기 기능 최종 테스트 코드")
    void 숫자형_배열_만들기_최종_테스트() {
        assertDoesNotThrow(() -> { // 예외를 던지면 안된다!
            String[] testValArray = {"1:5,3,10", "//<\\n10,15<30:200", "//^\\n99^23^18^10","<//>\\n12>23,15:19"};
            String customSymbol = "";

            for (int i = 0; i < testValArray.length; i++) {
                String[] testArray;
                if(testValArray[i].startsWith("//")){// 커스텀 기호 포함!
                    // 우선 특수기호를 구한다.
                    Pattern pattern = Pattern.compile("//(.*?)\\\\n");
                    Matcher matcher = pattern.matcher(testValArray[i]);

                    while (matcher.find()) {
                        customSymbol = matcher.group(1);
                    }

                    testValArray[i] = testValArray[i].replaceAll("//.*?\\\\n", "");
                }

                if(customSymbol.equals("")){
                    testArray = testValArray[i].split("[:|,]");
                }else{
                    testArray = testValArray[i].split("[:|,|"+ customSymbol + "]");
                }
                System.out.println((i+1) + "번째 숫자형 배열 : " + Arrays.toString(testArray)); // return testArray;
            }
        });
    }

    @Test
    @DisplayName("실제 코드 적용시 정상여부 테스트 1번")
    public void 실제코드_적용_1번() {
        assertSimpleTest(() -> {
            run("//>\\n1:2,3");
            assertThat(output()).contains("[1, 2, 3]");
        });
    }

    @Override
    protected void runMain() {

    }
}
