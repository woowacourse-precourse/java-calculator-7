package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 허용되지 않습니다."); // 예외 메시지 확인 추가
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

class Application {

    public static void main(String[] args) {
        // 사용자 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("에러 : " + e.getMessage());
        }
    }

    public static int add(String input) {
        // 빈 문자열이면 0을 반환
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자 (쉼표와 콜론)
        String numbers = input;

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (matcher.matches()) {
                delimiter = Pattern.quote(matcher.group(1)); // 커스텀 구분자 설정
                numbers = matcher.group(2); // 나머지 숫자 부분
            } else {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
        }

        // 구분자 기준으로 문자열 분리
        String[] tokens = numbers.split(delimiter);

        // 숫자를 더하고, 음수 처리
        int sum = 0;
        for (String token : tokens) {
            try {
                int num = Integer.parseInt(token);
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                }
                sum += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
            }
        }

        return sum;
    }
}
