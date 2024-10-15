package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }




    @DisplayName("test")
    @Test
    void test(){
        String s = "//;\n4;5;6;7!#!#@;//;dw\n//;55\n//;e34\n//;g45\n";
        String input = "hello beautiful world";

//        Pattern pattern = Pattern.compile("^//+.*+\\n$");
        Pattern pattern = Pattern.compile("^//+(.*)\\n+(.*)");
        Matcher matcher = pattern.matcher(s);

        if (matcher.find()) {
            String group = matcher.group(1);
            System.out.println("----- custom : "+group);

            String[] split = s.split(group);
            for(int i = 0; i < split.length; i++) {
                System.out.println(i + " : " + split[i]);
            }
        }else {
            System.out.println("----- No found -----");
        }



        String s2 = "//;\n4;5234920941823909324O93;623498209348193245803846909434343;7123123513543245234!#!#@;//;dw\n//;523492304982390481092128901293091201241242345\n//;2342984029890942830957271₩834\n//;23284890238081904809182949172445\n";


    }
}
