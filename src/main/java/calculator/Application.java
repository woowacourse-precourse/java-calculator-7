package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.StringTokenizer;

public class Application {

    public static void main(String[] args) {
        // 사용자에게 `덧셈할 문자열을 입력해 주세요.` 라고 `콘솔`을 통해 질의한다.
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // `Scanner` 를 연다.
        // `쉼표(,)`와 `콜론(:)` 같은 구분자와 `양수`로 구성된 `문자열`을 입력 받는다. (예시: "1,2:3")
        String input = Console.readLine();

        // 만약 사용자의 입력이 `빈 문자열` 일 경우, 아무런 비즈니스 로직을 취하지 않고, `결과: 0` 을 출력하고 프로그램을 종료한다.
        // `빈 문자열` 이 `null`, `empty`, `blank` 형식일 가능성에 대해서도 고려한다.
        if (input.isBlank()) {
            System.out.println("결과: 0");
        }

        // `쉼표(,)`와 `콜론(:)` 를 구분자로 등록한다.
        StringBuilder separatorBuilder = new StringBuilder();
        separatorBuilder.append("[,:");

        // 사용자의 입력값에서 `커스텀 구분자` 를 찾는다.
        if (input.contains("//") && input.contains("\\n")) {
            // `커스텀 구분자` 가 있다면 구분자로 등록한다.
            // 이때, `커스텀 구분자`는 문자열 앞부분의 `//`와 `\n` 사이에 위치하는 `특정 문자` 를 추출해서 등록한다.
            separatorBuilder.append(input.charAt(2));
            input = input.replace("\\n", "");
            input = input.substring(3);
        }
        separatorBuilder.append("]");

        // 등록된 구분자로 문자열을 분리한다.
        StringTokenizer tokens = new StringTokenizer(input, separatorBuilder.toString());
    }
}
