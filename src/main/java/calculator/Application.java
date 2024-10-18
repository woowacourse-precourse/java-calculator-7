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
        String separator = separatorBuilder.toString();
        StringTokenizer tokens = new StringTokenizer(input, separator);

        int result = 0;
        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken();

            // 숫자가 아닌 문자가 입력되었을 때
            // 이때 구분자를 기준으로 split 하기 때문에, 숫자인지만 검증해도 괜찮다.
            // NumberFormatException 이 더 하위 레벨(더 명확한)의 예외인데, try-catch 로 잡아낼지에 대한 고민
            if (!token.matches("[0-9]")) {
                throw new IllegalArgumentException("숫자가 아닌 값은 계산할 수 없습니다.");
            }

            // 분리된 문자열을 모두 `정수` 로 `파싱` 하고 숫자들을 등록한다.
            int number = Integer.parseInt(token);
            // 분리된 문자열이 모두 `양의 숫자값` 인지 확인한다.
            if (number < 0) {
                // 아닌 경우 예외를 throw 한다.
                throw new IllegalArgumentException("숫자는 양수여야 합니다.");
            }

            // 파싱된 숫자들을 모두 더한다.
            result += number;
        }

        System.out.println("결과 : " + result);
    }
}
