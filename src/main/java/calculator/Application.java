package calculator;

import camp.nextstep.edu.missionutils.Console; // 콘솔 입력을 위한 라이브러리

public class Application {

    // 주어진 입력에서 커스텀 구분자를 추출하는 메서드
    public static String getCustomSeparator(String input) {
        // 입력이 커스텀 구분자 형식인지 확인
        if (input.startsWith("//") && input.length() > 3 && input.substring(3, 5).equals("\\n")) {
            // 구분자로 사용할 문자를 반환
            return Character.toString(input.charAt(2));
        } else {
            // 커스텀 구분자가 없으면 null 반환
            return null;
        }
    }

    // 주어진 입력 문자열을 구분자를 기준으로 나누는 메서드
    public static String[] splitString(String input) {
        String separator = getCustomSeparator(input); // 커스텀 구분자 추출
        if (separator != null) {
            // 커스텀 구분자가 사용된 경우, 입력에서 구분자 부분을 제거
            input = input.substring(5); // "//;\n" 부분 제거
        } else {
            // 기본 구분자(콤마와 콜론) 설정
            separator = ",|:";
        }
        // 주어진 입력 문자열을 구분자로 나누어 문자열 배열로 반환
        return input.split(separator);
    }

    // 입력된 숫자 문자열을 계산하여 합계를 반환하는 메서드
    public static int calculate(String input) {
        // 입력이 null이거나 비어있으면 0 반환
        if (input == null || input.isEmpty()) {
            return 0; // 빈 문자열 입력 처리
        }
        int sum = 0; // 합계 초기화
        String[] numbers = splitString(input); // 문자열을 숫자 배열로 분리

        // 각 숫자에 대해 처리
        for (String number : numbers) {
            // 음수가 포함되어 있으면 예외 발생
            if (number.contains("-")) {
                throw new IllegalArgumentException("음수 기능은 지원하지 않습니다.");
            }
            // 문자열을 정수로 변환하고 합산
            sum += Integer.parseInt(number);
        }
        return sum; // 최종 합계 반환
    }

    public static void main(String[] args) {
        String input = Console.readLine(); // 콘솔에서 입력 받기
        int sum = calculate(input); // 입력을 계산하여 합계 얻기
        System.out.println("결과 : " + sum); // 계산 결과 출력
    }
}
