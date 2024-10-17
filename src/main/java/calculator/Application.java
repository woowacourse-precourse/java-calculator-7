package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    // 커스텀 구분자 관련해서 여러 번 사용하기 때문에 필드값을 지정
    private static final String CUSTOM_SEPARATOR = "//(.)\\\\n(.*)";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // 덧셈할 문자열 입력
        String input = Console.readLine();

        // 기본 구분자로 초기화
        String separator = ",|:";

        // 아무것도 입력하지 않으면 결과는 0으로 출력
        if (input.isEmpty()) {
            System.out.println("결과: 0");
            return;
        }

        // 커스텀 구분자가 존재한다면 구분자를 추출해서 separator 변수에 저장하고,
        // 존재하지 않으면 결과를 출력
        // (기본 구분자를 사용한다면 문자열 분리 후 계산, 사용하지 않는다면 정수로 변환 후 출력)(예정)
        if (exitsCustomSeparator(input)) {
            separator = findCustomSeparator(input);
            System.out.println(separator);
        } else {
            System.out.println("결과 : " + Integer.parseInt(input));
            return;
        }

        try {
            validateInput(input);
            System.out.println("유효한 입력입니다: " + input);
        } catch (IllegalArgumentException e) {
            // 에러 메시지 출력
            System.err.println(e.getMessage());
        }

    }

    // 사용자 입력을 검증하는 함수
    private static void validateInput(String input) {
        // 0보다 큰지 확인. 그리고 숫자 형식인지 확인
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    // 커스텀 구분자가 존재하는지 검증하는 함수
    private static boolean exitsCustomSeparator(String input) {
        return input.matches(CUSTOM_SEPARATOR);
    }

    // 커스텀 구분자를 찾는 함수
    private static String findCustomSeparator(String input) {

        // 정규 표현식을 컴파일하고, 입력 문자열에 대해 매처를 생성
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR).matcher(input);

        // 입력 문자열에서 패턴과 일치하는 부분이 있는지 확인
        if (m.find()) {
            // 일치하는 부분이 있으면 일치하는 그룹 중 첫 번째 그룹의 값을 반환
            return m.group(1);
        } else {
            return null;
        }
    }
}
