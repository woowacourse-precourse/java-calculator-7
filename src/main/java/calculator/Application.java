package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    // 커스텀 구분자를 생성하고 검증하는 단계에서 여러 번 사용하기 때문에 필드값으로 지정
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\\\\n(.*)";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // 덧셈할 문자열 입력
        String input = Console.readLine();

        try {
            // 검증하고 계산까지 된 결과를 result 변수에 저장
            int result = calculateProcess(input);

            // 결과 출력
            System.out.println("결과 : " + result);

        } catch (IllegalArgumentException e) {

            // 검증 실패하면 에러 메시지 출력
            System.err.println(e.getMessage());
        }
    }

    // 입력된 문자열을 받아 검증하고 계산하는 메서드
    public static int calculateProcess(String input) {

        // 아무것도 입력하지 않으면 결과는 0으로 출력
        if (input.isEmpty()) {
            return 0;
        }

        // 기본 구분자로 초기화
        String separator = ",|:";

        // 사용자 입력에서 숫자(문자열)
        String numberPart = input;

        // 커스텀 구분자가 존재하는지 확인하는 조건문
        if (existCustomSeparator(input)) {

            // 커스텀 구분자가 숫자인지 검증하는 메서드 호출
            isNumber(findCustomSeparator(input));

            // 커스텀 구분자가 존재한다면 구분자를 추출해서 separator 변수에 저장
            // 기본 구분자와 커스텀 구분자를 같이 사용할 수 있게 "|" 추가
            separator += "|" + findCustomSeparator(input);

            // 커스텀 구분자 생성하는 부분 자르고 문자열 가져오기
            numberPart = input.substring(input.lastIndexOf("n") + 1);
        }

        // 구분자를 이용해 숫자(문자열) 분리
        String[] cutNumberPartArr = numberPart.split(separator);

        // 문자열 배열에 있는 숫자(문자열)를 검증하는 메서드 호출
        validateInputNumberPart(cutNumberPartArr);

        // 계산 후 결과 값을 리턴
        return addCalc(cutNumberPartArr);
    }

    // 사용자 입력에서 숫자(문자열)를 검증하는 메서드
    private static void validateInputNumberPart(String[] inputArr) {
        for (String str : inputArr) {
            // 0보다 큰지 확인. 그리고 숫자 형식인지 확인
            if (!str.matches("^[1-9]\\d*$")) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }
        }
    }

    // 커스텀 구분자가 존재하는지 검증하는 메서드
    private static boolean existCustomSeparator(String input) {
        return input.matches(CUSTOM_SEPARATOR_REGEX);
    }

    // 커스텀 구분자를 찾는 메서드
    private static String findCustomSeparator(String input) {

        // 정규 표현식을 컴파일하고, 입력 문자열에 대해 매처를 생성
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(input);

        // 입력 문자열에서 패턴과 일치하는 부분이 있는지 확인
        if (m.find()) {
            // 일치하는 부분이 있으면 일치하는 그룹 중 첫 번째 그룹의 값을 반환
            return m.group(1);
        } else {
            return null;
        }
    }

    // 커스텀 구분자가 숫자인지 검증하는 메서드
    private static void isNumber(String input) {
        // 숫자 형식인지 확인
        if (input.matches("^\\d*$")) {
            throw new IllegalArgumentException("숫자로 커스텀 구분자를 만들 수 없습니다.");
        }
    }

    // 문자열을 덧셈하는 메서드
    private static int addCalc(String[] cutStringArr) {
        int result = 0;

        // 문자열에서 정수로 변환 후 result에 합계를 저장
        for (String str : cutStringArr) {
            result += Integer.parseInt(str);
        }

        return result;
    }
}
